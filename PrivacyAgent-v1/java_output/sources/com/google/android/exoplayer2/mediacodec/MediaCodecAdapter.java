package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public interface MediaCodecAdapter {
    void configure(@androidx.annotation.Nullable android.media.MediaFormat mediaFormat, @androidx.annotation.Nullable android.view.Surface surface, @androidx.annotation.Nullable android.media.MediaCrypto mediaCrypto, int i);

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(android.media.MediaCodec.BufferInfo bufferInfo);

    void flush();

    android.media.MediaCodec getCodec();

    android.media.MediaFormat getOutputFormat();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void queueSecureInputBuffer(int i, int i2, com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, long j, int i3);

    void shutdown();

    void start();
}
