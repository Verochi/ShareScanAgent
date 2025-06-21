package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
final class SimpleCacheSpan extends com.google.android.exoplayer2.upstream.cache.CacheSpan {
    public static final java.util.regex.Pattern n = java.util.regex.Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final java.util.regex.Pattern t = java.util.regex.Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final java.util.regex.Pattern u = java.util.regex.Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public SimpleCacheSpan(java.lang.String str, long j, long j2, long j3, @androidx.annotation.Nullable java.io.File file) {
        super(str, j, j2, j3, file);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan b(java.io.File file, long j, long j2, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex) {
        java.io.File file2;
        java.lang.String k;
        java.lang.String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            java.io.File g = g(file, cachedContentIndex);
            if (g == null) {
                return null;
            }
            file2 = g;
            name = g.getName();
        }
        java.util.regex.Matcher matcher = u.matcher(name);
        if (!matcher.matches() || (k = cachedContentIndex.k(java.lang.Integer.parseInt((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1))))) == null) {
            return null;
        }
        long length = j == -1 ? file2.length() : j;
        if (length == 0) {
            return null;
        }
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(k, java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2))), length, j2 == -9223372036854775807L ? java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(3))) : j2, file2);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan c(java.io.File file, long j, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex) {
        return b(file, j, -9223372036854775807L, cachedContentIndex);
    }

    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan d(java.lang.String str, long j, long j2) {
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(str, j, j2, -9223372036854775807L, null);
    }

    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e(java.lang.String str, long j) {
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(str, j, -1L, -9223372036854775807L, null);
    }

    public static java.io.File f(java.io.File file, int i, long j, long j2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(60);
        sb.append(i);
        sb.append(".");
        sb.append(j);
        sb.append(".");
        sb.append(j2);
        sb.append(".v3.exo");
        return new java.io.File(file, sb.toString());
    }

    @androidx.annotation.Nullable
    public static java.io.File g(java.io.File file, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex) {
        java.lang.String str;
        java.lang.String name = file.getName();
        java.util.regex.Matcher matcher = t.matcher(name);
        if (matcher.matches()) {
            str = com.google.android.exoplayer2.util.Util.unescapeFileName((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)));
        } else {
            matcher = n.matcher(name);
            str = matcher.matches() ? (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        java.io.File f = f((java.io.File) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(file.getParentFile()), cachedContentIndex.f(str), java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(2))), java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(3))));
        if (file.renameTo(f)) {
            return f;
        }
        return null;
    }

    public com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan a(java.io.File file, long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.isCached);
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(this.key, this.position, this.length, j, file);
    }
}
