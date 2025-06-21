package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public final class SingleSampleMediaChunk extends com.google.android.exoplayer2.source.chunk.BaseMediaChunk {
    public final int c;
    public final com.google.android.exoplayer2.Format d;
    public long e;
    public boolean f;

    public SingleSampleMediaChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2, long j3, int i2, com.google.android.exoplayer2.Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.c = i2;
        this.d = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws java.io.IOException {
        com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput output = getOutput();
        output.setSampleOffsetUs(0L);
        com.google.android.exoplayer2.extractor.TrackOutput track = output.track(0, this.c);
        track.format(this.d);
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.e));
            if (open != -1) {
                open += this.e;
            }
            com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(this.dataSource, this.e, open);
            for (int i = 0; i != -1; i = track.sampleData((com.google.android.exoplayer2.upstream.DataReader) defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.e += i;
            }
            track.sampleMetadata(this.startTimeUs, 1, (int) this.e, 0, null);
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            this.f = true;
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
