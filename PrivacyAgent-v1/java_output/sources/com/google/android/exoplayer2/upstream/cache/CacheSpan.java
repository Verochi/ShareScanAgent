package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public class CacheSpan implements java.lang.Comparable<com.google.android.exoplayer2.upstream.cache.CacheSpan> {

    @androidx.annotation.Nullable
    public final java.io.File file;
    public final boolean isCached;
    public final java.lang.String key;
    public final long lastTouchTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(java.lang.String str, long j, long j2) {
        this(str, j, j2, -9223372036854775807L, null);
    }

    public CacheSpan(java.lang.String str, long j, long j2, long j3, @androidx.annotation.Nullable java.io.File file) {
        this.key = str;
        this.position = j;
        this.length = j2;
        this.isCached = file != null;
        this.file = file;
        this.lastTouchTimestamp = j3;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        long j = this.position - cacheSpan.position;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    public boolean isOpenEnded() {
        return this.length == -1;
    }

    public java.lang.String toString() {
        long j = this.position;
        long j2 = this.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(44);
        sb.append("[");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }
}
