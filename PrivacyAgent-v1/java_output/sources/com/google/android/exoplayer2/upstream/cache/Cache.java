package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public interface Cache {
    public static final long UID_UNSET = -1;

    public static class CacheException extends java.io.IOException {
        public CacheException(java.lang.String str) {
            super(str);
        }

        public CacheException(java.lang.String str, java.lang.Throwable th) {
            super(str, th);
        }

        public CacheException(java.lang.Throwable th) {
            super(th);
        }
    }

    public interface Listener {
        void onSpanAdded(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

        void onSpanRemoved(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

        void onSpanTouched(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2);
    }

    java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> addListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener);

    @androidx.annotation.WorkerThread
    void applyContentMetadataMutations(java.lang.String str, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    @androidx.annotation.WorkerThread
    void commitFile(java.io.File file, long j) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    long getCacheSpace();

    long getCachedBytes(java.lang.String str, long j, long j2);

    long getCachedLength(java.lang.String str, long j, long j2);

    java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> getCachedSpans(java.lang.String str);

    com.google.android.exoplayer2.upstream.cache.ContentMetadata getContentMetadata(java.lang.String str);

    java.util.Set<java.lang.String> getKeys();

    long getUid();

    boolean isCached(java.lang.String str, long j, long j2);

    @androidx.annotation.WorkerThread
    void release();

    void releaseHoleSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

    void removeListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener);

    @androidx.annotation.WorkerThread
    void removeResource(java.lang.String str);

    @androidx.annotation.WorkerThread
    void removeSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan);

    @androidx.annotation.WorkerThread
    java.io.File startFile(java.lang.String str, long j, long j2) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    @androidx.annotation.WorkerThread
    com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWrite(java.lang.String str, long j, long j2) throws java.lang.InterruptedException, com.google.android.exoplayer2.upstream.cache.Cache.CacheException;

    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWriteNonBlocking(java.lang.String str, long j, long j2) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
}
