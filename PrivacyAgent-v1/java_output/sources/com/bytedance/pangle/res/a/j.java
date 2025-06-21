package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public abstract class j extends java.io.FilterInputStream {
    public j(java.io.InputStream inputStream) {
        super(inputStream);
    }

    public void a(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        try {
            return super.available();
        } catch (java.io.IOException e) {
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            ((java.io.FilterInputStream) this).in.close();
        } catch (java.io.IOException e) {
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        ((java.io.FilterInputStream) this).in.mark(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((java.io.FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        try {
            int read = ((java.io.FilterInputStream) this).in.read();
            a(read != -1 ? 1 : -1);
            return read;
        } catch (java.io.IOException e) {
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        try {
            int read = ((java.io.FilterInputStream) this).in.read(bArr);
            a(read);
            return read;
        } catch (java.io.IOException e) {
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            int read = ((java.io.FilterInputStream) this).in.read(bArr, i, i2);
            a(read);
            return read;
        } catch (java.io.IOException e) {
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            ((java.io.FilterInputStream) this).in.reset();
        } catch (java.io.IOException e) {
            throw e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        try {
            return ((java.io.FilterInputStream) this).in.skip(j);
        } catch (java.io.IOException e) {
            throw e;
        }
    }
}
