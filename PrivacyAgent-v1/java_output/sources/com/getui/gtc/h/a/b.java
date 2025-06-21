package com.getui.gtc.h.a;

/* loaded from: classes22.dex */
public final class b {
    public static byte[] a(byte[] bArr, java.lang.String str) {
        return a(bArr, str.getBytes());
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        boolean z = false;
        if (length > 0 && length <= 256) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if ((bArr2[i] & 255) == 14 && (i2 = i2 + 1) > 3) {
                    break;
                }
                i++;
            }
        }
        if (!z) {
            throw new java.lang.IllegalArgumentException("key is fail!");
        }
        if (bArr.length <= 0) {
            throw new java.lang.IllegalArgumentException("data is fail!");
        }
        try {
            return com.getui.gtc.base.crypt.CryptTools.encrypt("RC4", com.getui.gtc.base.crypt.CryptTools.wrapperKey("RC4", bArr2), (javax.crypto.spec.IvParameterSpec) null, bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
