package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class j {
    static final char[] a = "0123456789ABCDEF".toCharArray();

    public static java.lang.String a(byte[] bArr, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i * 2);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2 + 0] & 255;
            char[] cArr = a;
            sb.append(cArr[i3 >> 4]);
            sb.append(cArr[i3 & 15]);
        }
        return sb.toString();
    }

    public static boolean a() {
        return com.xiaomi.push.i.a;
    }
}
