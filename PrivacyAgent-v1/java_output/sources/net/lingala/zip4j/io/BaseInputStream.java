package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public abstract class BaseInputStream extends java.io.InputStream {
    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        return 0;
    }

    public net.lingala.zip4j.unzip.UnzipEngine getUnzipEngine() {
        return null;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        return 0;
    }

    public void seek(long j) throws java.io.IOException {
    }
}
