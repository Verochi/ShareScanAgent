package com.bytedance.pangle.f.a;

/* loaded from: classes12.dex */
public final class b {
    java.io.InputStream a;
    private int b;

    public b(java.io.InputStream inputStream) {
        a(inputStream);
    }

    public final int a() {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int read = this.a.read();
            if (read == -1) {
                throw new java.io.EOFException();
            }
            this.b++;
            i |= read << i2;
        }
        return i;
    }

    public final void a(java.io.InputStream inputStream) {
        this.a = inputStream;
        this.b = 0;
    }

    public final int[] a(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = a();
            i--;
            i2++;
        }
        return iArr;
    }

    public final void b() {
        long skip = this.a.skip(4L);
        this.b = (int) (this.b + skip);
        if (skip != 4) {
            throw new java.io.EOFException();
        }
    }

    public final void b(int i) {
        int a = a();
        if (a != i) {
            throw new java.io.IOException(java.lang.String.format("Expected: 0x%08x got: 0x%08x", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(a)));
        }
    }
}
