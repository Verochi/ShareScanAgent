package com.ss.android.socialbase.appdownloader.kz.vw;

/* loaded from: classes19.dex */
public class v {
    private int t;
    private java.io.InputStream vw;
    private boolean wg;

    public v() {
    }

    public v(java.io.InputStream inputStream, boolean z) {
        vw(inputStream, z);
    }

    public final void t() throws java.io.IOException {
        t(4);
    }

    public final void t(int i) throws java.io.IOException {
        if (i > 0) {
            long j = i;
            long skip = this.vw.skip(j);
            this.t = (int) (this.t + skip);
            if (skip != j) {
                throw new java.io.EOFException();
            }
        }
    }

    public final int vw(int i) throws java.io.IOException {
        if (i < 0 || i > 4) {
            throw new java.lang.IllegalArgumentException();
        }
        int i2 = 0;
        if (this.wg) {
            for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                int read = this.vw.read();
                if (read == -1) {
                    throw new java.io.EOFException();
                }
                this.t++;
                i2 |= read << i3;
            }
            return i2;
        }
        int i4 = i * 8;
        int i5 = 0;
        while (i2 != i4) {
            int read2 = this.vw.read();
            if (read2 == -1) {
                throw new java.io.EOFException();
            }
            this.t++;
            i5 |= read2 << i2;
            i2 += 8;
        }
        return i5;
    }

    public final void vw() {
        java.io.InputStream inputStream = this.vw;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
            vw(null, false);
        }
    }

    public final void vw(java.io.InputStream inputStream, boolean z) {
        this.vw = inputStream;
        this.wg = z;
        this.t = 0;
    }

    public final void vw(int[] iArr, int i, int i2) throws java.io.IOException {
        while (i2 > 0) {
            iArr[i] = wg();
            i2--;
            i++;
        }
    }

    public final int wg() throws java.io.IOException {
        return vw(4);
    }

    public final int[] wg(int i) throws java.io.IOException {
        int[] iArr = new int[i];
        vw(iArr, 0, i);
        return iArr;
    }
}
