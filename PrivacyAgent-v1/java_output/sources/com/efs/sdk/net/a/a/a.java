package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class a extends java.io.FilterOutputStream {
    private long a;

    public a(java.io.OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        ((java.io.FilterOutputStream) this).out.write(i);
        this.a++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
        this.a += i2;
    }
}
