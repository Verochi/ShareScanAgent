package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DataSourceInputStream extends java.io.InputStream {
    public final com.google.android.exoplayer2.upstream.DataSource n;
    public final com.google.android.exoplayer2.upstream.DataSpec t;
    public long x;
    public boolean v = false;
    public boolean w = false;
    public final byte[] u = new byte[1];

    public DataSourceInputStream(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        this.n = dataSource;
        this.t = dataSpec;
    }

    public final void a() throws java.io.IOException {
        if (this.v) {
            return;
        }
        this.n.open(this.t);
        this.v = true;
    }

    public long bytesRead() {
        return this.x;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.w) {
            return;
        }
        this.n.close();
        this.w = true;
    }

    public void open() throws java.io.IOException {
        a();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.u) == -1) {
            return -1;
        }
        return this.u[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.w);
        a();
        int read = this.n.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.x += read;
        return read;
    }
}
