package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fd {
    public static java.lang.String a(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            java.io.File file = new java.io.File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(com.amap.api.mapcore.util.fi.c("ETUQ1"));
                fileInputStream = new java.io.FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            com.amap.api.mapcore.util.ga.a(th, "MD5", "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (java.io.IOException e) {
                                    com.amap.api.mapcore.util.ga.a(e, "MD5", "gfm");
                                }
                            }
                        }
                    }
                }
                java.lang.String e2 = com.amap.api.mapcore.util.fi.e(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (java.io.IOException e3) {
                    com.amap.api.mapcore.util.ga.a(e3, "MD5", "gfm");
                }
                return e2;
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        return com.amap.api.mapcore.util.fi.e(a(bArr, com.amap.api.mapcore.util.fi.c("ETUQ1")));
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return com.amap.api.mapcore.util.fi.e(d(str));
    }

    public static java.lang.String c(java.lang.String str) {
        return com.amap.api.mapcore.util.fi.f(e(str));
    }

    private static byte[] d(java.lang.String str) {
        try {
            return f(str);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] e(java.lang.String str) {
        try {
            return f(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(com.amap.api.mapcore.util.fi.c("ETUQ1"));
        messageDigest.update(com.amap.api.mapcore.util.fi.a(str));
        return messageDigest.digest();
    }
}
