package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public interface CacheEvictor extends com.google.android.exoplayer2.upstream.cache.Cache.Listener {
    void onCacheInitialized();

    void onStartFile(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, long j, long j2);

    boolean requiresCacheSpanTouches();
}
