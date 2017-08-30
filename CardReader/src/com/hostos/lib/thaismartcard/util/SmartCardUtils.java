/*    */ package com.hostos.lib.thaismartcard.util;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import java.util.prefs.Preferences;
/*    */ import javax.smartcardio.CardException;
/*    */ import javax.smartcardio.CardTerminal;
/*    */ import javax.smartcardio.CardTerminals;
/*    */ import javax.smartcardio.TerminalFactory;
/*    */ import org.openide.util.NbPreferences;
/*    */ 
/*    */ public class SmartCardUtils
/*    */ {
/* 27 */   private static final Logger log = Logger.getLogger(SmartCardUtils.class.getName());
/*    */   private static CardTerminals terminals;
/*    */ 
/*    */   public static CardTerminals fetchCardTerminalFromSystem()
/*    */   {
/* 31 */     TerminalFactory defaultTerminalFactory = TerminalFactory.getDefault();
/* 32 */     log.log(Level.INFO, "Smartcard TerminalFactory is=>{0}", defaultTerminalFactory);
/* 33 */     CardTerminals _terminals = defaultTerminalFactory.terminals();
/* 34 */     return _terminals;
/*    */   }
/*    */ 
/*    */   public static synchronized CardTerminals fetchAndCacheCardTerminalFromSystem() {
/* 38 */     if (terminals == null) {
/* 39 */       terminals = fetchCardTerminalFromSystem();
/*    */     }
/* 41 */     return terminals;
/*    */   }
/*    */ /*    */ 
/*    */   public static CardTerminal getConfigCardTerminal() throws CardException {
/* 45 */     CardTerminal terminal = null;
/* 46 */     String configCard = NbPreferences.forModule(SmartCardUtils.class).get("config.scard", null);
/* 47 */     if (configCard != null) {
/* 48 */       terminal = fetchAndCacheCardTerminalFromSystem().getTerminal(configCard);
/* 49 */       if ((terminal == null) && (fetchAndCacheCardTerminalFromSystem().list().size() > 0)) {
/* 50 */         terminal = (CardTerminal)fetchAndCacheCardTerminalFromSystem().list().get(0);
/* 51 */         NbPreferences.forModule(SmartCardUtils.class).get("config.scard", terminal.getName());
/*    */       }
/*    */     }
/* 54 */     else if (fetchAndCacheCardTerminalFromSystem().list().size() > 0) {
/* 55 */       terminal = (CardTerminal)fetchAndCacheCardTerminalFromSystem().list().get(0);
/* 56 */       NbPreferences.forModule(SmartCardUtils.class).get("config.scard", terminal.getName());
/*    */     }
/*    */ 
/* 59 */     return terminal;
/*    */   }
/*    */ /*    */ 
/*    */   public static String getConfigCardTerminalName() {
/* 63 */     String cardname = null;
/*    */     try {
/* 65 */       cardname = NbPreferences.forModule(SmartCardUtils.class).get("config.scard", getConfigCardTerminal().getName());
/*    */     }
/*    */     catch (CardException ex) {
/*    */     }
/* 69 */     return cardname;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.option.util.SmartCardUtils
 * JD-Core Version:    0.6.2
 */