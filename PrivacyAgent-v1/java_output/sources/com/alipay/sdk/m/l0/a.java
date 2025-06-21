package com.alipay.sdk.m.l0;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(java.lang.String str) {
        byte[] bArr;
        try {
            bArr = a(a(), str.getBytes());
        } catch (java.lang.Exception unused) {
            bArr = null;
        }
        if (bArr != null) {
            return a(bArr);
        }
        return null;
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            a(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    public static void a(java.lang.StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
    }

    public static byte[] a() throws java.lang.Exception {
        return com.alipay.sdk.m.l0.e.a(new byte[]{33, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, -50, -89, -84, -114, 80, 99, 10, 63, com.google.common.base.Ascii.SYN, -65, -11, com.google.common.base.Ascii.RS, 101, -118});
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m11a(java.lang.String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = java.lang.Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws java.lang.Exception {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(b()));
        return cipher.doFinal(bArr2);
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            return new java.lang.String(b(a(), m11a(str)));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] b() {
        try {
            byte[] a = com.alipay.sdk.m.l0.b.a("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
            if (a != null) {
                return com.alipay.sdk.m.l0.e.a(a);
            }
        } catch (java.lang.Exception unused) {
        }
        return new byte[16];
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws java.lang.Exception {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(b()));
        return cipher.doFinal(bArr2);
    }
}
