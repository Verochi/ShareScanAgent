package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class e {
    public static final java.lang.String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzbMQ22qV6umuPXYWXEOGdlpJR\nBWMP68/ArS7XG8+7GmRbWMW1HOMLOOdwuIfPFp9QiwOshG0mYXlm1ecQ/fCXhRMW\nfh+OMCoBdl7vnCpoDYPmjYQBkm9fRW6oej33UhZtlnTZjECAsyC2Eybha7jg3Lft\ngYVnwaPShTmv5+Z9SQIDAQAB";
    private static final java.lang.String b = "LOG-CryptoTool";

    private static byte a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    private static java.lang.String a() throws java.lang.Exception {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return a(keyGenerator.generateKey().getEncoded());
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void a(java.io.RandomAccessFile randomAccessFile) throws java.lang.Exception {
        long length = (int) (randomAccessFile.length() % 16);
        if (length >= 16 || length <= 0) {
            return;
        }
        randomAccessFile.setLength(randomAccessFile.length() - length);
    }

    private static byte[] a(java.lang.String str) throws java.lang.Exception {
        java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(a, 0)));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        cipher.init(1, rSAPublicKey);
        byte[] doFinal = cipher.doFinal(str.getBytes("UTF-8"));
        a(doFinal);
        return doFinal;
    }

    private static java.security.interfaces.RSAPublicKey b(java.lang.String str) throws java.lang.Exception {
        return (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
    }

    private static void b() throws java.lang.Exception {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        com.igexin.push.core.e.aB = keyGenerator.generateKey().getEncoded();
        com.igexin.push.h.o.a(com.igexin.push.core.e.l, com.igexin.push.h.o.g, a(com.igexin.push.h.g.a(com.igexin.push.core.e.aB)));
        com.igexin.push.h.o.b(com.igexin.push.core.e.l, com.igexin.push.h.o.g, "");
    }

    private static byte[] c() {
        if (com.igexin.push.core.e.aB == null) {
            java.lang.String str = (java.lang.String) com.igexin.push.h.o.b(com.igexin.push.core.e.l, com.igexin.push.h.o.g, "");
            byte[] bArr = null;
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            if (str != null && !str.equals("")) {
                java.lang.String upperCase = str.toUpperCase();
                int length = upperCase.length() / 2;
                char[] charArray = upperCase.toCharArray();
                bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
                }
            }
            com.igexin.push.core.e.aB = com.igexin.c.a.a.a.a(bArr, com.igexin.push.core.e.M);
        }
        return com.igexin.push.core.e.aB;
    }

    private static byte[] c(java.lang.String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        java.lang.String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }
}
