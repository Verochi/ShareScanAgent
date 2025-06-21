package com.loc;

/* loaded from: classes23.dex */
public final class t {
    public static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return com.loc.y.e(c(str));
    }

    public static java.lang.String a(byte[] bArr) {
        return com.loc.y.e(a(bArr, com.loc.y.c("ETUQ1")));
    }

    public static byte[] a(byte[] bArr, java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        return com.loc.y.f(d(str));
    }

    private static byte[] c(java.lang.String str) {
        try {
            return e(str);
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] d(java.lang.String str) {
        try {
            return e(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(com.loc.y.c("ETUQ1"));
        messageDigest.update(com.loc.y.a(str));
        return messageDigest.digest();
    }
}
