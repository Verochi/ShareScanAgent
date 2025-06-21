package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LazyFileOutputStream extends java.io.OutputStream {
    public java.io.FileOutputStream n;
    public java.io.File t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;

    public LazyFileOutputStream(java.io.File file) {
        this(file, false);
    }

    public LazyFileOutputStream(java.io.File file, boolean z) {
        this(file, z, false);
    }

    public LazyFileOutputStream(java.io.File file, boolean z, boolean z2) {
        this.w = false;
        this.x = false;
        this.t = file;
        this.u = z;
        this.v = z2;
    }

    public LazyFileOutputStream(java.lang.String str) {
        this(str, false);
    }

    public LazyFileOutputStream(java.lang.String str, boolean z) {
        this(new java.io.File(str), z);
    }

    public final synchronized void a() throws java.io.IOException {
        if (this.x) {
            throw new java.io.IOException(this.t + " has already been closed.");
        }
        if (!this.w) {
            this.n = new java.io.FileOutputStream(this.t.getAbsolutePath(), this.u);
            this.w = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.v && !this.x) {
            a();
        }
        if (this.w) {
            this.n.close();
        }
        this.x = true;
    }

    public void open() throws java.io.IOException {
        a();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws java.io.IOException {
        a();
        this.n.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        a();
        this.n.write(bArr, i, i2);
    }
}
