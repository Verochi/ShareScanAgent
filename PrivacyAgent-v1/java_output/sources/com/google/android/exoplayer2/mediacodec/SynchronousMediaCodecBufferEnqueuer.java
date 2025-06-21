package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
class SynchronousMediaCodecBufferEnqueuer implements com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer {
    public final android.media.MediaCodec a;

    public SynchronousMediaCodecBufferEnqueuer(android.media.MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void flush() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueSecureInputBuffer(int i, int i2, com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void shutdown() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void start() {
    }
}
