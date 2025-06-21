package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class CountingInputStream extends java.io.FilterInputStream {
    public long n;
    public long t;

    public CountingInputStream(java.io.InputStream inputStream) {
        super((java.io.InputStream) com.google.common.base.Preconditions.checkNotNull(inputStream));
        this.t = -1L;
    }

    public long getCount() {
        return this.n;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        ((java.io.FilterInputStream) this).in.mark(i);
        this.t = this.n;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int read = ((java.io.FilterInputStream) this).in.read();
        if (read != -1) {
            this.n++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = ((java.io.FilterInputStream) this).in.read(bArr, i, i2);
        if (read != -1) {
            this.n += read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        if (!((java.io.FilterInputStream) this).in.markSupported()) {
            throw new java.io.IOException("Mark not supported");
        }
        if (this.t == -1) {
            throw new java.io.IOException("Mark not set");
        }
        ((java.io.FilterInputStream) this).in.reset();
        this.n = this.t;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        long skip = ((java.io.FilterInputStream) this).in.skip(j);
        this.n += skip;
        return skip;
    }
}
