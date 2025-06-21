package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public interface CacheKeyFactory {
    public static final com.google.android.exoplayer2.upstream.cache.CacheKeyFactory DEFAULT = new defpackage.uj();

    java.lang.String buildCacheKey(com.google.android.exoplayer2.upstream.DataSpec dataSpec);
}
