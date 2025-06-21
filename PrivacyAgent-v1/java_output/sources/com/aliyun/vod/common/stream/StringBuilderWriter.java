package com.aliyun.vod.common.stream;

/* loaded from: classes12.dex */
public class StringBuilderWriter extends java.io.Writer implements java.io.Serializable {
    private final java.lang.StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new java.lang.StringBuilder();
    }

    public StringBuilderWriter(int i) {
        this.builder = new java.lang.StringBuilder(i);
    }

    public StringBuilderWriter(java.lang.StringBuilder sb) {
        this.builder = sb == null ? new java.lang.StringBuilder() : sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public java.io.Writer append(char c) {
        this.builder.append(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public java.io.Writer append(java.lang.CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public java.io.Writer append(java.lang.CharSequence charSequence, int i, int i2) {
        this.builder.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public java.lang.StringBuilder getBuilder() {
        return this.builder;
    }

    public java.lang.String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(java.lang.String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.builder.append(cArr, i, i2);
        }
    }
}
