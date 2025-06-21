package cn.fly.verify;

/* loaded from: classes.dex */
public class ev extends java.io.InputStream {
    private java.io.InputStream a;
    private long b;
    private cn.fly.verify.fd c;

    public ev(java.io.InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int read = this.a.read();
        if (read >= 0) {
            long j = this.b + 1;
            this.b = j;
            cn.fly.verify.fd fdVar = this.c;
            if (fdVar != null) {
                fdVar.a(j);
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = this.a.read(bArr, i, i2);
        if (read > 0) {
            long j = this.b + read;
            this.b = j;
            cn.fly.verify.fd fdVar = this.c;
            if (fdVar != null) {
                fdVar.a(j);
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        this.a.reset();
        this.b = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        return this.a.skip(j);
    }
}
