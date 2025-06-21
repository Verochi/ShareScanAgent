package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public final class jad_jt extends java.io.FilterInputStream {
    public static final byte[] jad_cp = {-1, -31, 0, com.google.common.base.Ascii.FS, 69, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, com.google.common.base.Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
    public final byte jad_an;
    public int jad_bo;

    public jad_jt(java.io.InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.jad_an = (byte) i;
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot add invalid orientation: " + i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i = this.jad_bo;
        int read = (i < 2 || i > 31) ? super.read() : i == 31 ? this.jad_an : jad_cp[i - 2] & 255;
        if (read != -1) {
            this.jad_bo++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.jad_bo;
        if (i4 > 31) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == 31) {
            bArr[i] = this.jad_an;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = java.lang.Math.min(31 - i4, i2);
            java.lang.System.arraycopy(jad_cp, this.jad_bo - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.jad_bo += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.jad_bo = (int) (this.jad_bo + skip);
        }
        return skip;
    }
}
