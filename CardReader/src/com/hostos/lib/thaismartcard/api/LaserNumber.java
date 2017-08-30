/*    */ package com.hostos.lib.thaismartcard.api;
/*    */ 
/*    */ public class LaserNumber
/*    */ {
/*    */   private String laserNumber;
/*    */ /*    */ 
/*    */   public LaserNumber(String laserNumber)
/*    */   {
/* 19 */     this.laserNumber = laserNumber;
/*    */   }
/*    */ /*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 24 */     if (obj == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     if (getClass() != obj.getClass()) {
/* 28 */       return false;
/*    */     }
/* 30 */     LaserNumber other = (LaserNumber)obj;
/* 31 */     if (this.laserNumber == null ? other.laserNumber != null : !this.laserNumber.equals(other.laserNumber)) {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 39 */     int hash = 5;
/* 40 */     hash = 47 * hash + (this.laserNumber != null ? this.laserNumber.hashCode() : 0);
/* 41 */     return hash;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 46 */     return this.laserNumber;
/*    */   }
/*    */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.LaserNumber
 * JD-Core Version:    0.6.2
 */