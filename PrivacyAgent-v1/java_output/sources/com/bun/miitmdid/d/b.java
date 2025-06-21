package com.bun.miitmdid.d;

/* loaded from: classes.dex */
public class b {
    public static final byte[] a = "#PART#".getBytes();

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return new java.lang.String(android.util.Base64.encode(b(str.getBytes(), android.util.Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0)), 2));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(bArr2));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length <= 117) {
            return a(bArr, bArr2);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(2048);
        byte[] bArr3 = new byte[117];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            bArr3[i3] = bArr[i2];
            i3++;
            if (i3 == 117 || i2 == length - 1) {
                i4++;
                if (i4 != 1) {
                    for (byte b : a) {
                        arrayList.add(java.lang.Byte.valueOf(b));
                    }
                }
                for (byte b2 : a(bArr3, bArr2)) {
                    arrayList.add(java.lang.Byte.valueOf(b2));
                }
                bArr3 = i2 == length + (-1) ? null : new byte[java.lang.Math.min(117, (length - i2) - 1)];
                i3 = 0;
            }
            i2++;
        }
        byte[] bArr4 = new byte[arrayList.size()];
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bArr4[i] = ((java.lang.Byte) it.next()).byteValue();
            i++;
        }
        return bArr4;
    }
}
