package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class j extends java.io.InputStream {
    private final com.anythink.expressad.exoplayer.j.h a;
    private final com.anythink.expressad.exoplayer.j.k b;
    private long f;
    private boolean d = false;
    private boolean e = false;
    private final byte[] c = new byte[1];

    public j(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar) {
        this.a = hVar;
        this.b = kVar;
    }

    private void c() {
        if (this.d) {
            return;
        }
        this.a.a(this.b);
        this.d = true;
    }

    public final long a() {
        return this.f;
    }

    public final void b() {
        c();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.e) {
            return;
        }
        this.a.b();
        this.e = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(@androidx.annotation.NonNull byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.e);
        c();
        int a = this.a.a(bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        this.f += a;
        return a;
    }
}
