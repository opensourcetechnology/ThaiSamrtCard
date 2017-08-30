/*     */ package com.hostos.lib.thaismartcard.util;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class DateUtils
/*     */ {
/*  20 */   public static Locale TH = new Locale("th", "TH");
/*  21 */   public static Locale EN = new Locale("en", "US");
/*     */ 
/*  24 */   public static String yyyymmddToFormattedFullThaiDate(String yyyyMMdd) { SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd", TH);
/*  25 */     SimpleDateFormat to = new SimpleDateFormat("d MMMM yyyy", TH);
/*     */     Date date;
/*     */     try { date = from.parse(yyyyMMdd.trim());
/*     */     } catch (ParseException ex) {
/*  30 */       throw new RuntimeException(ex);
/*     */     }
/*  32 */     return to.format(date); } 
/*     */   public static String yyyymmddToFormattedMediumThaiDate(String yyyyMMdd) {
/*  36 */     SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd", TH);
/*  37 */     SimpleDateFormat to = new SimpleDateFormat("d MMM yyyy", TH);
/*     */     Date date;
/*     */     try {
/*  40 */       date = from.parse(yyyyMMdd.trim());
/*     */     } catch (ParseException ex) {
/*  42 */       throw new RuntimeException(ex);
/*     */     }
/*  44 */     return to.format(date);
/*     */   }
/*     */ 
/*     */   public static String yyyymmddToFormattedMediumThaiDateOrEmpty(String yyyyMMdd) {
/*     */     try {
/*  49 */       return yyyymmddToFormattedMediumThaiDate(yyyyMMdd); } catch (Exception e) {
/*     */     }
/*  51 */     return "";
/*     */   }
/*     */   public static String yyyymmddCristToFormattedFullThaiDate(String yyyyMMdd) {
/*  56 */     SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd", EN);
/*  57 */     SimpleDateFormat to = new SimpleDateFormat("d MMMM yyyy", TH);
/*     */     Date date;
/*     */     try {
/*  60 */       date = from.parse(yyyyMMdd.trim());
/*     */     } catch (ParseException ex) {
/*  62 */       throw new RuntimeException(ex);
/*     */     }
/*  64 */     return to.format(date);
/*     */   }
/*     */ 
/*     */   public static String yyyymmddToFormattedFullThaiDateOrEmpty(String yyyyMMdd) {
/*     */     try {
/*  69 */       yyyyMMdd = yyyyMMdd.trim();
/*  70 */       if (yyyyMMdd.endsWith("0000"))
/*  71 */         return yyyyMMdd.substring(0, 4);
/*  72 */       if (yyyyMMdd.endsWith("00")) {
/*  73 */         SimpleDateFormat from = new SimpleDateFormat("yyyyMM", EN);
/*  74 */         SimpleDateFormat to = new SimpleDateFormat("MMMM yyyy", TH);
/*  75 */         Date date = null;
/*     */         try {
/*  77 */           date = from.parse(yyyyMMdd.substring(0, 6));
/*     */         } catch (ParseException ex) {
/*  79 */           throw new RuntimeException(ex);
/*     */         }
/*  81 */         return to.format(date);
/*     */       }
/*  83 */       return yyyymmddToFormattedFullThaiDate(yyyyMMdd); } catch (Exception ex) {
/*     */     }
/*  85 */     return "";
/*     */   }
/*     */ 
/*     */   public static String yyyymmddToFormattedFullThaiDateOrNull(String yyyyMMdd)
/*     */   {
/*     */     try {
/*  91 */       yyyyMMdd = yyyyMMdd.trim();
/*  92 */       if (yyyyMMdd.endsWith("0000"))
/*  93 */         return yyyyMMdd.substring(0, 4);
/*  94 */       if (yyyyMMdd.endsWith("00")) {
/*  95 */         SimpleDateFormat from = new SimpleDateFormat("yyyyMM", EN);
/*  96 */         SimpleDateFormat to = new SimpleDateFormat("MMMM yyyy", TH);
/*  97 */         Date date = null;
/*     */         try {
/*  99 */           date = from.parse(yyyyMMdd.substring(0, 6));
/*     */         } catch (ParseException ex) {
/* 101 */           throw new RuntimeException(ex);
/*     */         }
/* 103 */         return to.format(date);
/*     */       }
/* 105 */       return yyyymmddToFormattedFullThaiDate(yyyyMMdd); } catch (Exception ex) {
/*     */     }
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */   public static String formatShortThaiDateTime(Date date)
/*     */   {
/* 112 */     SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy  เวลา HH.mm น.", TH);
/* 113 */     return df.format(date);
/*     */   }
/*     */ 
/*     */   public static String formatThaiDateTime(Date date, String format) {
/* 117 */     SimpleDateFormat df = new SimpleDateFormat(format, TH);
/* 118 */     return df.format(date);
/*     */   }
/*     */ 
/*     */   public static String formatFullThaiDateTime(Date date) {
/* 122 */     SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy  เวลา HH.mm", TH);
/* 123 */     return df.format(date);
/*     */   }
/*     */ 
/*     */   public static Date todate(String yyyyMMdd) {
/* 127 */     SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd", TH);
/*     */     try {
/* 129 */       return df.parse(yyyyMMdd); } catch (ParseException ex) {
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Work\OST\Projects\HospitalOSV3\Code\ExtModule\ThaiSmartCardModule\lib\th-go-geniustree-smartcard-api.jar
 * Qualified Name:     th.go.geniustree.smartcard.api.option.util.DateUtils
 * JD-Core Version:    0.6.2
 */