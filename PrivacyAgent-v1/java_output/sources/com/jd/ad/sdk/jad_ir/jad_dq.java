package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_dq extends java.io.InputStream {

    @androidx.annotation.GuardedBy("POOL")
    public static final java.util.Queue<com.jd.ad.sdk.jad_ir.jad_dq> jad_cp;
    public java.io.InputStream jad_an;
    public java.io.IOException jad_bo;

    static {
        char[] cArr = com.jd.ad.sdk.jad_ir.jad_ly.jad_an;
        jad_cp = new java.util.ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.jad_an.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.close();
    }

    public void jad_bo() {
        this.jad_bo = null;
        this.jad_an = null;
        java.util.Queue<com.jd.ad.sdk.jad_ir.jad_dq> queue = jad_cp;
        synchronized (queue) {
            ((java.util.ArrayDeque) queue).offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.jad_an.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.jad_an.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.jad_an.read();
        } catch (java.io.IOException e) {
            this.jad_bo = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.jad_an.read(bArr);
        } catch (java.io.IOException e) {
            this.jad_bo = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.jad_an.read(bArr, i, i2);
        } catch (java.io.IOException e) {
            this.jad_bo = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.jad_an.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.jad_an.skip(j);
        } catch (java.io.IOException e) {
            this.jad_bo = e;
            throw e;
        }
    }
}
