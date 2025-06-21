package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class CachedRegionTracker implements com.google.android.exoplayer2.upstream.cache.Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    public final com.google.android.exoplayer2.upstream.cache.Cache a;
    public final java.lang.String b;
    public final com.google.android.exoplayer2.extractor.ChunkIndex c;
    public final java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region> d = new java.util.TreeSet<>();
    public final com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region e = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(0, 0);

    public static class Region implements java.lang.Comparable<com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region> {
        public long n;
        public long t;
        public int u;

        public Region(long j, long j2) {
            this.n = j;
            this.t = j2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region) {
            return com.google.android.exoplayer2.util.Util.compareLong(this.n, region.n);
        }
    }

    public CachedRegionTracker(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex) {
        this.a = cache;
        this.b = str;
        this.c = chunkIndex;
        synchronized (this) {
            java.util.Iterator<com.google.android.exoplayer2.upstream.cache.CacheSpan> descendingIterator = cache.addListener(str, this).descendingIterator();
            while (descendingIterator.hasNext()) {
                a(descendingIterator.next());
            }
        }
    }

    public final void a(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        long j = cacheSpan.position;
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(j, cacheSpan.length + j);
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region floor = this.d.floor(region);
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region ceiling = this.d.ceiling(region);
        boolean b = b(floor, region);
        if (b(region, ceiling)) {
            if (b) {
                floor.t = ceiling.t;
                floor.u = ceiling.u;
            } else {
                region.t = ceiling.t;
                region.u = ceiling.u;
                this.d.add(region);
            }
            this.d.remove(ceiling);
            return;
        }
        if (!b) {
            int binarySearch = java.util.Arrays.binarySearch(this.c.offsets, region.t);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region.u = binarySearch;
            this.d.add(region);
            return;
        }
        floor.t = region.t;
        int i = floor.u;
        while (true) {
            com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex = this.c;
            if (i >= chunkIndex.length - 1) {
                break;
            }
            int i2 = i + 1;
            if (chunkIndex.offsets[i2] > floor.t) {
                break;
            } else {
                i = i2;
            }
        }
        floor.u = i;
    }

    public final boolean b(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region2) {
        return (region == null || region2 == null || region.t != region2.n) ? false : true;
    }

    public synchronized int getRegionEndTimeMs(long j) {
        int i;
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region = this.e;
        region.n = j;
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region floor = this.d.floor(region);
        if (floor != null) {
            long j2 = floor.t;
            if (j <= j2 && (i = floor.u) != -1) {
                com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex = this.c;
                if (i == chunkIndex.length - 1) {
                    if (j2 == chunkIndex.offsets[i] + chunkIndex.sizes[i]) {
                        return -2;
                    }
                }
                return (int) ((chunkIndex.timesUs[i] + ((chunkIndex.durationsUs[i] * (j2 - chunkIndex.offsets[i])) / chunkIndex.sizes[i])) / 1000);
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        a(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        long j = cacheSpan.position;
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(j, cacheSpan.length + j);
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region floor = this.d.floor(region);
        if (floor == null) {
            com.google.android.exoplayer2.util.Log.e("CachedRegionTracker", "Removed a span we were not aware of");
            return;
        }
        this.d.remove(floor);
        long j2 = floor.n;
        long j3 = region.n;
        if (j2 < j3) {
            com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region2 = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(j2, j3);
            int binarySearch = java.util.Arrays.binarySearch(this.c.offsets, region2.t);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region2.u = binarySearch;
            this.d.add(region2);
        }
        long j4 = floor.t;
        long j5 = region.t;
        if (j4 > j5) {
            com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region3 = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(j5 + 1, j4);
            region3.u = floor.u;
            this.d.add(region3);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2) {
    }

    public void release() {
        this.a.removeListener(this.b, this);
    }
}
