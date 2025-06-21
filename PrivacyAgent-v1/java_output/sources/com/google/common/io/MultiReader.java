package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class MultiReader extends java.io.Reader {
    public final java.util.Iterator<? extends com.google.common.io.CharSource> n;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.io.Reader t;

    public MultiReader(java.util.Iterator<? extends com.google.common.io.CharSource> it) throws java.io.IOException {
        this.n = it;
        a();
    }

    public final void a() throws java.io.IOException {
        close();
        if (this.n.hasNext()) {
            this.t = this.n.next().openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.Reader reader = this.t;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.t = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(@org.checkerframework.checker.nullness.compatqual.NullableDecl char[] cArr, int i, int i2) throws java.io.IOException {
        java.io.Reader reader = this.t;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i, i2);
        if (read != -1) {
            return read;
        }
        a();
        return read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() throws java.io.IOException {
        java.io.Reader reader = this.t;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j) throws java.io.IOException {
        com.google.common.base.Preconditions.checkArgument(j >= 0, "n is negative");
        if (j > 0) {
            while (true) {
                java.io.Reader reader = this.t;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j);
                if (skip > 0) {
                    return skip;
                }
                a();
            }
        }
        return 0L;
    }
}
