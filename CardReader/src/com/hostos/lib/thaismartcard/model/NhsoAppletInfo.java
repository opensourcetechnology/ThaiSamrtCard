/*     */ package com.hostos.lib.thaismartcard.model;
/*     */ 
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import com.hostos.lib.thaismartcard.util.DateUtils;
/*     */ 
/*     */ public class NhsoAppletInfo
/*     */ {
/*     */   private static String version;
/*     */   private static String mainRights;
/*     */   private static String subRights;
/*     */   private static String mainHospitalsName;
/*     */   private static String subHospitalsName;
/*     */   private static String paidType;
/*     */   private static String dateOfIssue;
/*     */   private static String dateOfExpiry;
/*     */   private static String updateDate;
/*     */   private static String changeHospitalAmount;
/*     */ 
/*     */   public String getChangeHospitalAmount()
/*     */   {
/*  28 */     return this.changeHospitalAmount;
/*     */   }
/*     */ 
/*     */   public String getFormattedDateOfExpirey() {
/*  32 */     if ((this.dateOfExpiry != null) && (!this.dateOfExpiry.trim().isEmpty())) {
/*  33 */       return DateUtils.yyyymmddToFormattedFullThaiDateOrEmpty(this.dateOfExpiry);
/*     */     }
/*  35 */     return "";
/*     */   }
/*     */ 
/*     */   public String getFormattedDateOfIssue() {
/*  39 */     if ((this.dateOfIssue != null) && (!this.dateOfIssue.trim().isEmpty())) {
/*  40 */       return DateUtils.yyyymmddToFormattedFullThaiDateOrEmpty(this.dateOfIssue);
/*     */     }
/*  42 */     return "";
/*     */   }
/*     */ 
/*     */   public String getFormattedUpdateDate() {
/*  46 */     if ((this.updateDate != null) && (!this.updateDate.trim().isEmpty())) {
/*  47 */       return DateUtils.yyyymmddToFormattedFullThaiDateOrEmpty(this.updateDate);
/*     */     }
/*  49 */     return "";
/*     */   }
/*     */ 
/*     */   public void setChangeHospitalAmount(String changeHospitalAmount) {
/*  53 */     this.changeHospitalAmount = changeHospitalAmount;
/*     */   }
/*     */ 
/*     */   public String getDateOfExpiry() {
/*  57 */     return this.dateOfExpiry;
/*     */   }
/*     */ 
/*     */   public void setDateOfExpiry(String dateOfExpiry) {
/*  61 */     this.dateOfExpiry = dateOfExpiry;
/*     */   }
/*     */ 
/*     */   public String getDateOfIssue() {
/*  65 */     return this.dateOfIssue;
/*     */   }
/*     */ 
/*     */   public void setDateOfIssue(String dateOfIssue) {
/*  69 */     this.dateOfIssue = dateOfIssue;
/*     */   }
/*     */ 
/*     */   public String getMainHospitalsName() {
/*  73 */     return this.mainHospitalsName;
/*     */   }
/*     */ 
/*     */   public void setMainHospitalsName(String mainHospitalsName) {
/*  77 */     this.mainHospitalsName = mainHospitalsName;
/*     */   }
/*     */ 
/*     */   public String getMainRights() {
/*  81 */     return this.mainRights;
/*     */   }
/*     */ 
/*     */   public void setMainRights(String mainRights) {
/*  85 */     this.mainRights = mainRights;
/*     */   }
/*     */ 
/*     */   public String getPaidType() {
/*  89 */     return this.paidType;
/*     */   }
/*     */ 
/*     */   public void setPaidType(String paidType) {
/*  93 */     this.paidType = paidType;
/*     */   }
/*     */ 
/*     */   public String getSubHospitalsName() {
/*  97 */     return this.subHospitalsName;
/*     */   }
/*     */ 
/*     */   public void setSubHospitalsName(String subHospitalsName) {
/* 101 */     this.subHospitalsName = subHospitalsName;
/*     */   }
/*     */ 
/*     */   public String getSubRights() {
/* 105 */     return this.subRights;
/*     */   }
/*     */ 
/*     */   public void setSubRights(String subRights) {
/* 109 */     this.subRights = subRights;
/*     */   }
/*     */ 
/*     */   public String getUpdateDate() {
/* 113 */     return this.updateDate;
/*     */   }
/*     */ 
/*     */   public void setUpdateDate(String updateDate) {
/* 117 */     this.updateDate = updateDate;
/*     */   }
/*     */ 
/*     */   public String getVersion() {
/* 121 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(String version) {
/* 125 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 130 */     return ToStringBuilder.reflectionToString(this);
/*     */   }
/*     */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.model.NhsoAppletInfo
 * JD-Core Version:    0.6.2
 */