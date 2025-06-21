package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class IntArrayQueue {
    public int a = 0;
    public int b = -1;
    public int c = 0;
    public int[] d = new int[16];
    public int e;

    public IntArrayQueue() {
        this.e = r0.length - 1;
    }

    public final void a() {
        int[] iArr = this.d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new java.lang.IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i = this.a;
        int i2 = length2 - i;
        java.lang.System.arraycopy(iArr, i, iArr2, 0, i2);
        java.lang.System.arraycopy(this.d, 0, iArr2, i2, i);
        this.a = 0;
        this.b = this.c - 1;
        this.d = iArr2;
        this.e = iArr2.length - 1;
    }

    public void add(int i) {
        if (this.c == this.d.length) {
            a();
        }
        int i2 = (this.b + 1) & this.e;
        this.b = i2;
        this.d[i2] = i;
        this.c++;
    }

    public int capacity() {
        return this.d.length;
    }

    public void clear() {
        this.a = 0;
        this.b = -1;
        this.c = 0;
    }

    public boolean isEmpty() {
        return this.c == 0;
    }

    public int remove() {
        int i = this.c;
        if (i == 0) {
            throw new java.util.NoSuchElementException();
        }
        int[] iArr = this.d;
        int i2 = this.a;
        int i3 = iArr[i2];
        this.a = (i2 + 1) & this.e;
        this.c = i - 1;
        return i3;
    }

    public int size() {
        return this.c;
    }
}
