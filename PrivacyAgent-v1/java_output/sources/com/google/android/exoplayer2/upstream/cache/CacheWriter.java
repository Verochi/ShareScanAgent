package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    public final com.google.android.exoplayer2.upstream.cache.CacheDataSource a;
    public final com.google.android.exoplayer2.upstream.cache.Cache b;
    public final com.google.android.exoplayer2.upstream.DataSpec c;
    public final boolean d;
    public final java.lang.String e;
    public final byte[] f;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener g;
    public boolean h;
    public long i;
    public long j;
    public long k;
    public volatile boolean l;

    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(com.google.android.exoplayer2.upstream.cache.CacheDataSource cacheDataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z, @androidx.annotation.Nullable byte[] bArr, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener progressListener) {
        this.a = cacheDataSource;
        this.b = cacheDataSource.getCache();
        this.c = dataSpec;
        this.d = z;
        this.f = bArr == null ? new byte[131072] : bArr;
        this.g = progressListener;
        this.e = cacheDataSource.getCacheKeyFactory().buildCacheKey(dataSpec);
        this.i = dataSpec.position;
    }

    public final long a() {
        long j = this.j;
        if (j == -1) {
            return -1L;
        }
        return j - this.c.position;
    }

    public final void b(long j) {
        this.k += j;
        com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener progressListener = this.g;
        if (progressListener != null) {
            progressListener.onProgress(a(), this.k, j);
        }
    }

    public final void c(long j) {
        if (this.j == j) {
            return;
        }
        this.j = j;
        com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener progressListener = this.g;
        if (progressListener != null) {
            progressListener.onProgress(a(), this.k, 0L);
        }
    }

    @androidx.annotation.WorkerThread
    public void cache() throws java.io.IOException {
        e();
        if (!this.h) {
            com.google.android.exoplayer2.upstream.DataSpec dataSpec = this.c;
            long j = dataSpec.length;
            if (j != -1) {
                this.j = dataSpec.position + j;
            } else {
                long a = defpackage.js.a(this.b.getContentMetadata(this.e));
                if (a == -1) {
                    a = -1;
                }
                this.j = a;
            }
            com.google.android.exoplayer2.upstream.cache.Cache cache = this.b;
            java.lang.String str = this.e;
            com.google.android.exoplayer2.upstream.DataSpec dataSpec2 = this.c;
            this.k = cache.getCachedBytes(str, dataSpec2.position, dataSpec2.length);
            com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener progressListener = this.g;
            if (progressListener != null) {
                progressListener.onProgress(a(), this.k, 0L);
            }
            this.h = true;
        }
        while (true) {
            long j2 = this.j;
            if (j2 != -1 && this.i >= j2) {
                return;
            }
            e();
            long j3 = this.j;
            long cachedLength = this.b.getCachedLength(this.e, this.i, j3 == -1 ? Long.MAX_VALUE : j3 - this.i);
            if (cachedLength > 0) {
                this.i += cachedLength;
            } else {
                long j4 = -cachedLength;
                if (j4 == Long.MAX_VALUE) {
                    j4 = -1;
                }
                long j5 = this.i;
                this.i = j5 + d(j5, j4);
            }
        }
    }

    public void cancel() {
        this.l = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:33:0x0018, B:11:0x004b, B:15:0x006c, B:19:0x0075, B:22:0x0083, B:28:0x008b, B:36:0x0034, B:39:0x003a, B:41:0x0040, B:42:0x0046), top: B:7:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:33:0x0018, B:11:0x004b, B:15:0x006c, B:19:0x0075, B:22:0x0083, B:28:0x008b, B:36:0x0034, B:39:0x003a, B:41:0x0040, B:42:0x0046), top: B:7:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:33:0x0018, B:11:0x004b, B:15:0x006c, B:19:0x0075, B:22:0x0083, B:28:0x008b, B:36:0x0034, B:39:0x003a, B:41:0x0040, B:42:0x0046), top: B:7:0x0016, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long d(long j, long j2) throws java.io.IOException {
        long open;
        int i;
        boolean z = true;
        boolean z2 = j + j2 == this.j || j2 == -1;
        try {
            if (j2 != -1) {
                try {
                    open = this.a.open(this.c.buildUpon().setPosition(j).setLength(j2).build());
                } catch (java.io.IOException e) {
                    if (!this.d || !z2 || !com.google.android.exoplayer2.upstream.DataSourceException.isCausedByPositionOutOfRange(e)) {
                        throw e;
                    }
                    com.google.android.exoplayer2.util.Util.closeQuietly(this.a);
                }
                if (!z) {
                    e();
                    open = this.a.open(this.c.buildUpon().setPosition(j).setLength(-1L).build());
                }
                if (z2 && open != -1) {
                    c(open + j);
                }
                i = 0;
                int i2 = 0;
                while (i != -1) {
                    e();
                    com.google.android.exoplayer2.upstream.cache.CacheDataSource cacheDataSource = this.a;
                    byte[] bArr = this.f;
                    i = cacheDataSource.read(bArr, 0, bArr.length);
                    if (i != -1) {
                        b(i);
                        i2 += i;
                    }
                }
                if (z2) {
                    c(j + i2);
                }
                return i2;
            }
            open = -1;
            z = false;
            if (!z) {
            }
            if (z2) {
                c(open + j);
            }
            i = 0;
            int i22 = 0;
            while (i != -1) {
            }
            if (z2) {
            }
            return i22;
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.a);
        }
    }

    public final void e() throws java.io.InterruptedIOException {
        if (this.l) {
            throw new java.io.InterruptedIOException();
        }
    }
}
