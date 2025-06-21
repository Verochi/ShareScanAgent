package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
interface MediaCodecInputBufferEnqueuer {
    void flush();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void queueSecureInputBuffer(int i, int i2, com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, long j, int i3);

    void shutdown();

    void start();
}
