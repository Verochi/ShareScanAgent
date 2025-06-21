package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class av {
    private static final byte[] a;
    private static java.security.interfaces.RSAPublicKey b;

    static {
        byte[] bArr = {org.apache.tools.tar.TarConstants.LF_NORMAL, -127, -97, org.apache.tools.tar.TarConstants.LF_NORMAL, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, org.apache.tools.tar.TarConstants.LF_NORMAL, -127, -119, 2, -127, -127, 0, -109, -38, -114, com.google.common.base.Ascii.SUB, -72, 78, 16, 70, -90, 113, -30, 36, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, org.apache.tools.tar.TarConstants.LF_LINK, 13, 16, org.apache.tools.tar.TarConstants.LF_SYMLINK, -27, -82, com.google.common.base.Ascii.DC2, -28, 84, 0, -41, 16, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, -49, 111, -11, org.apache.tools.tar.TarConstants.LF_LINK, com.google.common.base.Ascii.FS, 117, -74, 114, -122, -29, -84, 82, com.google.common.base.Ascii.SYN, -122, 42, -40, -79, com.google.common.base.Ascii.DC2, -116, -42, 101, -70, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, com.google.common.base.Ascii.GS, 47, -24, 110, -66, -7, 87, 16, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        a = bArr;
        try {
            b = (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(bArr));
        } catch (java.lang.Throwable unused) {
            com.xiaomi.channel.commonutils.logger.b.d("rsa key pair init failure!!!");
        }
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, b);
            return android.util.Base64.encodeToString(a(cipher, str.getBytes("UTF-8"), b.getModulus().bitLength()), 2);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static byte[] a(javax.crypto.Cipher cipher, byte[] bArr, int i) {
        if (cipher == null || bArr == null) {
            return null;
        }
        int i2 = (i / 8) - 11;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            int i3 = 0;
            int i4 = 0;
            while (bArr.length > i3) {
                byte[] doFinal = bArr.length - i3 > i2 ? cipher.doFinal(bArr, i3, i2) : cipher.doFinal(bArr, i3, bArr.length - i3);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i4++;
                i3 = i4 * i2;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
