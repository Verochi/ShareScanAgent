package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public interface HlsExtractorFactory {
    public static final com.google.android.exoplayer2.source.hls.HlsExtractorFactory DEFAULT = new com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory();

    com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor createExtractor(android.net.Uri uri, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException;
}
