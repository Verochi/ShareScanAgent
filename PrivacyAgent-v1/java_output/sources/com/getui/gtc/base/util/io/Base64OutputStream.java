package com.getui.gtc.base.util.io;

/* loaded from: classes22.dex */
public class Base64OutputStream extends java.io.OutputStream {
    private int buffer;
    private int bytecounter;
    private int linecounter;
    private int linelength;
    private java.io.OutputStream outputStream;

    public Base64OutputStream(java.io.OutputStream outputStream) {
        this(outputStream, 76);
    }

    public Base64OutputStream(java.io.OutputStream outputStream, int i) {
        this.buffer = 0;
        this.bytecounter = 0;
        this.linecounter = 0;
        this.outputStream = outputStream;
        this.linelength = i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        commit();
        this.outputStream.close();
    }

    public void commit() throws java.io.IOException {
        if (this.bytecounter > 0) {
            int i = this.linelength;
            if (i > 0 && this.linecounter == i) {
                this.outputStream.write("\r\n".getBytes());
                this.linecounter = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 14) >>> 26);
            int i2 = this.bytecounter;
            char c = com.alipay.sdk.m.n.a.h;
            char charAt3 = i2 < 2 ? com.alipay.sdk.m.n.a.h : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 20) >>> 26);
            if (this.bytecounter >= 3) {
                c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 26) >>> 26);
            }
            this.outputStream.write(charAt);
            this.outputStream.write(charAt2);
            this.outputStream.write(charAt3);
            this.outputStream.write(c);
            this.linecounter += 4;
            this.bytecounter = 0;
            this.buffer = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        int i2 = this.bytecounter;
        this.buffer = ((i & 255) << (16 - (i2 * 8))) | this.buffer;
        int i3 = i2 + 1;
        this.bytecounter = i3;
        if (i3 == 3) {
            commit();
        }
    }
}
