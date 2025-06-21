package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class LeastRecentlyUsedCacheEvictor implements com.google.android.exoplayer2.upstream.cache.CacheEvictor {
    public final long a;
    public final java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> b = new java.util.TreeSet<>(new defpackage.vv0());
    public long c;

    public LeastRecentlyUsedCacheEvictor(long j) {
        this.a = j;
    }

    public static int b(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2) {
        long j = cacheSpan.lastTouchTimestamp;
        long j2 = cacheSpan2.lastTouchTimestamp;
        return j - j2 == 0 ? cacheSpan.compareTo(cacheSpan2) : j < j2 ? -1 : 1;
    }

    public final void c(com.google.android.exoplayer2.upstream.cache.Cache cache, long j) {
        while (this.c + j > this.a && !this.b.isEmpty()) {
            cache.removeSpan(this.b.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        this.b.add(cacheSpan);
        this.c += cacheSpan.length;
        c(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        this.b.remove(cacheSpan);
        this.c -= cacheSpan.length;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, long j, long j2) {
        if (j2 != -1) {
            c(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return true;
    }
}
