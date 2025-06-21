package com.google.android.exoplayer2.decoder;

/* loaded from: classes22.dex */
public interface Decoder<I, O, E extends com.google.android.exoplayer2.decoder.DecoderException> {
    @androidx.annotation.Nullable
    I dequeueInputBuffer() throws com.google.android.exoplayer2.decoder.DecoderException;

    @androidx.annotation.Nullable
    O dequeueOutputBuffer() throws com.google.android.exoplayer2.decoder.DecoderException;

    void flush();

    java.lang.String getName();

    void queueInputBuffer(I i) throws com.google.android.exoplayer2.decoder.DecoderException;

    void release();
}
