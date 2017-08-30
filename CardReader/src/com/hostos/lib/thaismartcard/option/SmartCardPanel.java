/*     */ package com.hostos.lib.thaismartcard.option;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java.util.prefs.Preferences;
/*     */ import javax.smartcardio.CardException;
/*     */ import javax.smartcardio.CardTerminal;
/*     */ import javax.smartcardio.CardTerminals;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import org.jdesktop.swingx.JXComboBox;
/*     */ import org.openide.awt.Mnemonics;
/*     */ import org.openide.util.NbBundle;
/*     */ import org.openide.util.NbPreferences;
/*     */ import com.hostos.lib.thaismartcard.util.SmartCardUtils;
/*     */ 
/*     */ public class SmartCardPanel extends JPanel
/*     */ {
/*  20 */   static final Logger log = Logger.getLogger(SmartCardPanel.class.getName());
/*     */   private final SmartCardOptionsPanelController controller;
/*     */   private JXComboBox cardReaderCb;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JSeparator jSeparator2;
/*     */   private JCheckBox pictureChx;
/*     */ /*     */ 
/*     */   public SmartCardPanel(SmartCardOptionsPanelController controller)
/*     */   {
/*  24 */     this.controller = controller;
/*  25 */     initComponents();
/*     */   }
/*     */ /*     */ 
/*     */   private void initComponents()
/*     */   {
/*  37 */     this.jSeparator2 = new JSeparator();
/*  38 */     this.jLabel3 = new JLabel();
/*  39 */     this.jLabel4 = new JLabel();
/*  40 */     this.cardReaderCb = new JXComboBox();
/*  41 */     this.pictureChx = new JCheckBox();
/*     */ 
/*  43 */     this.jLabel3.setFont(new Font("Tahoma", 1, 11));
/*  44 */     Mnemonics.setLocalizedText(this.jLabel3, NbBundle.getMessage(SmartCardPanel.class, "SmartCardPanel.jLabel3.text"));
/*     */ /*     */ 
/*  46 */     Mnemonics.setLocalizedText(this.jLabel4, NbBundle.getMessage(SmartCardPanel.class, "SmartCardPanel.jLabel4.text"));
/*     */ /*     */ 
/*  48 */     Mnemonics.setLocalizedText(this.pictureChx, NbBundle.getMessage(SmartCardPanel.class, "SmartCardPanel.pictureChx.text"));
/*     */ 
/*  50 */     GroupLayout layout = new GroupLayout(this);
/*  51 */     setLayout(layout);
/*  52 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator2, -1, 361, 32767)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.pictureChx)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cardReaderCb, -2, 405, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767))).addContainerGap()));
/*     */ 
/*  74 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3).addComponent(this.jSeparator2, -2, 10, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.cardReaderCb, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.pictureChx).addContainerGap(196, 32767)));
/*     */   }
/*     */ 
/*     */   void load()
/*     */   {
/*  92 */     CardTerminals terminals = SmartCardUtils.fetchCardTerminalFromSystem();
/*  93 */     List terminalList = null;
/*     */     try {
/*  95 */       terminalList = terminals.list();
/*  96 */       log.log(Level.INFO, "Terminal List=>{0}", terminalList);
/*     */     } catch (CardException ex) {
/*  98 */       log.log(Level.INFO, null, ex);
/*     */     }
/* 100 */     if (terminalList != null) {
/* 101 */       this.cardReaderCb.setModel(new DefaultComboBoxModel(terminalList.toArray()));
/*     */     }
/* 103 */     Preferences forModule = NbPreferences.forModule(getClass());
/* 104 */     String configCard = forModule.get("config.scard", null);
/* 105 */     if (configCard != null) {
/* 106 */       CardTerminal terminal = terminals.getTerminal(configCard);
/* 107 */       if (terminal != null)
/* 108 */         this.cardReaderCb.setSelectedItem(terminal);
/*     */     }
/*     */     else {
/* 111 */       this.cardReaderCb.setSelectedItem(null);
/*     */     }
/* 113 */     this.pictureChx.setSelected(forModule.getBoolean("read.faceimage", true));
/*     */   }
/*     */ 
/*     */   void store() {
/* 117 */     CardTerminal terminal = (CardTerminal)this.cardReaderCb.getSelectedItem();
/* 118 */     if (terminal != null) {
/* 119 */       NbPreferences.forModule(getClass()).put("config.scard", terminal.getName());
/*     */     }
/* 121 */     NbPreferences.forModule(getClass()).putBoolean("read.faceimage", this.pictureChx.isSelected());
/*     */   }
/*     */ 
/*     */   boolean valid()
/*     */   {
/* 126 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.option.SmartCardPanel
 * JD-Core Version:    0.6.2
 */