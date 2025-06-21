package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class ReusableBufferedOutputStream extends java.io.BufferedOutputStream {
    public boolean n;

    public ReusableBufferedOutputStream(java.io.OutputStream outputStream) {
        super(outputStream);
    }

    public ReusableBufferedOutputStream(java.io.OutputStream outputStream, int i) {
        super(outputStream, i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.n = true;
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
            com.google.android.exoplayer2.util.Util.sneakyThrow(th);
        }
    }

    public void reset(java.io.OutputStream outputStream) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.n);
        ((java.io.BufferedOutputStream) this).out = outputStream;
        ((java.io.BufferedOutputStream) this).count = 0;
        this.n = false;
    }
}
