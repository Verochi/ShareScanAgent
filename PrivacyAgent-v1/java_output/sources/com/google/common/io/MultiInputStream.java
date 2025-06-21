package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class MultiInputStream extends java.io.InputStream {
    public java.util.Iterator<? extends com.google.common.io.ByteSource> n;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.io.InputStream t;

    public MultiInputStream(java.util.Iterator<? extends com.google.common.io.ByteSource> it) throws java.io.IOException {
        this.n = (java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(it);
        a();
    }

    public final void a() throws java.io.IOException {
        close();
        if (this.n.hasNext()) {
            this.t = this.n.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        java.io.InputStream inputStream = this.t;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.InputStream inputStream = this.t;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.t = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        while (true) {
            java.io.InputStream inputStream = this.t;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public int read(@org.checkerframework.checker.nullness.compatqual.NullableDecl byte[] bArr, int i, int i2) throws java.io.IOException {
        while (true) {
            java.io.InputStream inputStream = this.t;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        java.io.InputStream inputStream = this.t;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.t.skip(j - 1) + 1;
    }
}
