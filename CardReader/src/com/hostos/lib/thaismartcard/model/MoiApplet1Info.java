/*     */ package com.hostos.lib.thaismartcard.model;
/*     */ 
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import com.hostos.lib.thaismartcard.util.DateUtils;
/*     */ 
/*     */ public class MoiApplet1Info
/*     */ {
/*     */   public static String version;
/*     */   public static String pid;
/*     */   private static Name thaiName;
/*     */   private static Name engName;
/*     */   private static String bod;
/*     */   private static String sex;
/*     */   private static String cardNumberOrRequest;
/*     */   private static String cardOwner;
/*     */   private static String issuerCode;
/*     */   private static String dateOfIssue;
/*     */   private static String dateOfExpiry;
/*     */   private static String cardTtype;
/*     */   private static byte[] facesImage;
/*  29 */   private static String address = "";
/*     */   private static String facesImageId;
/*     */   private static byte[] officerSignatureImage;
/*  32 */   private static boolean oldCard = false;
/*     */   private static NhsoAppletInfo nhsoAppletInfo;
/*     */   private static String cid;
/*     */   private static String atr;
/*  36 */   private static int cardType = 20;
/*     */   public static final int CARD_UNKNOWN = 20;
/*     */   public static final int CARD_ST_DP66_B = 24;
/*     */   public static final int CARD_JCOP_31 = 26;
/*     */   
/*     */   public String getAddress()
/*     */   {
                //String d = address.replaceAll("#", " ");
/*  42 */     return address.replaceAll("#", " ");
/*     */   }
/*     */ 
/*     */   public String getFormattedDateOfExpiry() {
/*  46 */     if (this.dateOfExpiry != null) {
/*  47 */       return DateUtils.yyyymmddToFormattedFullThaiDate(this.dateOfExpiry);
/*     */     }
/*  49 */     return "";
/*     */   }
/*     */ 
/*     */   public String getFormattedDateOfIssue() {
/*  53 */     if (this.dateOfIssue != null) {
/*  54 */       return DateUtils.yyyymmddToFormattedFullThaiDate(this.dateOfIssue);
/*     */     }
/*  56 */     return "";
/*     */   }
/*     */ 
/*     */   public String getSexDesc() {
/*  60 */     if (this.sex.equals("1"))
/*  61 */       return "ชาย";
/*  62 */     if (this.sex.equals("2")) {
/*  63 */       return "หญิง";
/*     */     }
/*  65 */     return "";
/*     */   }
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/*  70 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getBod() {
/*  74 */     return this.bod;
/*     */   }
/*     */ 
/*     */   public void setBod(String bod) {
/*  78 */     this.bod = bod;
/*     */   }
/*     */ 
/*     */   public String getFormattedBod() {
/*  82 */     if (this.bod != null) {
/*  83 */       return DateUtils.yyyymmddToFormattedFullThaiDate(this.bod);
/*     */     }
/*  85 */     return "";
/*     */   }
/*     */ 
/*     */   public String getCardNumberOrRequest() {
/*  89 */     return this.cardNumberOrRequest;
/*     */   }
/*     */ 
/*     */   public void setCardNumberOrRequest(String cardNumberOrRequest) {
/*  93 */     this.cardNumberOrRequest = cardNumberOrRequest;
/*     */   }
/*     */ 
/*     */   public String getCardOwner() {
/*  97 */     return this.cardOwner;
/*     */   }
/*     */ 
/*     */   public void setCardOwner(String cardOwner) {
/* 101 */     this.cardOwner = cardOwner;
/*     */   }
/*     */ 
/*     */   public String getCardTtype() {
/* 105 */     return this.cardTtype;
/*     */   }
/*     */ 
/*     */   public void setCardTtype(String cardTtype) {
/* 109 */     this.cardTtype = cardTtype;
/*     */   }
/*     */ 
/*     */   public String getDateOfExpiry() {
/* 113 */     return this.dateOfExpiry;
/*     */   }
/*     */ 
/*     */   public void setDateOfExpiry(String dateOfExpiry) {
/* 117 */     this.dateOfExpiry = dateOfExpiry;
/*     */   }
/*     */ 
/*     */   public String getDateOfIssue() {
/* 121 */     return this.dateOfIssue;
/*     */   }
/*     */ 
/*     */   public void setDateOfIssue(String dateOfIssue) {
/* 125 */     this.dateOfIssue = dateOfIssue;
/*     */   }
/*     */ 
/*     */   public Name getEngName() {
/* 129 */     return this.engName;
/*     */   }
/*     */ 
/*     */   public void setEngName(Name engName) {
/* 133 */     this.engName = engName;
/*     */   }
/*     */ 
/*     */   public byte[] getFacesImage() {
/* 137 */     return facesImage;
/*     */   }
/*     */ 
/*     */   public void setFacesImage(byte[] facesImage) {
/* 141 */     this.facesImage = facesImage;
/*     */   }
/*     */ 
/*     */   public String getFacesImageId() {
/* 145 */     return this.facesImageId;
/*     */   }
/*     */ 
/*     */   public void setFacesImageId(String facesImageId) {
/* 149 */     this.facesImageId = facesImageId;
/*     */   }
/*     */ 
/*     */   public String getIssuerCode() {
/* 153 */     return this.issuerCode;
/*     */   }
/*     */ 
/*     */   public void setIssuerCode(String issuerCode) {
/* 157 */     this.issuerCode = issuerCode;
/*     */   }
/*     */ 
/*     */   public byte[] getOfficerSignatureImage() {
/* 161 */     return this.officerSignatureImage;
/*     */   }
/*     */ 
/*     */   public void setOfficerSignatureImage(byte[] officerSignatureImage) {
/* 165 */     this.officerSignatureImage = officerSignatureImage;
/*     */   }
/*     */ 
/*     */   public String getPid() {
/* 169 */     return this.pid;
/*     */   }
/*     */ 
/*     */   public void setPid(String pid) {
/* 173 */     this.pid = pid;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/* 177 */     return this.sex;
/*     */   }
/*     */ 
/*     */   public void setSex(String sex) {
/* 181 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */   public Name getThaiName() {
/* 185 */     return this.thaiName;
/*     */   }
/*     */ 
/*     */   public void setThaiName(Name thaiName) {
/* 189 */     this.thaiName = thaiName;
/*     */   }
/*     */ 
/*     */   public String getVersion() {
/* 193 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(String version) {
/* 197 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public boolean isOldCard() {
/* 201 */     return this.oldCard;
/*     */   }
/*     */ 
/*     */   public void setOldCard(boolean oldCard) {
/* 205 */     this.oldCard = oldCard;
/*     */   }
/*     */ 
/*     */   public NhsoAppletInfo getNhsoAppletInfo() {
/* 209 */     return this.nhsoAppletInfo;
/*     */   }
/*     */ 
/*     */   public void setNhsoAppletInfo(NhsoAppletInfo nhsoAppletInfo) {
/* 213 */     this.nhsoAppletInfo = nhsoAppletInfo;
/*     */   }
/*     */ 
/*     */   public String getCid() {
/* 217 */     return this.cid;
/*     */   }
/*     */ 
/*     */   public void setCid(String cid) {
/* 221 */     this.cid = cid;
/*     */   }
/*     */ 
/*     */   public int getCardType() {
/* 225 */     return this.cardType;
/*     */   }
/*     */ 
/*     */   public void setCardType(int cardType) {
/* 229 */     this.cardType = cardType;
/*     */   }
/*     */ 
/*     */   public String getAtr() {
/* 233 */     return this.atr;
/*     */   }
/*     */ 
/*     */   public void setAtr(String atr) {
/* 237 */     this.atr = atr;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     return ToStringBuilder.reflectionToString(this);
/*     */   }
/*     */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.model.MoiApplet1Info
 * JD-Core Version:    0.6.2
 */