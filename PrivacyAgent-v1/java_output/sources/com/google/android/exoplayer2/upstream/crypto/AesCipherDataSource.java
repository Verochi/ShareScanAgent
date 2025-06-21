package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes22.dex */
public final class AesCipherDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final com.google.android.exoplayer2.upstream.DataSource a;
    public final byte[] b;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher c;

    public AesCipherDataSource(byte[] bArr, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.a = dataSource;
        this.b = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws java.io.IOException {
        this.c = null;
        this.a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        long open = this.a.open(dataSpec);
        this.c = new com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher(2, this.b, com.google.android.exoplayer2.upstream.crypto.CryptoUtil.a(dataSpec.key), dataSpec.uriPositionOffset + dataSpec.position);
        return open;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        int read = this.a.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        ((com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher) com.google.android.exoplayer2.util.Util.castNonNull(this.c)).updateInPlace(bArr, i, read);
        return read;
    }
}
