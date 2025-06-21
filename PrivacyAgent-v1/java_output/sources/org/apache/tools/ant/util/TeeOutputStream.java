package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class TeeOutputStream extends java.io.OutputStream {
    public java.io.OutputStream n;
    public java.io.OutputStream t;

    public TeeOutputStream(java.io.OutputStream outputStream, java.io.OutputStream outputStream2) {
        this.n = outputStream;
        this.t = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        try {
            this.n.close();
        } finally {
            this.t.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.n.flush();
        this.t.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.n.write(i);
        this.t.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        this.n.write(bArr);
        this.t.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.n.write(bArr, i, i2);
        this.t.write(bArr, i, i2);
    }
}
