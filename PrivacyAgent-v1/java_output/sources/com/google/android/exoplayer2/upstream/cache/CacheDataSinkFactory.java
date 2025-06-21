package com.google.android.exoplayer2.upstream.cache;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class CacheDataSinkFactory implements com.google.android.exoplayer2.upstream.DataSink.Factory {
    public final com.google.android.exoplayer2.upstream.cache.Cache a;
    public final long b;
    public final int c;

    public CacheDataSinkFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, long j) {
        this(cache, j, 20480);
    }

    public CacheDataSinkFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, long j, int i) {
        this.a = cache;
        this.b = j;
        this.c = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink.Factory
    public com.google.android.exoplayer2.upstream.DataSink createDataSink() {
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSink(this.a, this.b, this.c);
    }
}
