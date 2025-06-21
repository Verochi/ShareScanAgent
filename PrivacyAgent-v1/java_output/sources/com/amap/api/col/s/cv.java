package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class cv implements java.io.Closeable {
    public static final java.nio.charset.Charset a = java.nio.charset.Charset.forName("US-ASCII");
    public final java.io.InputStream n;
    public final java.nio.charset.Charset t;
    public byte[] u;
    public int v;
    public int w;

    /* renamed from: com.amap.api.col.s.cv$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.ByteArrayOutputStream {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public final java.lang.String toString() {
            int i = ((java.io.ByteArrayOutputStream) this).count;
            if (i > 0 && ((java.io.ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new java.lang.String(((java.io.ByteArrayOutputStream) this).buf, 0, i, com.amap.api.col.s.cv.this.t.name());
            } catch (java.io.UnsupportedEncodingException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public cv(java.io.InputStream inputStream, java.nio.charset.Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    public cv(java.io.InputStream inputStream, java.nio.charset.Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(a)) {
            throw new java.lang.IllegalArgumentException("Unsupported encoding");
        }
        this.n = inputStream;
        this.t = charset;
        this.u = new byte[8192];
    }

    public final java.lang.String a() throws java.io.IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.n) {
            if (this.u == null) {
                throw new java.io.IOException("LineReader is closed");
            }
            if (this.v >= this.w) {
                c();
            }
            for (int i3 = this.v; i3 != this.w; i3++) {
                byte[] bArr2 = this.u;
                if (bArr2[i3] == 10) {
                    int i4 = this.v;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] == 13) {
                            java.lang.String str = new java.lang.String(bArr2, i4, i2 - i4, this.t.name());
                            this.v = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    java.lang.String str2 = new java.lang.String(bArr2, i4, i2 - i4, this.t.name());
                    this.v = i3 + 1;
                    return str2;
                }
            }
            com.amap.api.col.s.cv.AnonymousClass1 anonymousClass1 = new com.amap.api.col.s.cv.AnonymousClass1((this.w - this.v) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.u;
                int i5 = this.v;
                anonymousClass1.write(bArr3, i5, this.w - i5);
                this.w = -1;
                c();
                i = this.v;
                while (i != this.w) {
                    bArr = this.u;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.v;
            if (i != i6) {
                anonymousClass1.write(bArr, i6, i - i6);
            }
            this.v = i + 1;
            return anonymousClass1.toString();
        }
    }

    public final void c() throws java.io.IOException {
        java.io.InputStream inputStream = this.n;
        byte[] bArr = this.u;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new java.io.EOFException();
        }
        this.v = 0;
        this.w = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws java.io.IOException {
        synchronized (this.n) {
            if (this.u != null) {
                this.u = null;
                this.n.close();
            }
        }
    }
}
