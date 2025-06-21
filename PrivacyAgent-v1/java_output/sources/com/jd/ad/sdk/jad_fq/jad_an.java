package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_an {
    public static java.lang.String jad_an(java.lang.String str) {
        if (str.length() <= 59) {
            return "";
        }
        java.lang.String substring = str.substring(0, 59);
        java.lang.String substring2 = str.substring(59);
        java.lang.String jad_cp = jad_cp(substring);
        java.lang.String jad_dq = jad_dq(substring);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(jad_cp.getBytes("UTF-8"), "AES");
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(jad_dq.getBytes("UTF-8"));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new java.lang.String(cipher.doFinal(android.util.Base64.decode(substring2, 8)), "UTF-8");
    }

    public static byte[] jad_bo(java.lang.String str) {
        int nextInt = new java.security.SecureRandom().nextInt(10);
        java.lang.String substring = "abcdefghij".substring(nextInt, nextInt + 1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(58);
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        for (int i = 0; i < 58; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt(62)));
        }
        java.lang.String str2 = substring + sb.toString();
        java.lang.String jad_cp = jad_cp(str2);
        java.lang.String jad_dq = jad_dq(str2);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(jad_cp.getBytes("UTF-8"), "AES");
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(jad_dq.getBytes("UTF-8"));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return (str2 + android.util.Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 11)).getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }

    public static java.lang.String jad_cp(java.lang.String str) {
        int indexOf;
        if (str == null || (indexOf = "abcdefghij".indexOf(str.substring(0, 1))) == -1) {
            return "";
        }
        int i = indexOf + 1;
        return str.substring(i, i + 32);
    }

    public static java.lang.String jad_dq(java.lang.String str) {
        int indexOf;
        if (str == null || (indexOf = "abcdefghij".indexOf(str.substring(0, 1))) == -1) {
            return "";
        }
        int i = indexOf + 1 + 32;
        return str.substring(i, i + 16);
    }
}
