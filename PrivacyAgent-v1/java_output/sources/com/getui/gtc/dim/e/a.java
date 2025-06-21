package com.getui.gtc.dim.e;

/* loaded from: classes22.dex */
public final class a {
    public static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            for (int length = bArr.length - 1; length > 0; length--) {
                bArr[length] = (byte) (bArr[length] ^ bArr[length - 1]);
            }
            bArr[0] = (byte) (bArr[0] ^ com.google.common.base.Ascii.ETB);
        }
        return bArr;
    }
}
