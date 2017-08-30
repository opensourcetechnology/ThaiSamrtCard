/*    */ package com.hostos.lib.thaismartcard.exception;
/*    */ 
/*    */ public class CardPresentState
/*    */ {
/*    */   private String IFD;
/*    */ /*    */ 
/*    */   public CardPresentState(String IFD)
/*    */   {
/* 19 */     this.IFD = IFD;
/*    */   }
/*    */ 
/*    */   public String getIFD() {
/* 23 */     return this.IFD;
/*    */   }
/*    */ 
/*    */   public void setIFD(String IFD) {
/* 27 */     this.IFD = IFD;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 32 */     return this.IFD;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.CardPresentState
 * JD-Core Version:    0.6.2
 */