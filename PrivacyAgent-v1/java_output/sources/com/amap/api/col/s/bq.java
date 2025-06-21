package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bq {
    public static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return com.amap.api.col.s.bu.f(c(str));
    }

    public static java.lang.String a(byte[] bArr) {
        return com.amap.api.col.s.bu.f(b(bArr, com.amap.api.col.s.bu.c("ETUQ1")));
    }

    public static java.lang.String b(java.lang.String str) {
        return com.amap.api.col.s.bu.h(d(str));
    }

    public static byte[] b(byte[] bArr, java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static byte[] c(java.lang.String str) {
        try {
            return e(str);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    public static byte[] d(java.lang.String str) {
        try {
            return e(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] e(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(com.amap.api.col.s.bu.c("ETUQ1"));
        messageDigest.update(com.amap.api.col.s.bu.a(str));
        return messageDigest.digest();
    }
}
