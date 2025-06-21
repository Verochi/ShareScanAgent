package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public interface SampleStream {

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ReadDataResult {
    }

    boolean isReady();

    void maybeThrowError() throws java.io.IOException;

    int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z);

    int skipData(long j);
}
