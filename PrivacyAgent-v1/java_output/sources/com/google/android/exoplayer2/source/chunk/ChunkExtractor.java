package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public interface ChunkExtractor {

    public interface TrackOutputProvider {
        com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2);
    }

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.extractor.ChunkIndex getChunkIndex();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Format[] getSampleFormats();

    void init(@androidx.annotation.Nullable com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2);

    boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException;

    void release();
}
