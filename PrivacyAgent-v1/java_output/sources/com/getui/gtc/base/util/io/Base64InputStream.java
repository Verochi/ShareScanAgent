package com.getui.gtc.base.util.io;

/* loaded from: classes22.dex */
public class Base64InputStream extends java.io.InputStream {
    private int[] buffer;
    private int bufferCounter = 0;
    private boolean eof = false;
    private java.io.InputStream inputStream;

    public Base64InputStream(java.io.InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private void acquire() throws java.io.IOException {
        int i;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int read = this.inputStream.read();
            i = 1;
            if (read == -1) {
                if (i2 != 0) {
                    throw new java.io.IOException("Bad base64 stream");
                }
                this.buffer = new int[0];
                this.eof = true;
                return;
            }
            char c = (char) read;
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c) != -1 || c == '=') {
                cArr[i2] = c;
                i2++;
            } else if (c != '\r' && c != '\n') {
                throw new java.io.IOException("Bad base64 stream");
            }
        } while (i2 < 4);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            if (cArr[i3] != '=') {
                if (z) {
                    throw new java.io.IOException("Bad base64 stream");
                }
            } else if (!z) {
                z = true;
            }
        }
        if (cArr[3] != '=') {
            i = 3;
        } else {
            if (this.inputStream.read() != -1) {
                throw new java.io.IOException("Bad base64 stream");
            }
            this.eof = true;
            if (cArr[2] != '=') {
                i = 2;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            char c2 = cArr[i5];
            if (c2 != '=') {
                i4 |= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c2) << ((3 - i5) * 6);
            }
        }
        this.buffer = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            this.buffer[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.inputStream.close();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int[] iArr = this.buffer;
        if (iArr == null || this.bufferCounter == iArr.length) {
            if (this.eof) {
                return -1;
            }
            acquire();
            if (this.buffer.length == 0) {
                this.buffer = null;
                return -1;
            }
            this.bufferCounter = 0;
        }
        int[] iArr2 = this.buffer;
        int i = this.bufferCounter;
        this.bufferCounter = i + 1;
        return iArr2[i];
    }
}
