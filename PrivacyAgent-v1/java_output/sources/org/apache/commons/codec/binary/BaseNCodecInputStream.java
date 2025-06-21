package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class BaseNCodecInputStream extends java.io.FilterInputStream {
    public final boolean n;
    public final org.apache.commons.codec.binary.BaseNCodec t;
    public final byte[] u;

    public BaseNCodecInputStream(java.io.InputStream inputStream, org.apache.commons.codec.binary.BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.u = new byte[1];
        this.n = z;
        this.t = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int read = read(this.u, 0, 1);
        while (read == 0) {
            read = read(this.u, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        byte b = this.u[0];
        return b < 0 ? b + 256 : b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i > bArr.length || i + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        while (i3 == 0) {
            if (!this.t.d()) {
                byte[] bArr2 = new byte[this.n ? 4096 : 8192];
                int read = ((java.io.FilterInputStream) this).in.read(bArr2);
                if (this.n) {
                    this.t.c(bArr2, 0, read);
                } else {
                    this.t.b(bArr2, 0, read);
                }
            }
            i3 = this.t.e(bArr, i, i2);
        }
        return i3;
    }
}
