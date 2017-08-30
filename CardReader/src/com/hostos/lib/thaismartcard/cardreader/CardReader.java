
package com.hostos.lib.thaismartcard.cardreader;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.emptyList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.smartcardio.*;

public final class CardReader {
    private static final Logger logger = Logger.getLogger(CardReader.class
            .getName());
    
    private static final TerminalFactory factory = TerminalFactory.getDefault();
    private static final CardReader INSTANCE = new CardReader();

    public CardReader(){}
    
    /**
     * Return the instance of {@link CardRedaer}
     *
     * @Return {@link CardReader}
     */
    public static CardReader getInstance(){
        return INSTANCE;
    }
    
    /**
     * Returns a Multimap&lt;CardTerminal, ResponseAPDU&gt; after executing a
     * set of CommandAPDU on all Smartcard readers.
     *
     * @param commands an array of CommandAPDU
     * @return ListMultimap&lt;CardTerminal, ResponseAPDU&gt
     */
    public ListMultimap<CardTerminal, ResponseAPDU> read(CommandAPDU... commands) {
        return read(Arrays.asList(commands));
    }
    
    /**
     * Returns a Multimap&lt;CardTerminal, ResponseAPDU&gt; after executing a
     * set of CommandAPDU on all Smartcard readers.
     *
     * @param commands a List of CommandAPDU
     * @return ListMultimap&lt;CardTerminal, ResponseAPDU&gt;
     */
    public ListMultimap<CardTerminal, ResponseAPDU> read(List<CommandAPDU> commands){
        ListMultimap<CardTerminal, ResponseAPDU> responses = 
                ArrayListMultimap.create();
        for(CardTerminal terminal : getCardTerminals()){
            responses.putAll(terminal, getResponse(terminal, commands));
        }
        return responses;
    }
    
    /**
     * Returns a List of ResponseAPDU of executed command on specified card
     * terminal.
     *
     * @param terminal a CardTerminal
     * @param commands an array of CommandAPDU
     * @return List of ResponseAPDU
     */
    public List<ResponseAPDU> readOnterminal(CardTerminal terminal, CommandAPDU... commands){
        return readOnTerminal(terminal, Arrays.asList(commands));
    }
    
    /**
     * Returns a List of ResponseAPDU of executed command on specified card
     * terminal.
     *
     * @param terminal a CardTerminal
     * @param commands a List of CommandAPDU
     * @return List of ResponseAPDU
     */
    public List<ResponseAPDU> readOnTerminal(CardTerminal terminal, List<CommandAPDU> commands){
        return getResponse(terminal, commands);
    }
    
    private List<ResponseAPDU> getResponse(CardTerminal terminal, List<CommandAPDU> commands){
        List<ResponseAPDU> responses = new ArrayList();
        try{
            Card card = terminal.connect("*");
            CardChannel chanel = card.getBasicChannel();
            for(CommandAPDU command : commands){
                ResponseAPDU response = chanel.transmit(command);
                responses.add(response);
                //System.out.println("Film : "+response);
                //p.getAvialableDataInfo(card, true);
            }
        }catch(CardException e){
            logger.log(Level.SEVERE, null, e.getMessage());
        }
        return responses;
    }
    
    /**
     * Returns all card terminals of the system.
     *
     * @return List of CardTerminal
     */
    public List<CardTerminal> getCardTerminals(){
        List<CardTerminal> terminals = emptyList();
        try{
            terminals = factory.terminals().list();
        }catch(CardException e){
            logger.log(Level.SEVERE, null, e.getMessage());
            throw new RuntimeException(e);
        }
        return terminals;
    }
    
    @Override
    public String toString(){
        return getClass().getSimpleName();
    }
}
