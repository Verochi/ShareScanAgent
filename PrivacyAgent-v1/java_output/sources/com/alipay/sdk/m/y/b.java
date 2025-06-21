package com.alipay.sdk.m.y;

/* loaded from: classes.dex */
public final class b {
    public static java.lang.String a(java.lang.String str) {
        try {
            if (com.alipay.sdk.m.z.a.a(str)) {
                return null;
            }
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
