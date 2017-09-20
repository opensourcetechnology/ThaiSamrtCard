
package com.java.client;

import com.hostos.lib.thaismartcard.cardreader.pcscServices;
import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import javax.swing.JOptionPane;

public class DataFromCard {

    private static MoiApplet1Info moi;
    private static DataServices dataService;
    private static DataErrorSevices card;

    public DataFromCard() throws CardException, IOException {
        // create object of dataservices
        getDataFromCard();
        setAddressDataToServices();
        setBODDataToServices();
        setGenderDataToServices();
    }

    public void getDataFromCard() {
        try {
// create mehtod from pcscService
            pcscServices p = new pcscServices();
            TerminalFactory factory = TerminalFactory.getDefault();
            List<CardTerminal> terminals = factory.terminals().list();
// Use the first terminal
            CardTerminal terminal = terminals.get(0);
// Connect with the card
            Card card = terminal.connect("*");
// p.wakeupCard(card);
            p.getAvialableDataInfo(card, true);
            
            card.disconnect(true);
        } catch (CardException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void setAddressDataToServices() {
        try {
//create object to support data
            moi = new MoiApplet1Info();
//create object of dataServices      
            dataService = new DataServices();

//spit string from MoiApplet1Info();
            String a = new String(moi.getAddress());
            String[] arrB = a.split(" ");

            for (int i = 0; i < arrB.length; i++) {
                dataService.setHouse(arrB[0]);
                dataService.setMoo(arrB[2]);

                String tambon = arrB[6];
                String[] arrT = tambon.split("ตำบล");
                //for (String t : arrT) {}
                for (int j = 0; j < arrT.length; j++) {
                    dataService.setTambon(arrT[j]);
                }

                String amphur = arrB[7];
                String[] arrA = amphur.split("อำเภอ");
                //for (String t : arrT) {}
                for (int k = 0; k < arrA.length; k++) {
                    dataService.setAmphur(arrA[k]);
                }

                String changwat = arrB[8];
                String[] arrC = changwat.split("จังหวัด");
                //for (String t : arrT) {}
                for (int l = 0; l < arrC.length; l++) {
                    dataService.setChangwat(arrC[l]);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setBODDataToServices() {
        try {
//create object to support data
            moi = new MoiApplet1Info();
//create object of dataServices      
            dataService = new DataServices();

            String bod = new String(moi.getBod());
            String yyyySub = bod.substring(0, 4);
// set year of bod
            int yyyyInt = Integer.parseInt(yyyySub);
            yyyyInt = yyyyInt - 543;
// set month of bod
            String mmSub = bod.substring(4, 6);
// set date of bod      
            String ddSub = bod.substring(6, 8);

//set value to DataService
            dataService.setYyyy(String.valueOf(yyyyInt));
            dataService.setMm(mmSub);
            dataService.setDd(ddSub);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setGenderDataToServices() {
        try {
//create object to support data
            moi = new MoiApplet1Info();
//create object of dataServices      
            dataService = new DataServices();

            String gender = new String(moi.getSexDesc());

            if (gender.equals("male")) {
                dataService.setGender("ชาย");
            } else {
                dataService.setGender("หญิง");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
