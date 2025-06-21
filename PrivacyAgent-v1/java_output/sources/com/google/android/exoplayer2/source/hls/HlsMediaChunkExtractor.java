package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public interface HlsMediaChunkExtractor {
    void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput);

    boolean isPackedAudioExtractor();

    boolean isReusable();

    boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException;

    com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor recreate();
}
