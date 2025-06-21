package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class LongArray {
    public int a;
    public long[] b;

    public LongArray() {
        this(32);
    }

    public LongArray(int i) {
        this.b = new long[i];
    }

    public void add(long j) {
        int i = this.a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = java.util.Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public long get(int i) {
        if (i >= 0 && i < this.a) {
            return this.b[i];
        }
        int i2 = this.a;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new java.lang.IndexOutOfBoundsException(sb.toString());
    }

    public int size() {
        return this.a;
    }

    public long[] toArray() {
        return java.util.Arrays.copyOf(this.b, this.a);
    }
}
