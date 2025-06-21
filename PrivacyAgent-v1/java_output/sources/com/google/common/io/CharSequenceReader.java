package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class CharSequenceReader extends java.io.Reader {
    public java.lang.CharSequence n;
    public int t;
    public int u;

    public CharSequenceReader(java.lang.CharSequence charSequence) {
        this.n = (java.lang.CharSequence) com.google.common.base.Preconditions.checkNotNull(charSequence);
    }

    public final void a() throws java.io.IOException {
        if (this.n == null) {
            throw new java.io.IOException("reader closed");
        }
    }

    public final boolean c() {
        return e() > 0;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        this.n = null;
    }

    public final int e() {
        return this.n.length() - this.t;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i) throws java.io.IOException {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "readAheadLimit (%s) may not be negative", i);
        a();
        this.u = this.t;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public synchronized int read() throws java.io.IOException {
        char c;
        a();
        if (c()) {
            java.lang.CharSequence charSequence = this.n;
            int i = this.t;
            this.t = i + 1;
            c = charSequence.charAt(i);
        } else {
            c = 65535;
        }
        return c;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(java.nio.CharBuffer charBuffer) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(charBuffer);
        a();
        if (!c()) {
            return -1;
        }
        int min = java.lang.Math.min(charBuffer.remaining(), e());
        for (int i = 0; i < min; i++) {
            java.lang.CharSequence charSequence = this.n;
            int i2 = this.t;
            this.t = i2 + 1;
            charBuffer.put(charSequence.charAt(i2));
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i, int i2) throws java.io.IOException {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, cArr.length);
        a();
        if (!c()) {
            return -1;
        }
        int min = java.lang.Math.min(i2, e());
        for (int i3 = 0; i3 < min; i3++) {
            java.lang.CharSequence charSequence = this.n;
            int i4 = this.t;
            this.t = i4 + 1;
            cArr[i + i3] = charSequence.charAt(i4);
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws java.io.IOException {
        a();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws java.io.IOException {
        a();
        this.t = this.u;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j) throws java.io.IOException {
        int min;
        com.google.common.base.Preconditions.checkArgument(j >= 0, "n (%s) may not be negative", j);
        a();
        min = (int) java.lang.Math.min(e(), j);
        this.t += min;
        return min;
    }
}
