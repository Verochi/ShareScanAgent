package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public final class i {
    final java.io.BufferedOutputStream a;

    public i(java.io.OutputStream outputStream) throws java.io.IOException {
        this.a = new java.io.BufferedOutputStream(outputStream);
    }

    private i(java.net.Socket socket) throws java.io.IOException {
        this.a = new java.io.BufferedOutputStream(socket.getOutputStream());
    }

    private void a() throws java.io.IOException {
        this.a.close();
    }

    private void a(byte[] bArr) throws java.io.IOException {
        this.a.write(bArr, 0, bArr.length);
        this.a.flush();
    }

    private void a(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.a.write(bArr, i, i2);
        this.a.flush();
    }
}
