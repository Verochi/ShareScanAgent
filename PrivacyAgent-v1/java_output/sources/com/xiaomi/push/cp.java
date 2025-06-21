package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cp {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static byte[] a(java.lang.String str, byte[] bArr) {
        byte[] b = com.xiaomi.push.al.b(str);
        try {
            a(b);
            return com.xiaomi.push.hb.a(b, bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] b(java.lang.String str, byte[] bArr) {
        byte[] b = com.xiaomi.push.al.b(str);
        try {
            a(b);
            return com.xiaomi.push.hb.b(b, bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
