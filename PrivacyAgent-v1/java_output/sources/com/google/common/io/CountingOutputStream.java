package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class CountingOutputStream extends java.io.FilterOutputStream {
    public long n;

    public CountingOutputStream(java.io.OutputStream outputStream) {
        super((java.io.OutputStream) com.google.common.base.Preconditions.checkNotNull(outputStream));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.close();
    }

    public long getCount() {
        return this.n;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.write(i);
        this.n++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
        this.n += i2;
    }
}
