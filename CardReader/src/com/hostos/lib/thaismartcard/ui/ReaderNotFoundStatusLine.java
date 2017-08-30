/*    */ package com.hostos.lib.thaismartcard.ui;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.util.Collection;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSeparator;
/*    */ import org.openide.awt.StatusLineElementProvider;
/*    */ import org.openide.util.Lookup;
/*    */ import org.openide.util.Lookup.Result;
/*    */ import org.openide.util.LookupEvent;
/*    */ import org.openide.util.LookupListener;
/*    */ import com.hostos.lib.thaismartcard.exception.CardMonitor;
/*    */ import com.hostos.lib.thaismartcard.exception.CardReaderNotFoundState;
/*    */ 
/*    */ public class ReaderNotFoundStatusLine
/*    */   implements StatusLineElementProvider
/*    */ {
/* 34 */   private static JLabel statusLine = new JLabel();
/* 35 */   private JPanel panel = new JPanel(new BorderLayout());
/*    */   private final Lookup.Result lookupResult;
/*    */ /*    */ 
/*    */   public ReaderNotFoundStatusLine()
/*    */   {
/* 39 */     this.panel.add(new JSeparator(1), "West");
/* 40 */     this.panel.add(statusLine, "Center");
/* 41 */     CardMonitor cardMonitor = (CardMonitor)Lookup.getDefault().lookup(CardMonitor.class);
/* 42 */     this.lookupResult = (Result) cardMonitor.getLookup().lookup(CardReaderNotFoundState.class);
/* 43 */     this.lookupResult.addLookupListener(new LookupListener()
/*    */     {
/*    */       public void resultChanged(LookupEvent ev)
/*    */       {
/* 47 */         Collection allInstances = ReaderNotFoundStatusLine.this.lookupResult.allInstances();
/* 48 */         if (allInstances.size() > 0) {
/* 49 */           ReaderNotFoundStatusLine.this.panel.setVisible(true);
/* 50 */           ReaderNotFoundStatusLine.statusLine.setForeground(Color.RED);
/* 51 */           ReaderNotFoundStatusLine.statusLine.setText("ไม่พบเครื่องอ่านบัตรสมาร์ทการ์ด โปรดตรวจสอบ");
/*    */         } else {
/* 53 */           ReaderNotFoundStatusLine.this.panel.setVisible(false);
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public Component getStatusLineElement()
/*    */   {
/* 61 */     return this.panel;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.ui.ReaderNotFoundStatusLine
 * JD-Core Version:    0.6.2
 */