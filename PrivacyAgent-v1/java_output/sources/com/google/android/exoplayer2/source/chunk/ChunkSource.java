package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters);

    void getNextChunk(long j, long j2, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list);

    void maybeThrowError() throws java.io.IOException;

    void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk);

    boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, boolean z, java.lang.Exception exc, long j);

    void release();

    boolean shouldCancelLoad(long j, com.google.android.exoplayer2.source.chunk.Chunk chunk, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list);
}
