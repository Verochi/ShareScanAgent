package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
class Aes128DataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final com.google.android.exoplayer2.upstream.DataSource a;
    public final byte[] b;
    public final byte[] c;

    @androidx.annotation.Nullable
    public javax.crypto.CipherInputStream d;

    public Aes128DataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.a = dataSource;
        this.b = bArr;
        this.c = bArr2;
    }

    public javax.crypto.Cipher a() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException {
        return javax.crypto.Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws java.io.IOException {
        if (this.d != null) {
            this.d = null;
            this.a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public final android.net.Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        try {
            javax.crypto.Cipher a = a();
            try {
                a.init(2, new javax.crypto.spec.SecretKeySpec(this.b, "AES"), new javax.crypto.spec.IvParameterSpec(this.c));
                com.google.android.exoplayer2.upstream.DataSourceInputStream dataSourceInputStream = new com.google.android.exoplayer2.upstream.DataSourceInputStream(this.a, dataSpec);
                this.d = new javax.crypto.CipherInputStream(dataSourceInputStream, a);
                dataSourceInputStream.open();
                return -1L;
            } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException e) {
                throw new java.lang.RuntimeException(e);
            }
        } catch (java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public final int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d);
        int read = this.d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
