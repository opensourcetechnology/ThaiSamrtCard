
package com.hostos.lib.thaismartcard.api;

/*     */ import java.io.ByteArrayOutputStream;
/*     */ 
/*     */ public final class ByteUtils
/*     */ {
/*  94 */   private static String numbers = "0123456789abcdef";
/*     */ 
/*     */   public static String dumpHex(byte byte0)
/*     */   {
/*  13 */     if ((byte0 & 0xFF) < 16) {
/*  14 */       return "0" + Integer.toHexString(byte0 & 0xFF);
/*     */     }
/*  16 */     return Integer.toHexString(byte0 & 0xFF);
/*     */   }
/*     */ 
/*     */   public static String dumpHex(byte[] abyte0, int i, int j)
/*     */   {
/*  21 */     StringBuffer stringbuffer = new StringBuffer();
/*  22 */     for (int k = i; (k < abyte0.length) && (k < i + j); k++) {
/*  23 */       stringbuffer.append(dumpHex(abyte0[k]));
/*  24 */       stringbuffer.append(" ");
/*     */     }
/*     */ 
/*  27 */     return stringbuffer.toString();
/*     */   }
/*     */ 
/*     */   public static String dumpHex(byte[] abyte0) {
/*  31 */     return dumpHex(abyte0, 0, abyte0.length);
/*     */   }
/*     */ 
/*     */   public static boolean isBytesEqual(byte[] abyte0, byte[] abyte1) {
/*  35 */     if (abyte0.length != abyte1.length) {
/*  36 */       return false;
/*     */     }
/*  38 */     for (int i = 0; i < abyte0.length; i++) {
/*  39 */       if (abyte0[i] != abyte1[i]) {
/*  40 */         return false;
/*     */       }
/*     */     }
/*     */ 
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */   public static final byte[] intToBytes(int i) {
/*  48 */     int j = (Integer.toHexString(i).length() + 1) / 2;
/*  49 */     byte[] abyte0 = new byte[j];
/*  50 */     for (int k = 0; k < j; k++) {
/*  51 */       abyte0[k] = ((byte)(i >>> 8 * (j - 1 - k) & 0xFF));
/*     */     }
/*     */ 
/*  54 */     return abyte0;
/*     */   }
/*     */ 
/*     */   public static final int bytesToInt(byte[] abyte0, int i, int j) {
/*  58 */     int k = 0;
/*  59 */     for (int l = 0; l < j; l++) {
/*  60 */       k = k << 8 | abyte0[(l + i)] & 0xFF;
/*     */     }
/*     */ 
/*  63 */     return k;
/*     */   }
/*     */ 
/*     */   public static final byte[] toLengthOctets(int i) {
/*  67 */     byte[] abyte0 = null;
/*  68 */     if (i < 128) {
/*  69 */       abyte0 = new byte[1];
/*  70 */       abyte0[0] = ((byte)i);
/*     */     } else {
/*  72 */       byte[] abyte1 = intToBytes(i);
/*  73 */       abyte0 = new byte[1 + abyte1.length];
/*  74 */       System.arraycopy(abyte1, 0, abyte0, 1, abyte1.length);
/*  75 */       abyte0[0] = ((byte)(abyte1.length | 0x80));
/*     */     }
/*  77 */     return abyte0;
/*     */   }
/*     */ 
/*     */   public static byte[] strToBytes(String s) {
/*  81 */     if (s.length() % 2 != 0) {
/*  82 */       throw new IllegalArgumentException("String length % 2 != 0");
/*     */     }
/*  84 */     ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
/*  85 */     for (int i = 0; i < s.length(); i += 2) {
/*  86 */       byte byte0 = (byte)(Character.digit(s.charAt(i), 16) & 0xFF);
/*  87 */       byte0 = (byte)(byte0 << 4);
/*  88 */       byte0 = (byte)(byte0 | Character.digit(s.charAt(i + 1), 16));
/*  89 */       bytearrayoutputstream.write(byte0);
/*     */     }
/*     */ 
/*  92 */     return bytearrayoutputstream.toByteArray();
/*     */   }
/*     */ 
/*     */   public static byte[] stoh(String s)
/*     */   {
/*  97 */     s = s.replaceAll(" ", "").toLowerCase();
/*  98 */     if (s == null) {
/*  99 */       return null;
/*     */     }
/* 101 */     if (s.length() % 2 != 0) {
/* 102 */       throw new RuntimeException("invalid length");
/*     */     }
/* 104 */     byte[] result = new byte[s.length() / 2];
/* 105 */     for (int i = 0; i < s.length(); i += 2) {
/* 106 */       int i1 = numbers.indexOf(s.charAt(i));
/* 107 */       if (i1 == -1) {
/* 108 */         throw new RuntimeException("invalid number");
/*     */       }
/* 110 */       int i2 = numbers.indexOf(s.charAt(i + 1));
/* 111 */       if (i2 == -1) {
/* 112 */         throw new RuntimeException("invalid number");
/*     */       }
/* 114 */       result[(i / 2)] = ((byte)(i1 << 4 | i2));
/*     */     }
/* 116 */     return result;
/*     */   }
/*     */ 
/*     */   public static String htos(byte[] bytes) {
/* 120 */     StringBuffer sb = new StringBuffer();
/* 121 */     for (int i = 0; i < bytes.length; i++) {
/* 122 */       String tmp = Integer.toHexString(bytes[i] & 0xFF);
/* 123 */       while (tmp.length() < 2) {
/* 124 */         tmp = "0" + tmp;
/*     */       }
/* 126 */       if (i != bytes.length - 1)
/* 127 */         sb.append(tmp + " ");
/*     */       else {
/* 129 */         sb.append(tmp);
/*     */       }
/*     */     }
/*     */ 
/* 133 */     return sb.toString().toUpperCase();
/*     */   }
/*     */ 
/*     */   public static String htosNoSpace(byte[] bytes) {
/* 137 */     StringBuffer sb = new StringBuffer();
/* 138 */     for (int i = 0; i < bytes.length; i++) {
/* 139 */       String tmp = Integer.toHexString(bytes[i] & 0xFF);
/* 140 */       while (tmp.length() < 2) {
/* 141 */         tmp = "0" + tmp;
/*     */       }
/* 143 */       sb.append(tmp);
/*     */     }
/*     */ 
/* 146 */     return sb.toString().toUpperCase();
/*     */   }
/*     */ }
