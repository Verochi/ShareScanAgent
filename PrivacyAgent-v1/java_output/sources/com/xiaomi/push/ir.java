package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class ir {
    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    public byte[] a() {
        return null;
    }

    public int b() {
        return 0;
    }

    public final int b(byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            int a = a(bArr, i2 + 0, i - i2);
            if (a <= 0) {
                throw new com.xiaomi.push.is("Cannot read. Remote side has closed. Tried to read " + i + " bytes, but only got " + i2 + " bytes.", (byte) 0);
            }
            i2 += a;
        }
        return i2;
    }

    public abstract void b(byte[] bArr, int i, int i2);

    public int c() {
        return -1;
    }
}
