package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class BaseNCodecOutputStream extends java.io.FilterOutputStream {
    public final boolean n;
    public final org.apache.commons.codec.binary.BaseNCodec t;
    public final byte[] u;

    public BaseNCodecOutputStream(java.io.OutputStream outputStream, org.apache.commons.codec.binary.BaseNCodec baseNCodec, boolean z) {
        super(outputStream);
        this.u = new byte[1];
        this.t = baseNCodec;
        this.n = z;
    }

    public final void a(boolean z) throws java.io.IOException {
        byte[] bArr;
        int e;
        int a = this.t.a();
        if (a > 0 && (e = this.t.e((bArr = new byte[a]), 0, a)) > 0) {
            ((java.io.FilterOutputStream) this).out.write(bArr, 0, e);
        }
        if (z) {
            ((java.io.FilterOutputStream) this).out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.n) {
            this.t.c(this.u, 0, -1);
        } else {
            this.t.b(this.u, 0, -1);
        }
        flush();
        ((java.io.FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        a(true);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        byte[] bArr = this.u;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i > bArr.length || i + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 > 0) {
            if (this.n) {
                this.t.c(bArr, i, i2);
            } else {
                this.t.b(bArr, i, i2);
            }
            a(false);
        }
    }
}
