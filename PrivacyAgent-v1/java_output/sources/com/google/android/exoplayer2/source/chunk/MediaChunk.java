package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public abstract class MediaChunk extends com.google.android.exoplayer2.source.chunk.Chunk {
    public final long chunkIndex;

    public MediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2, long j3) {
        super(dataSource, dataSpec, 1, format, i, obj, j, j2);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(format);
        this.chunkIndex = j3;
    }

    public long getNextChunkIndex() {
        long j = this.chunkIndex;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }

    public abstract boolean isLoadCompleted();
}
