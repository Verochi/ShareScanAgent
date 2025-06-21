package com.jd.ad.sdk.jad_hs;

/* loaded from: classes23.dex */
public class jad_bo implements java.io.Closeable {
    public final java.io.InputStream jad_an;
    public final java.nio.charset.Charset jad_bo;
    public byte[] jad_cp;
    public int jad_dq;
    public int jad_er;

    public class jad_an extends java.io.ByteArrayOutputStream {
        public jad_an(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public java.lang.String toString() {
            int i = ((java.io.ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((java.io.ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            try {
                return new java.lang.String(((java.io.ByteArrayOutputStream) this).buf, 0, i, com.jd.ad.sdk.jad_hs.jad_bo.this.jad_bo.name());
            } catch (java.io.UnsupportedEncodingException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public jad_bo(java.io.InputStream inputStream, int i, java.nio.charset.Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(com.jd.ad.sdk.jad_hs.jad_cp.jad_an)) {
            throw new java.lang.IllegalArgumentException("Unsupported encoding");
        }
        this.jad_an = inputStream;
        this.jad_bo = charset;
        this.jad_cp = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.jad_an) {
            if (this.jad_cp != null) {
                this.jad_cp = null;
                this.jad_an.close();
            }
        }
    }

    public final void jad_bo() {
        java.io.InputStream inputStream = this.jad_an;
        byte[] bArr = this.jad_cp;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new java.io.EOFException();
        }
        this.jad_dq = 0;
        this.jad_er = read;
    }

    public java.lang.String jad_cp() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.jad_an) {
            if (this.jad_cp == null) {
                throw new java.io.IOException("LineReader is closed");
            }
            if (this.jad_dq >= this.jad_er) {
                jad_bo();
            }
            for (int i3 = this.jad_dq; i3 != this.jad_er; i3++) {
                byte[] bArr2 = this.jad_cp;
                if (bArr2[i3] == 10) {
                    int i4 = this.jad_dq;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] == 13) {
                            java.lang.String str = new java.lang.String(bArr2, i4, i2 - i4, this.jad_bo.name());
                            this.jad_dq = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    java.lang.String str2 = new java.lang.String(bArr2, i4, i2 - i4, this.jad_bo.name());
                    this.jad_dq = i3 + 1;
                    return str2;
                }
            }
            com.jd.ad.sdk.jad_hs.jad_bo.jad_an jad_anVar = new com.jd.ad.sdk.jad_hs.jad_bo.jad_an((this.jad_er - this.jad_dq) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.jad_cp;
                int i5 = this.jad_dq;
                jad_anVar.write(bArr3, i5, this.jad_er - i5);
                this.jad_er = -1;
                jad_bo();
                i = this.jad_dq;
                while (i != this.jad_er) {
                    bArr = this.jad_cp;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.jad_dq;
            if (i != i6) {
                jad_anVar.write(bArr, i6, i - i6);
            }
            this.jad_dq = i + 1;
            return jad_anVar.toString();
        }
    }
}
