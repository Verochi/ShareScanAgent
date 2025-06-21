package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class m {
    private static final int a = 32;
    private int b;
    private long[] c;

    public m() {
        this((byte) 0);
    }

    private m(byte b) {
        this.c = new long[32];
    }

    private int a() {
        return this.b;
    }

    private long a(int i) {
        if (i >= 0 && i < this.b) {
            return this.c[i];
        }
        throw new java.lang.IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.b);
    }

    private void a(long j) {
        int i = this.b;
        long[] jArr = this.c;
        if (i == jArr.length) {
            this.c = java.util.Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.c;
        int i2 = this.b;
        this.b = i2 + 1;
        jArr2[i2] = j;
    }

    private long[] b() {
        return java.util.Arrays.copyOf(this.c, this.b);
    }
}
