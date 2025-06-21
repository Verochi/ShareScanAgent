package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class ZipInputStream extends java.io.InputStream {
    public net.lingala.zip4j.io.BaseInputStream n;

    public ZipInputStream(net.lingala.zip4j.io.BaseInputStream baseInputStream) {
        this.n = baseInputStream;
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        return this.n.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        close(false);
    }

    public void close(boolean z) throws java.io.IOException {
        try {
            this.n.close();
            if (z || this.n.getUnzipEngine() == null) {
                return;
            }
            this.n.getUnzipEngine().checkCRC();
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw new java.io.IOException(e.getMessage());
        }
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int read = this.n.read();
        if (read != -1) {
            this.n.getUnzipEngine().updateCRC(read);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = this.n.read(bArr, i, i2);
        if (read > 0 && this.n.getUnzipEngine() != null) {
            this.n.getUnzipEngine().updateCRC(bArr, i, read);
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        return this.n.skip(j);
    }
}
