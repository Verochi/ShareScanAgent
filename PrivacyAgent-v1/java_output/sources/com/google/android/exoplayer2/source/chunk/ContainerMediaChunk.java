package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public class ContainerMediaChunk extends com.google.android.exoplayer2.source.chunk.BaseMediaChunk {
    public final int c;
    public final long d;
    public final com.google.android.exoplayer2.source.chunk.ChunkExtractor e;
    public long f;
    public volatile boolean g;
    public boolean h;

    public ContainerMediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3, j4, j5);
        this.c = i2;
        this.d = j6;
        this.e = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.g = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + this.c;
    }

    public com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider getTrackOutputProvider(com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws java.io.IOException {
        if (this.f == 0) {
            com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(this.d);
            com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor = this.e;
            com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j = this.clippedStartTimeUs;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.d;
            long j3 = this.clippedEndTimeUs;
            chunkExtractor.init(trackOutputProvider, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.d);
        }
        try {
            com.google.android.exoplayer2.upstream.DataSpec subrange = this.dataSpec.subrange(this.f);
            com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = this.dataSource;
            com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            do {
                try {
                    if (this.g) {
                        break;
                    }
                } finally {
                    this.f = defaultExtractorInput.getPosition() - this.dataSpec.position;
                }
            } while (this.e.read(defaultExtractorInput));
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            this.h = !this.g;
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
