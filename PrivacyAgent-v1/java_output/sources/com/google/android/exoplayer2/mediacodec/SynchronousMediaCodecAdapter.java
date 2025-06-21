package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
final class SynchronousMediaCodecAdapter implements com.google.android.exoplayer2.mediacodec.MediaCodecAdapter {
    public final android.media.MediaCodec a;

    public SynchronousMediaCodecAdapter(android.media.MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void configure(@androidx.annotation.Nullable android.media.MediaFormat mediaFormat, @androidx.annotation.Nullable android.view.Surface surface, @androidx.annotation.Nullable android.media.MediaCrypto mediaCrypto, int i) {
        this.a.configure(mediaFormat, surface, mediaCrypto, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(android.media.MediaCodec.BufferInfo bufferInfo) {
        return this.a.dequeueOutputBuffer(bufferInfo, 0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        this.a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public android.media.MediaCodec getCodec() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public android.media.MediaFormat getOutputFormat() {
        return this.a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int i, int i2, com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        this.a.start();
    }
}
