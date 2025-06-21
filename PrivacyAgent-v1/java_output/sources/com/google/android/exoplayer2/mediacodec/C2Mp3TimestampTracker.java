package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
final class C2Mp3TimestampTracker {
    public long a;
    public long b;
    public boolean c;

    public final long a(com.google.android.exoplayer2.Format format) {
        return (this.a * 1000000) / format.sampleRate;
    }

    public void b() {
        this.a = 0L;
        this.b = 0L;
        this.c = false;
    }

    public long c(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        if (this.c) {
            return decoderInputBuffer.timeUs;
        }
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(decoderInputBuffer.data);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int parseMpegAudioFrameSampleCount = com.google.android.exoplayer2.audio.MpegAudioUtil.parseMpegAudioFrameSampleCount(i);
        if (parseMpegAudioFrameSampleCount == -1) {
            this.c = true;
            com.google.android.exoplayer2.util.Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return decoderInputBuffer.timeUs;
        }
        if (this.a != 0) {
            long a = a(format);
            this.a += parseMpegAudioFrameSampleCount;
            return this.b + a;
        }
        long j = decoderInputBuffer.timeUs;
        this.b = j;
        this.a = parseMpegAudioFrameSampleCount - 529;
        return j;
    }
}
