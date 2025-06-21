package com.loc;

/* loaded from: classes23.dex */
public final class bn implements java.io.Closeable {
    public static final java.nio.charset.Charset a = java.nio.charset.Charset.forName("US-ASCII");
    private final java.io.InputStream b;
    private final java.nio.charset.Charset c;
    private byte[] d;
    private int e;
    private int f;

    /* renamed from: com.loc.bn$1, reason: invalid class name */
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
                return new java.lang.String(((java.io.ByteArrayOutputStream) this).buf, 0, i, com.loc.bn.this.c.name());
            } catch (java.io.UnsupportedEncodingException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public bn(java.io.InputStream inputStream, java.nio.charset.Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private bn(java.io.InputStream inputStream, java.nio.charset.Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(a)) {
            throw new java.lang.IllegalArgumentException("Unsupported encoding");
        }
        this.b = inputStream;
        this.c = charset;
        this.d = new byte[8192];
    }

    private void b() throws java.io.IOException {
        java.io.InputStream inputStream = this.b;
        byte[] bArr = this.d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new java.io.EOFException();
        }
        this.e = 0;
        this.f = read;
    }

    public final java.lang.String a() throws java.io.IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.b) {
            if (this.d == null) {
                throw new java.io.IOException("LineReader is closed");
            }
            if (this.e >= this.f) {
                b();
            }
            for (int i3 = this.e; i3 != this.f; i3++) {
                byte[] bArr2 = this.d;
                if (bArr2[i3] == 10) {
                    int i4 = this.e;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] == 13) {
                            java.lang.String str = new java.lang.String(bArr2, i4, i2 - i4, this.c.name());
                            this.e = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    java.lang.String str2 = new java.lang.String(bArr2, i4, i2 - i4, this.c.name());
                    this.e = i3 + 1;
                    return str2;
                }
            }
            com.loc.bn.AnonymousClass1 anonymousClass1 = new com.loc.bn.AnonymousClass1((this.f - this.e) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.d;
                int i5 = this.e;
                anonymousClass1.write(bArr3, i5, this.f - i5);
                this.f = -1;
                b();
                i = this.e;
                while (i != this.f) {
                    bArr = this.d;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.e;
            if (i != i6) {
                anonymousClass1.write(bArr, i6, i - i6);
            }
            this.e = i + 1;
            return anonymousClass1.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws java.io.IOException {
        synchronized (this.b) {
            if (this.d != null) {
                this.d = null;
                this.b.close();
            }
        }
    }
}
