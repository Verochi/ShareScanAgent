package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
interface ProgressiveMediaExtractor {
    int a(com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException;

    long b();

    void c();

    void d(com.google.android.exoplayer2.upstream.DataReader dataReader, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, long j, long j2, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) throws java.io.IOException;

    void release();

    void seek(long j, long j2);
}
