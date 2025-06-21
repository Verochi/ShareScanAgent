package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class CacheStats {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        com.google.common.base.Preconditions.checkArgument(j >= 0);
        com.google.common.base.Preconditions.checkArgument(j2 >= 0);
        com.google.common.base.Preconditions.checkArgument(j3 >= 0);
        com.google.common.base.Preconditions.checkArgument(j4 >= 0);
        com.google.common.base.Preconditions.checkArgument(j5 >= 0);
        com.google.common.base.Preconditions.checkArgument(j6 >= 0);
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }

    public double averageLoadPenalty() {
        long j = this.c + this.d;
        if (j == 0) {
            return 0.0d;
        }
        return this.e / j;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.cache.CacheStats)) {
            return false;
        }
        com.google.common.cache.CacheStats cacheStats = (com.google.common.cache.CacheStats) obj;
        return this.a == cacheStats.a && this.b == cacheStats.b && this.c == cacheStats.c && this.d == cacheStats.d && this.e == cacheStats.e && this.f == cacheStats.f;
    }

    public long evictionCount() {
        return this.f;
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(java.lang.Long.valueOf(this.a), java.lang.Long.valueOf(this.b), java.lang.Long.valueOf(this.c), java.lang.Long.valueOf(this.d), java.lang.Long.valueOf(this.e), java.lang.Long.valueOf(this.f));
    }

    public long hitCount() {
        return this.a;
    }

    public double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        return this.a / requestCount;
    }

    public long loadCount() {
        return this.c + this.d;
    }

    public long loadExceptionCount() {
        return this.d;
    }

    public double loadExceptionRate() {
        long j = this.c;
        long j2 = this.d;
        long j3 = j + j2;
        if (j3 == 0) {
            return 0.0d;
        }
        return j2 / j3;
    }

    public long loadSuccessCount() {
        return this.c;
    }

    public com.google.common.cache.CacheStats minus(com.google.common.cache.CacheStats cacheStats) {
        return new com.google.common.cache.CacheStats(java.lang.Math.max(0L, this.a - cacheStats.a), java.lang.Math.max(0L, this.b - cacheStats.b), java.lang.Math.max(0L, this.c - cacheStats.c), java.lang.Math.max(0L, this.d - cacheStats.d), java.lang.Math.max(0L, this.e - cacheStats.e), java.lang.Math.max(0L, this.f - cacheStats.f));
    }

    public long missCount() {
        return this.b;
    }

    public double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        return this.b / requestCount;
    }

    public com.google.common.cache.CacheStats plus(com.google.common.cache.CacheStats cacheStats) {
        return new com.google.common.cache.CacheStats(this.a + cacheStats.a, this.b + cacheStats.b, this.c + cacheStats.c, this.d + cacheStats.d, this.e + cacheStats.e, this.f + cacheStats.f);
    }

    public long requestCount() {
        return this.a + this.b;
    }

    public java.lang.String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this).add("hitCount", this.a).add("missCount", this.b).add("loadSuccessCount", this.c).add("loadExceptionCount", this.d).add("totalLoadTime", this.e).add("evictionCount", this.f).toString();
    }

    public long totalLoadTime() {
        return this.e;
    }
}
