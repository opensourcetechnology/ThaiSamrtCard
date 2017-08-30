/*    */ package com.hostos.lib.thaismartcard.option;
/*    */ 
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.beans.PropertyChangeSupport;
/*    */ import javax.swing.JComponent;
/*    */ import org.netbeans.spi.options.OptionsPanelController;
/*    */ import org.openide.util.HelpCtx;
/*    */ import org.openide.util.Lookup;
/*    */ 
/*    */ public final class SmartCardOptionsPanelController extends OptionsPanelController
/*    */ {
/*    */   public static final String CONFIG_SCARD = "config.scard";
/*    */   public static final String READ_FACEIMAGE = "read.faceimage";
/*    */   private SmartCardPanel panel;
/* 22 */   private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
/*    */   private boolean changed;
/*    */ 
/*    */   public void update()
/*    */   {
/* 26 */     getPanel().load();
/* 27 */     this.changed = false;
/*    */   }
/*    */ 
/*    */   public void applyChanges() {
/* 31 */     getPanel().store();
/* 32 */     this.changed = false;
/*    */   }
/*    */ 
/*    */   public void cancel()
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean isValid() {
/* 40 */     return getPanel().valid();
/*    */   }
/*    */ 
/*    */   public boolean isChanged() {
/* 44 */     return this.changed;
/*    */   }
/*    */ 
/*    */   public HelpCtx getHelpCtx() {
/* 48 */     return null;
/*    */   }
/*    */ 
/*    */   public JComponent getComponent(Lookup masterLookup) {
/* 52 */     return getPanel();
/*    */   }
/*    */ 
/*    */   public void addPropertyChangeListener(PropertyChangeListener l) {
/* 56 */     this.pcs.addPropertyChangeListener(l);
/*    */   }
/*    */ 
/*    */   public void removePropertyChangeListener(PropertyChangeListener l) {
/* 60 */     this.pcs.removePropertyChangeListener(l);
/*    */   }
/*    */ 
/*    */   private SmartCardPanel getPanel() {
/* 64 */     if (this.panel == null) {
/* 65 */       this.panel = new SmartCardPanel(this);
/*    */     }
/* 67 */     return this.panel;
/*    */   }
/*    */ 
/*    */   void changed() {
/* 71 */     if (!this.changed) {
/* 72 */       this.changed = true;
/* 73 */       this.pcs.firePropertyChange("changed", false, true);
/*    */     }
/* 75 */     this.pcs.firePropertyChange("valid", null, null);
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.option.SmartCardOptionsPanelController
 * JD-Core Version:    0.6.2
 */