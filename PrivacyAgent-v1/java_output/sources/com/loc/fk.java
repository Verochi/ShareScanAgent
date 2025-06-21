package com.loc;

/* loaded from: classes23.dex */
public final class fk {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    private static final byte[] b = {61, 61, 81, 65, 65, 69, 119, 65, 67, org.apache.tools.tar.TarConstants.LF_NORMAL, 74, 80, 115, 116, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 104, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 122, 97, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 99, org.apache.tools.tar.TarConstants.LF_DIR, 71, org.apache.tools.tar.TarConstants.LF_LINK, 122, 68, 70, 79, 104, 113, 113, 65, 97, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, org.apache.tools.tar.TarConstants.LF_FIFO, 65, 66, 87, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 85, 84, 113, 71, 68, 69, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 80, 82, 106, org.apache.tools.tar.TarConstants.LF_CHR, 66, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 69, 98, org.apache.tools.tar.TarConstants.LF_CONTIG, 84, 108, 115, 122, org.apache.tools.tar.TarConstants.LF_CHR, 106, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, org.apache.tools.tar.TarConstants.LF_CONTIG, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 122, 70, 121, 73, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_SYMLINK, 43, 101, 70, 121, 56, 105, 115, 105, 89, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 117, 112, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 119, 65, 119, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 74, 89, 81, 68, 119, 119, 70, 77};
    private static final byte[] c;
    private static final javax.crypto.spec.IvParameterSpec d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        c = bArr;
        d = new javax.crypto.spec.IvParameterSpec(bArr);
    }

    public static java.lang.String a(java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return a("MD5", a("SHA1", str) + str);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return c(com.loc.t.a(str2.getBytes("UTF-8"), str));
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Encrypt", "encode");
            return null;
        }
    }

    private static byte[] a() {
        return com.loc.y.c();
    }

    public static byte[] a(byte[] bArr) throws java.lang.Exception {
        java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(com.loc.ep.a(new java.lang.StringBuilder(new java.lang.String(b)).reverse().toString().getBytes())));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.loc.y.c("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec b2 = b(str);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(a());
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, b2, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    private static javax.crypto.spec.SecretKeySpec b(java.lang.String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new javax.crypto.spec.SecretKeySpec(bArr, "AES");
    }

    public static byte[] b(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
            java.lang.System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.loc.y.c()));
            return cipher.doFinal(bArr3);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Encrypt", "decryptRsponse length = ".concat(java.lang.String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }

    public static byte[] b(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec b2 = b(str);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(a());
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, b2, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    private static java.lang.String c(byte[] bArr) {
        int length = bArr.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i] >> 4) & 15]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
