/*    */ package com.hostos.lib.thaismartcard.ui;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.util.Collection;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSeparator;
/*    */ import org.openide.awt.StatusLineElementProvider;
/*    */ import org.openide.util.ImageUtilities;
/*    */ import org.openide.util.Lookup;
/*    */ import org.openide.util.Lookup.Result;
/*    */ import org.openide.util.LookupEvent;
/*    */ import org.openide.util.LookupListener;
/*    */ import com.hostos.lib.thaismartcard.exception.CardMonitor;
/*    */ import com.hostos.lib.thaismartcard.exception.CardPresentState;
/*    */ 
/*    */ public class CardStatusLine
/*    */   implements StatusLineElementProvider
/*    */ {
/* 40 */   private static JLabel statusLine = new JLabel();
/* 41 */   private JPanel panel = new JPanel(new BorderLayout());
/*    */   private final Lookup.Result lookupResult;
/*    */   
/*    */   public CardStatusLine()
/*    */   {
/* 45 */     this.panel.add(new JSeparator(1), "West");
/* 46 */     this.panel.add(statusLine, "Center");
/* 47 */     final ImageIcon cardInsert = ImageUtilities.loadImageIcon("com/java/picture/kenai-online.png", false);
/* 48 */     final Icon createDisabledIcon = ImageUtilities.loadImageIcon("com/java/picture/kenai-offline.png", false);
/* 49 */     CardMonitor cardMonitor = (CardMonitor)Lookup.getDefault().lookup(CardMonitor.class);
/* 50 */     this.lookupResult = (Result) cardMonitor.getLookup().lookup(CardPresentState.class);
/* 51 */     this.lookupResult.addLookupListener(new LookupListener()
/*    */     {
/*    */       public void resultChanged(LookupEvent ev)
/*    */       {
/* 55 */         Collection cardTerminals = CardStatusLine.this.lookupResult.allInstances();
/* 56 */         if (cardTerminals.size() > 0) {
/* 57 */           CardPresentState cardPresentState = (CardPresentState)cardTerminals.toArray()[0];
/* 58 */           CardStatusLine.statusLine.setForeground(Color.BLACK);
/* 59 */           CardStatusLine.statusLine.setText(cardPresentState.getIFD());
/* 60 */           CardStatusLine.statusLine.setIcon(cardInsert);
/*    */         } else {
/* 62 */           CardStatusLine.statusLine.setIcon(createDisabledIcon);
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Component getStatusLineElement()
/*    */   {
/* 70 */     return this.panel;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.ui.CardStatusLine
 * JD-Core Version:    0.6.2
 */