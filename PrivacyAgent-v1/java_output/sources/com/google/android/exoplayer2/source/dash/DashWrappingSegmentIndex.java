package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public final class DashWrappingSegmentIndex implements com.google.android.exoplayer2.source.dash.DashSegmentIndex {
    public final com.google.android.exoplayer2.extractor.ChunkIndex a;
    public final long b;

    public DashWrappingSegmentIndex(com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex, long j) {
        this.a = chunkIndex;
        this.b = j;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(long j, long j2) {
        return this.a.durationsUs[(int) j];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstSegmentNum() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getSegmentCount(long j) {
        return this.a.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentNum(long j, long j2) {
        return this.a.getChunkIndex(j + this.b);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j) {
        return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, this.a.offsets[(int) j], r0.sizes[r9]);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j) {
        return this.a.timesUs[(int) j] - this.b;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }
}
