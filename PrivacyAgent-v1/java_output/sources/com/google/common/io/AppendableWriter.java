package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class AppendableWriter extends java.io.Writer {
    public final java.lang.Appendable n;
    public boolean t;

    public AppendableWriter(java.lang.Appendable appendable) {
        this.n = (java.lang.Appendable) com.google.common.base.Preconditions.checkNotNull(appendable);
    }

    public final void a() throws java.io.IOException {
        if (this.t) {
            throw new java.io.IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public java.io.Writer append(char c) throws java.io.IOException {
        a();
        this.n.append(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public java.io.Writer append(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.CharSequence charSequence) throws java.io.IOException {
        a();
        this.n.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public java.io.Writer append(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.CharSequence charSequence, int i, int i2) throws java.io.IOException {
        a();
        this.n.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.t = true;
        java.lang.Appendable appendable = this.n;
        if (appendable instanceof java.io.Closeable) {
            ((java.io.Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws java.io.IOException {
        a();
        java.lang.Appendable appendable = this.n;
        if (appendable instanceof java.io.Flushable) {
            ((java.io.Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws java.io.IOException {
        a();
        this.n.append((char) i);
    }

    @Override // java.io.Writer
    public void write(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) throws java.io.IOException {
        a();
        this.n.append(str);
    }

    @Override // java.io.Writer
    public void write(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i, int i2) throws java.io.IOException {
        a();
        this.n.append(str, i, i2 + i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws java.io.IOException {
        a();
        this.n.append(new java.lang.String(cArr, i, i2));
    }
}
