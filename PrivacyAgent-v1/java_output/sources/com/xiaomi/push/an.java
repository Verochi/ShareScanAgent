package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class an {
    public static java.lang.String a(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                byte b = digest[i];
                int i2 = (b & Byte.MAX_VALUE) + (b < 0 ? 128 : 0);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(i2 < 16 ? "0" : "");
                sb.append(java.lang.Integer.toHexString(i2).toLowerCase());
                stringBuffer.append(sb.toString());
            }
            return stringBuffer.toString();
        } catch (java.security.NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        return a(str).subSequence(8, 24).toString();
    }

    public static byte[] c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
