package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ReaderInputStream extends java.io.InputStream {
    public java.io.Reader n;
    public java.lang.String t;
    public byte[] u;
    public int v;

    public ReaderInputStream(java.io.Reader reader) {
        this.t = java.lang.System.getProperty("file.encoding");
        this.n = reader;
    }

    public ReaderInputStream(java.io.Reader reader, java.lang.String str) {
        this(reader);
        if (str == null) {
            throw new java.lang.IllegalArgumentException("encoding must not be null");
        }
        this.t = str;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws java.io.IOException {
        java.io.Reader reader = this.n;
        if (reader == null) {
            throw new java.io.IOException("Stream Closed");
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            return bArr.length - this.v;
        }
        return reader.ready() ? 1 : 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        java.io.Reader reader = this.n;
        if (reader != null) {
            reader.close();
            this.u = null;
            this.n = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        try {
            this.n.mark(i);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws java.io.IOException {
        byte b;
        int i;
        if (this.n == null) {
            throw new java.io.IOException("Stream Closed");
        }
        byte[] bArr = this.u;
        if (bArr == null || (i = this.v) >= bArr.length) {
            byte[] bArr2 = new byte[1];
            if (read(bArr2, 0, 1) <= 0) {
                return -1;
            }
            b = bArr2[0];
        } else {
            b = bArr[i];
            int i2 = i + 1;
            this.v = i2;
            if (i2 == bArr.length) {
                this.u = null;
            }
        }
        return b & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.n == null) {
            throw new java.io.IOException("Stream Closed");
        }
        if (i2 == 0) {
            return 0;
        }
        while (true) {
            byte[] bArr2 = this.u;
            if (bArr2 != null) {
                int length = bArr2.length;
                int i3 = this.v;
                if (i2 > length - i3) {
                    i2 = bArr2.length - i3;
                }
                java.lang.System.arraycopy(bArr2, i3, bArr, i, i2);
                int i4 = this.v + i2;
                this.v = i4;
                if (i4 >= this.u.length) {
                    this.u = null;
                }
                return i2;
            }
            char[] cArr = new char[i2];
            int read = this.n.read(cArr);
            if (read == -1) {
                return -1;
            }
            if (read > 0) {
                this.u = new java.lang.String(cArr, 0, read).getBytes(this.t);
                this.v = 0;
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        java.io.Reader reader = this.n;
        if (reader == null) {
            throw new java.io.IOException("Stream Closed");
        }
        this.u = null;
        reader.reset();
    }
}
