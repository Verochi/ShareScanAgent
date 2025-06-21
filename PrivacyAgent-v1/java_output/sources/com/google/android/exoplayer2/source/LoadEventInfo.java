package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class LoadEventInfo {
    public static final java.util.concurrent.atomic.AtomicLong a = new java.util.concurrent.atomic.AtomicLong();
    public final long bytesLoaded;
    public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    public final long elapsedRealtimeMs;
    public final long loadDurationMs;
    public final long loadTaskId;
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders;
    public final android.net.Uri uri;

    public LoadEventInfo(long j, com.google.android.exoplayer2.upstream.DataSpec dataSpec, long j2) {
        this(j, dataSpec, dataSpec.uri, java.util.Collections.emptyMap(), j2, 0L, 0L);
    }

    public LoadEventInfo(long j, com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, long j2, long j3, long j4) {
        this.loadTaskId = j;
        this.dataSpec = dataSpec;
        this.uri = uri;
        this.responseHeaders = map;
        this.elapsedRealtimeMs = j2;
        this.loadDurationMs = j3;
        this.bytesLoaded = j4;
    }

    public static long getNewId() {
        return a.getAndIncrement();
    }
}
