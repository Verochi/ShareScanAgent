package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class x extends java.io.BufferedOutputStream {
    private boolean a;

    public x(java.io.OutputStream outputStream) {
        super(outputStream);
    }

    public x(java.io.OutputStream outputStream, int i) {
        super(outputStream, i);
    }

    public final void a(java.io.OutputStream outputStream) {
        com.anythink.expressad.exoplayer.k.a.b(this.a);
        ((java.io.BufferedOutputStream) this).out = outputStream;
        ((java.io.BufferedOutputStream) this).count = 0;
        this.a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a = true;
        try {
            flush();
            th = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            ((java.io.BufferedOutputStream) this).out.close();
        } catch (java.lang.Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            com.anythink.expressad.exoplayer.k.af.a(th);
        }
    }
}
