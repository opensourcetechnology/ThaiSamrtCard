
package com.hostos.lib.thaismartcard.main;

import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import com.hostos.lib.thaismartcard.model.NhsoAppletInfo;
import com.hostos.lib.thaismartcard.cardreader.pcscServices;
import java.io.IOException;
import java.util.List;
import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import org.openide.util.Exceptions;

public class tscmReader {
    private final TerminalFactory factory;
    private final List<CardTerminal> terminals;
    private CardTerminal terminal;
    private Card card;
    private pcscServices p;
    
    public tscmReader() throws CardException, IOException{
        p = new pcscServices();
        factory = TerminalFactory.getDefault();
        terminals = factory.terminals().list();
        // Use the first terminal
        terminal = terminals.get(0);
        // Connect with the card
        card = terminal.connect("*");
        //p.wakeupCard(card);
        p.getAvialableDataInfo(card, true);   
    }
    
    public static void main(String[] args){
        try {
            new tscmReader();
            
        } catch (CardException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
