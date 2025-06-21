package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_yl extends android.media.MediaDataSource {
    public final /* synthetic */ java.nio.ByteBuffer jad_an;

    public jad_yl(com.jd.ad.sdk.jad_te.jad_xk.jad_dq jad_dqVar, java.nio.ByteBuffer byteBuffer) {
        this.jad_an = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return this.jad_an.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.jad_an.limit()) {
            return -1;
        }
        this.jad_an.position((int) j);
        int min = java.lang.Math.min(i2, this.jad_an.remaining());
        this.jad_an.get(bArr, i, min);
        return min;
    }
}
