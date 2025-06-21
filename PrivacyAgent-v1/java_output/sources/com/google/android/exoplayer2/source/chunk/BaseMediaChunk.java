package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public abstract class BaseMediaChunk extends com.google.android.exoplayer2.source.chunk.MediaChunk {
    public com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput a;
    public int[] b;
    public final long clippedEndTimeUs;
    public final long clippedStartTimeUs;

    public BaseMediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2, long j3, long j4, long j5) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j5);
        this.clippedStartTimeUs = j3;
        this.clippedEndTimeUs = j4;
    }

    public final int getFirstSampleIndex(int i) {
        return ((int[]) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b))[i];
    }

    public final com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput getOutput() {
        return (com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.a);
    }

    public void init(com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput baseMediaChunkOutput) {
        this.a = baseMediaChunkOutput;
        this.b = baseMediaChunkOutput.getWriteIndices();
    }
}
