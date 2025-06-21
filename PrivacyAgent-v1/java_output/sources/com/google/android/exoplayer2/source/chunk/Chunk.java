package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public abstract class Chunk implements com.google.android.exoplayer2.upstream.Loader.Loadable {
    protected final com.google.android.exoplayer2.upstream.StatsDataSource dataSource;
    public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    public final long endTimeUs;
    public final long loadTaskId = com.google.android.exoplayer2.source.LoadEventInfo.getNewId();
    public final long startTimeUs;
    public final com.google.android.exoplayer2.Format trackFormat;

    @androidx.annotation.Nullable
    public final java.lang.Object trackSelectionData;
    public final int trackSelectionReason;
    public final int type;

    public Chunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i, com.google.android.exoplayer2.Format format, int i2, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2) {
        this.dataSource = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
        this.dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSpec);
        this.type = i;
        this.trackFormat = format;
        this.trackSelectionReason = i2;
        this.trackSelectionData = obj;
        this.startTimeUs = j;
        this.endTimeUs = j2;
    }

    public final long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    public final long getDurationUs() {
        return this.endTimeUs - this.startTimeUs;
    }

    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    public final android.net.Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }
}
