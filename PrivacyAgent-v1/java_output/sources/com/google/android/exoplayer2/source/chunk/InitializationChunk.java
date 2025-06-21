package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public final class InitializationChunk extends com.google.android.exoplayer2.source.chunk.Chunk {
    public final com.google.android.exoplayer2.source.chunk.ChunkExtractor a;
    public com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider b;
    public long c;
    public volatile boolean d;

    public InitializationChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable java.lang.Object obj, com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.a = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.d = true;
    }

    public void init(com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.b = trackOutputProvider;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws java.io.IOException {
        if (this.c == 0) {
            this.a.init(this.b, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            com.google.android.exoplayer2.upstream.DataSpec subrange = this.dataSpec.subrange(this.c);
            com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = this.dataSource;
            com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            while (!this.d && this.a.read(defaultExtractorInput)) {
                try {
                } finally {
                    this.c = defaultExtractorInput.getPosition() - this.dataSpec.position;
                }
            }
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
        }
    }
}
