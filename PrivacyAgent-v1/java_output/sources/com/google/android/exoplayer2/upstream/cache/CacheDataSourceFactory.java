package com.google.android.exoplayer2.upstream.cache;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class CacheDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    public final com.google.android.exoplayer2.upstream.cache.Cache a;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory b;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory c;
    public final int d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.DataSink.Factory e;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener f;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.cache.CacheKeyFactory g;

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(cache, factory, 0);
    }

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, int i) {
        this(cache, factory, new com.google.android.exoplayer2.upstream.FileDataSource.Factory(), new com.google.android.exoplayer2.upstream.cache.CacheDataSink.Factory().setCache(cache), i, null);
    }

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.DataSource.Factory factory2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSink.Factory factory3, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener) {
        this(cache, factory, factory2, factory3, i, eventListener, null);
    }

    public CacheDataSourceFactory(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.DataSource.Factory factory2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSink.Factory factory3, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory) {
        this.a = cache;
        this.b = factory;
        this.c = factory2;
        this.e = factory3;
        this.d = i;
        this.f = eventListener;
        this.g = cacheKeyFactory;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSource() {
        com.google.android.exoplayer2.upstream.cache.Cache cache = this.a;
        com.google.android.exoplayer2.upstream.DataSource createDataSource = this.b.createDataSource();
        com.google.android.exoplayer2.upstream.DataSource createDataSource2 = this.c.createDataSource();
        com.google.android.exoplayer2.upstream.DataSink.Factory factory = this.e;
        return new com.google.android.exoplayer2.upstream.cache.CacheDataSource(cache, createDataSource, createDataSource2, factory == null ? null : factory.createDataSink(), this.d, this.f, this.g);
    }
}
