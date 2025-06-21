package com.igexin.c.a.b;

/* loaded from: classes22.dex */
public final class a extends java.io.InputStream {
    private java.io.InputStream a;
    private int[] b;
    private int c = 0;
    private boolean d = false;

    public a(java.io.InputStream inputStream) {
        this.a = inputStream;
    }

    private void a() throws java.io.IOException {
        int i;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int read = this.a.read();
            i = 1;
            if (read == -1) {
                if (i2 != 0) {
                    throw new java.io.IOException("Bad base64 stream");
                }
                this.b = new int[0];
                this.d = true;
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
            if (this.a.read() != -1) {
                throw new java.io.IOException("Bad base64 stream");
            }
            this.d = true;
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
        this.b = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            this.b[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws java.io.IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws java.io.IOException {
        int[] iArr = this.b;
        if (iArr == null || this.c == iArr.length) {
            if (this.d) {
                return -1;
            }
            char[] cArr = new char[4];
            int i = 0;
            while (true) {
                int read = this.a.read();
                int i2 = 1;
                if (read != -1) {
                    char c = (char) read;
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c) != -1 || c == '=') {
                        cArr[i] = c;
                        i++;
                    } else if (c != '\r' && c != '\n') {
                        throw new java.io.IOException("Bad base64 stream");
                    }
                    if (i >= 4) {
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
                            i2 = 3;
                        } else {
                            if (this.a.read() != -1) {
                                throw new java.io.IOException("Bad base64 stream");
                            }
                            this.d = true;
                            if (cArr[2] != '=') {
                                i2 = 2;
                            }
                        }
                        int i4 = 0;
                        for (int i5 = 0; i5 < 4; i5++) {
                            char c2 = cArr[i5];
                            if (c2 != '=') {
                                i4 |= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c2) << ((3 - i5) * 6);
                            }
                        }
                        this.b = new int[i2];
                        for (int i6 = 0; i6 < i2; i6++) {
                            this.b[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
                        }
                    }
                } else {
                    if (i != 0) {
                        throw new java.io.IOException("Bad base64 stream");
                    }
                    this.b = new int[0];
                    this.d = true;
                }
            }
            if (this.b.length == 0) {
                this.b = null;
                return -1;
            }
            this.c = 0;
        }
        int[] iArr2 = this.b;
        int i7 = this.c;
        this.c = i7 + 1;
        return iArr2[i7];
    }
}
