package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bz {
    public static final byte a(byte b, int i, boolean z) {
        return (byte) a((int) b, i, z);
    }

    public static final int a(int i, int i2, boolean z) {
        return z ? i | (1 << i2) : b(i, i2);
    }

    public static final int a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static final int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static final long a(long j, int i, boolean z) {
        return z ? j | (1 << i) : b(j, i);
    }

    public static final short a(short s2, int i, boolean z) {
        return (short) a((int) s2, i, z);
    }

    public static final void a(int i, byte[] bArr) {
        a(i, bArr, 0);
    }

    public static final void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
    }

    public static final boolean a(byte b, int i) {
        return a((int) b, i);
    }

    public static final boolean a(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    public static final boolean a(long j, int i) {
        return (j & (1 << i)) != 0;
    }

    public static final boolean a(short s2, int i) {
        return a((int) s2, i);
    }

    public static final byte b(byte b, int i) {
        return (byte) b((int) b, i);
    }

    public static final int b(int i, int i2) {
        return i & (~(1 << i2));
    }

    public static final long b(long j, int i) {
        return j & (~(1 << i));
    }

    public static final short b(short s2, int i) {
        return (short) b((int) s2, i);
    }
}
