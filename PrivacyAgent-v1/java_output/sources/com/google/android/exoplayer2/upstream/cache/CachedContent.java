package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
final class CachedContent {
    public final int a;
    public final java.lang.String b;
    public final java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan> c;
    public final java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.CachedContent.Range> d;
    public com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata e;

    public static final class Range {
        public final long a;
        public final long b;

        public Range(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean a(long j, long j2) {
            long j3 = this.b;
            if (j3 == -1) {
                return j >= this.a;
            }
            if (j2 == -1) {
                return false;
            }
            long j4 = this.a;
            return j4 <= j && j + j2 <= j4 + j3;
        }

        public boolean b(long j, long j2) {
            long j3 = this.a;
            if (j3 > j) {
                return j2 == -1 || j + j2 > j3;
            }
            long j4 = this.b;
            return j4 == -1 || j3 + j4 > j;
        }
    }

    public CachedContent(int i, java.lang.String str) {
        this(i, str, com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.EMPTY);
    }

    public CachedContent(int i, java.lang.String str, com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata defaultContentMetadata) {
        this.a = i;
        this.b = str;
        this.e = defaultContentMetadata;
        this.c = new java.util.TreeSet<>();
        this.d = new java.util.ArrayList<>();
    }

    public void a(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        this.c.add(simpleCacheSpan);
    }

    public boolean b(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        this.e = this.e.copyWithMutationsApplied(contentMetadataMutations);
        return !r2.equals(r0);
    }

    public long c(long j, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j2 >= 0);
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e = e(j, j2);
        if (e.isHoleSpan()) {
            return -java.lang.Math.min(e.isOpenEnded() ? Long.MAX_VALUE : e.length, j2);
        }
        long j3 = j + j2;
        long j4 = j3 >= 0 ? j3 : Long.MAX_VALUE;
        long j5 = e.position + e.length;
        if (j5 < j4) {
            for (com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan : this.c.tailSet(e, false)) {
                long j6 = simpleCacheSpan.position;
                if (j6 > j5) {
                    break;
                }
                j5 = java.lang.Math.max(j5, j6 + simpleCacheSpan.length);
                if (j5 >= j4) {
                    break;
                }
            }
        }
        return java.lang.Math.min(j5 - j, j2);
    }

    public com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata d() {
        return this.e;
    }

    public com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e(long j, long j2) {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan e = com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.e(this.b, j);
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan floor = this.c.floor(e);
        if (floor != null && floor.position + floor.length > j) {
            return floor;
        }
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan ceiling = this.c.ceiling(e);
        if (ceiling != null) {
            long j3 = ceiling.position - j;
            j2 = j2 == -1 ? j3 : java.lang.Math.min(j3, j2);
        }
        return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.d(this.b, j, j2);
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.upstream.cache.CachedContent.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = (com.google.android.exoplayer2.upstream.cache.CachedContent) obj;
        return this.a == cachedContent.a && this.b.equals(cachedContent.b) && this.c.equals(cachedContent.c) && this.e.equals(cachedContent.e);
    }

    public java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan> f() {
        return this.c;
    }

    public boolean g() {
        return this.c.isEmpty();
    }

    public boolean h(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).a(j, j2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.e.hashCode();
    }

    public boolean i() {
        return this.d.isEmpty();
    }

    public boolean j(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).b(j, j2)) {
                return false;
            }
        }
        this.d.add(new com.google.android.exoplayer2.upstream.cache.CachedContent.Range(j, j2));
        return true;
    }

    public boolean k(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        if (!this.c.remove(cacheSpan)) {
            return false;
        }
        java.io.File file = cacheSpan.file;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan l(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan, long j, boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.c.remove(simpleCacheSpan));
        java.io.File file = (java.io.File) com.google.android.exoplayer2.util.Assertions.checkNotNull(simpleCacheSpan.file);
        if (z) {
            java.io.File f = com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.f((java.io.File) com.google.android.exoplayer2.util.Assertions.checkNotNull(file.getParentFile()), this.a, simpleCacheSpan.position, j);
            if (file.renameTo(f)) {
                file = f;
            } else {
                java.lang.String valueOf = java.lang.String.valueOf(file);
                java.lang.String valueOf2 = java.lang.String.valueOf(f);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 21 + valueOf2.length());
                sb.append("Failed to rename ");
                sb.append(valueOf);
                sb.append(" to ");
                sb.append(valueOf2);
                com.google.android.exoplayer2.util.Log.w("CachedContent", sb.toString());
            }
        }
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan a = simpleCacheSpan.a(file, j);
        this.c.add(a);
        return a;
    }

    public void m(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).a == j) {
                this.d.remove(i);
                return;
            }
        }
        throw new java.lang.IllegalStateException();
    }
}
