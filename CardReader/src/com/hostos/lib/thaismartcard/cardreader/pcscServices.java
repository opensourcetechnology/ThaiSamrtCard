
package com.hostos.lib.thaismartcard.cardreader;

import com.hostos.lib.thaismartcard.api.ByteUtils;
import com.hostos.lib.thaismartcard.api.CID;
import com.hostos.lib.thaismartcard.api.LaserNumber;
import com.hostos.lib.thaismartcard.api.SmartCardServices;
import com.hostos.lib.thaismartcard.converter.Converter;
import com.hostos.lib.thaismartcard.converter.ConverterFactory;
import com.hostos.lib.thaismartcard.converter.Spec;
import com.hostos.lib.thaismartcard.converter.SpecPropertyReader;
import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import com.hostos.lib.thaismartcard.model.Name;
import com.hostos.lib.thaismartcard.model.NhsoAppletInfo;
import com.hostos.lib.thaismartcard.model.OldMoiApplet1Info;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.smartcardio.*;

public class pcscServices implements SmartCardServices{
    
    private static final Logger log = Logger.getLogger(pcscServices.class.getName());
    private static final CardReader INSTANCE = new CardReader();
    private List<CardTerminal> cardTerminals = INSTANCE.getCardTerminals();
    private ConverterFactory converterFact = new ConverterFactory();
    
    //use static to easy send values and call values.
    private static MoiApplet1Info moi = new MoiApplet1Info();
    private static NhsoAppletInfo nhso = new NhsoAppletInfo();
    
    public pcscServices(){
        log.info("Ues JPCSC for access smart card.");
    }

    private void readAndfillData(Card card, List<Spec> specs, Object bean, boolean readPicture) throws CardException {
        //Call CardChanell of libary of Card.
        CardChannel channel = card.getBasicChannel();
        
        for (Spec spec : specs) {
            if ((readPicture)
                    || (!spec.getSettingMethod().getName().equals("setFacesImage"))) {
                
                ByteBuffer allocate;
                
                if (spec.getApduCommands().length > 1) {
                    
                    allocate = ByteBuffer.allocate(5120);
                    
                    for (int i = 0; i < spec.getApduCommands().length; i++) {
                        
                        CommandAPDU command = new CommandAPDU(spec.getApduCommands()[i]);
                        
                        //check error of bytecode.
                        if (log.isLoggable(Level.FINEST)) {
                            log.log(Level.INFO, "<-------{0}", ByteUtils.htos(command.getBytes()));
                        }
                        
                        //trnsmit of bytecode.
                        ResponseAPDU response = channel.transmit(command);
                        allocate.put(response.getData());   
                        
                    }
                } else {
                    allocate = ByteBuffer.allocate(256);

                    CommandAPDU command = new CommandAPDU(spec.getApduCommands()[0]);
                    
                    //check error of bytecode.
                    if (log.isLoggable(Level.FINEST)) {
                        log.log(Level.INFO, "<-------{0}", ByteUtils.htos(command.getBytes()));
                    }
                    
                    //trnsmit of bytecode.
                    ResponseAPDU response = channel.transmit(command);
                    allocate.put(response.getData());   
                }
                
                //Call method set such as setFaceImage(),setPID() etc.
                Method settingMethod = spec.getSettingMethod();
                try {
                    //send settingMethod to kept in interfaceClass of Converter.
                    Converter converter = converterFact.getConverter(settingMethod.getParameterTypes()[0]);
                    
                    settingMethod.invoke(bean, new Object[]{converter.toObject(allocate.array())});
                    allocate = null;
                } catch (Exception ex) {
                    //check value null or other.
                    ex.printStackTrace();
                }
            }
        }
    }

    public synchronized Map<Class, Object> getAvialableDataInfo(Card cardManager, boolean readPicture) throws CardException, IOException {
        CardChannel channel = cardManager.getBasicChannel();
        Map map = new HashMap();
        ByteBuffer allocate;
        try {
            
            //Check status of Card.
            log.log(Level.INFO, "card status: " + CardTerminals.State.ALL);
            
            //encode of card.
            byte[] selectOldMoiCommand = ByteUtils.stoh("00A4040008A000000054480011");
            byte[] selectMoiCommand = ByteUtils.stoh("00A4040008A000000054480001");
            byte[] selectNHSOCommand = ByteUtils.stoh("00A4040008A000000054480083");
            
            CommandAPDU commands = new CommandAPDU(selectOldMoiCommand);
            ResponseAPDU response = channel.transmit(commands);
            if (response.getSW() == 9000) {
                moi.setOldCard(true);
                moi.setCardType(24);
                commands = new CommandAPDU(selectMoiCommand);
                
                //transmit byte value to chanel and send value to readAnfillData method.
                channel.transmit(commands);
                readAndfillData(cardManager, SpecPropertyReader.getInstance().getSpecs(OldMoiApplet1Info.class), moi, readPicture);
                
                //put value in MoiApplet1Info class.
                map.put(MoiApplet1Info.class, moi);
                
            } else {
                moi.setOldCard(false);
                moi.setCardType(26);
                commands = new CommandAPDU(selectMoiCommand);
                
                //transmit byte value to chanel and send value to readAnfillData method.
                channel.transmit(commands);
                
                readAndfillData(cardManager, SpecPropertyReader.getInstance().getSpecs(MoiApplet1Info.class), moi, readPicture);
                
                //put value in MoiApplet1Info class.
                map.put(MoiApplet1Info.class, moi);
                
                commands = new CommandAPDU(selectNHSOCommand);
                
                //transmit byte value to chanel and send value to readAnfillData method.
                channel.transmit(commands);
                readAndfillData(cardManager, SpecPropertyReader.getInstance().getSpecs(NhsoAppletInfo.class), nhso, false);
                
                //put value in NhsoAppletInfo class.
                map.put(NhsoAppletInfo.class, nhso);
            }
            log.info("Read completed");
        } catch (IOException ex) {
            ex = ex;
            log.log(Level.WARNING, null, ex);
            throw new RuntimeException(ex);
        } finally {
        }
        return map;
    }

    @Override
    public synchronized LaserNumber getLaserNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized CID getCID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}