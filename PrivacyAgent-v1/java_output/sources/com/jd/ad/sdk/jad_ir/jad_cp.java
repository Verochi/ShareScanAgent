package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_cp extends java.io.FilterInputStream {
    public final long jad_an;
    public int jad_bo;

    public jad_cp(@androidx.annotation.NonNull java.io.InputStream inputStream, long j) {
        super(inputStream);
        this.jad_an = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) java.lang.Math.max(this.jad_an - this.jad_bo, ((java.io.FilterInputStream) this).in.available());
    }

    public final int jad_an(int i) {
        if (i >= 0) {
            this.jad_bo += i;
        } else if (this.jad_an - this.jad_bo > 0) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed to read all expected data, expected: ");
            jad_an.append(this.jad_an);
            jad_an.append(", but read: ");
            jad_an.append(this.jad_bo);
            throw new java.io.IOException(jad_an.toString());
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        jad_an(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int jad_an;
        int length = bArr.length;
        synchronized (this) {
            jad_an = jad_an(super.read(bArr, 0, length));
        }
        return jad_an;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return jad_an(super.read(bArr, i, i2));
    }
}
