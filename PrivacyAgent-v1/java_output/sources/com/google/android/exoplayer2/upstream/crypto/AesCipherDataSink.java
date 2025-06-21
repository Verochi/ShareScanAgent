package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes22.dex */
public final class AesCipherDataSink implements com.google.android.exoplayer2.upstream.DataSink {
    public final com.google.android.exoplayer2.upstream.DataSink a;
    public final byte[] b;

    @androidx.annotation.Nullable
    public final byte[] c;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher d;

    public AesCipherDataSink(byte[] bArr, com.google.android.exoplayer2.upstream.DataSink dataSink) {
        this(bArr, dataSink, null);
    }

    public AesCipherDataSink(byte[] bArr, com.google.android.exoplayer2.upstream.DataSink dataSink, @androidx.annotation.Nullable byte[] bArr2) {
        this.a = dataSink;
        this.b = bArr;
        this.c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws java.io.IOException {
        this.d = null;
        this.a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.a.open(dataSpec);
        this.d = new com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher(1, this.b, com.google.android.exoplayer2.upstream.crypto.CryptoUtil.a(dataSpec.key), dataSpec.uriPositionOffset + dataSpec.position);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.c == null) {
            ((com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher) com.google.android.exoplayer2.util.Util.castNonNull(this.d)).updateInPlace(bArr, i, i2);
            this.a.write(bArr, i, i2);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            int min = java.lang.Math.min(i2 - i3, this.c.length);
            ((com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher) com.google.android.exoplayer2.util.Util.castNonNull(this.d)).update(bArr, i + i3, min, this.c, 0);
            this.a.write(this.c, 0, min);
            i3 += min;
        }
    }
}
