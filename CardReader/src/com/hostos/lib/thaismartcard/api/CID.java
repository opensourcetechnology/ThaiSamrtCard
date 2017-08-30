/*    */ package com.hostos.lib.thaismartcard.api;
/*    */ 
/*    */ public class CID
/*    */ {
/*    */   private String cid;
/*    */ /*    */ 
/*    */   public CID(String cid)
/*    */   {
/* 19 */     this.cid = cid;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return this.cid;
/*    */   }
/*    */ /*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 30 */     if (obj == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (getClass() != obj.getClass()) {
/* 34 */       return false;
/*    */     }
/* 36 */     CID other = (CID)obj;
/* 37 */     if (this.cid == null ? other.cid != null : !this.cid.equals(other.cid)) {
/* 38 */       return false;
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 45 */     int hash = 7;
/* 46 */     hash = 41 * hash + (this.cid != null ? this.cid.hashCode() : 0);
/* 47 */     return hash;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.CID
 * JD-Core Version:    0.6.2
 */