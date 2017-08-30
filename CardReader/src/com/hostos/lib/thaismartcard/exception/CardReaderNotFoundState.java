/*    */ package com.hostos.lib.thaismartcard.exception;
/*    */ 
/*    */ public class CardReaderNotFoundState
/*    */ {
/* 17 */   private int id = 1;
/*    */ /*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 21 */     if (obj == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     if (getClass() != obj.getClass()) {
/* 25 */       return false;
/*    */     }
/* 27 */     CardReaderNotFoundState other = (CardReaderNotFoundState)obj;
/* 28 */     if (this.id != other.id) {
/* 29 */       return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 36 */     int hash = 3;
/* 37 */     hash = 43 * hash + this.id;
/* 38 */     return hash;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.CardReaderNotFoundState
 * JD-Core Version:    0.6.2
 */