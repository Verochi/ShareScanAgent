package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public final class h {
    private final java.io.BufferedInputStream a;

    public h(java.io.InputStream inputStream) throws java.io.IOException {
        this.a = new java.io.BufferedInputStream(inputStream);
    }

    private h(java.net.Socket socket) throws java.io.IOException {
        this.a = new java.io.BufferedInputStream(socket.getInputStream());
    }

    private int a() throws java.io.IOException {
        return this.a.read();
    }

    private int a(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 = this.a.read(bArr, i + i3, i2 - i3);
            if (i4 <= 0) {
                break;
            }
            i3 += i4;
        }
        return i4;
    }

    private int b(byte[] bArr) throws java.io.IOException {
        return this.a.read(bArr);
    }

    private void b() throws java.io.IOException {
        this.a.close();
    }

    public final int a(byte[] bArr) throws java.io.IOException {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            i2 = this.a.read(bArr, i, length - i);
            if (i2 <= 0) {
                throw new java.io.IOException("read = -1, end of stream !");
            }
            i += i2;
        }
        return i2;
    }
}
