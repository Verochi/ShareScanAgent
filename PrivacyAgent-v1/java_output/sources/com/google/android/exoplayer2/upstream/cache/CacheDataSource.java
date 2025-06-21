package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class CacheDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    public final com.google.android.exoplayer2.upstream.cache.Cache a;
    public final com.google.android.exoplayer2.upstream.DataSource b;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.DataSource c;
    public final com.google.android.exoplayer2.upstream.DataSource d;
    public final com.google.android.exoplayer2.upstream.cache.CacheKeyFactory e;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    @androidx.annotation.Nullable
    public android.net.Uri j;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSpec k;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource l;
    public boolean m;
    public long n;
    public long o;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.cache.CacheSpan p;
    public boolean q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public long f369s;
    public long t;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i);

        void onCachedBytesRead(long j, long j2);
    }

    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
        public com.google.android.exoplayer2.upstream.cache.Cache a;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.DataSink.Factory c;
        public boolean e;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.DataSource.Factory f;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.util.PriorityTaskManager g;
        public int h;
        public int i;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener j;
        public com.google.android.exoplayer2.upstream.DataSource.Factory b = new com.google.android.exoplayer2.upstream.FileDataSource.Factory();
        public com.google.android.exoplayer2.upstream.cache.CacheKeyFactory d = com.google.android.exoplayer2.upstream.cache.CacheKeyFactory.DEFAULT;

        public final com.google.android.exoplayer2.upstream.cache.CacheDataSource a(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource, int i, int i2) {
            com.google.android.exoplayer2.upstream.DataSink dataSink;
            com.google.android.exoplayer2.upstream.cache.Cache cache = (com.google.android.exoplayer2.upstream.cache.Cache) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.a);
            if (this.e || dataSource == null) {
                dataSink = null;
            } else {
                com.google.android.exoplayer2.upstream.DataSink.Factory factory = this.c;
                dataSink = factory != null ? factory.createDataSink() : new com.google.android.exoplayer2.upstream.cache.CacheDataSink.Factory().setCache(cache).createDataSink();
            }
            return new com.google.android.exoplayer2.upstream.cache.CacheDataSource(cache, dataSource, this.b.createDataSource(), dataSink, this.d, i, this.g, i2, this.j, null);
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSource() {
            com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.f;
            return a(factory != null ? factory.createDataSource() : null, this.i, this.h);
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSourceForDownloading() {
            com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.f;
            return a(factory != null ? factory.createDataSource() : null, this.i | 1, -1000);
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSourceForRemovingDownload() {
            return a(null, this.i | 1, -1000);
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.cache.Cache getCache() {
            return this.a;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheKeyFactory getCacheKeyFactory() {
            return this.d;
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.util.PriorityTaskManager getUpstreamPriorityTaskManager() {
            return this.g;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setCache(com.google.android.exoplayer2.upstream.cache.Cache cache) {
            this.a = cache;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setCacheKeyFactory(com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory) {
            this.d = cacheKeyFactory;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setCacheReadDataSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.b = factory;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setCacheWriteDataSinkFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSink.Factory factory) {
            this.c = factory;
            this.e = factory == null;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setEventListener(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener) {
            this.j = eventListener;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setFlags(int i) {
            this.i = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setUpstreamDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.f = factory;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setUpstreamPriority(int i) {
            this.h = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory setUpstreamPriorityTaskManager(@androidx.annotation.Nullable com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager) {
            this.g = priorityTaskManager;
            return this;
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource, int i) {
        this(cache, dataSource, new com.google.android.exoplayer2.upstream.FileDataSource(), new com.google.android.exoplayer2.upstream.cache.CacheDataSink(cache, com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE), i, null);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSource dataSource2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSink dataSink, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i, eventListener, null);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSource dataSource2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSink dataSink, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i, null, 0, eventListener);
    }

    public CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSource dataSource2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSink dataSink, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener) {
        this.a = cache;
        this.b = dataSource2;
        this.e = cacheKeyFactory == null ? com.google.android.exoplayer2.upstream.cache.CacheKeyFactory.DEFAULT : cacheKeyFactory;
        this.g = (i & 1) != 0;
        this.h = (i & 2) != 0;
        this.i = (i & 4) != 0;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new com.google.android.exoplayer2.upstream.PriorityDataSource(dataSource, priorityTaskManager, i2) : dataSource;
            this.d = dataSource;
            this.c = dataSink != null ? new com.google.android.exoplayer2.upstream.TeeDataSource(dataSource, dataSink) : null;
        } else {
            this.d = com.google.android.exoplayer2.upstream.DummyDataSource.INSTANCE;
            this.c = null;
        }
        this.f = eventListener;
    }

    public /* synthetic */ CacheDataSource(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSource dataSource2, com.google.android.exoplayer2.upstream.DataSink dataSink, com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory, int i, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i2, com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener, com.google.android.exoplayer2.upstream.cache.CacheDataSource.AnonymousClass1 anonymousClass1) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i, priorityTaskManager, i2, eventListener);
    }

    public static android.net.Uri b(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, android.net.Uri uri) {
        android.net.Uri b = defpackage.js.b(cache.getContentMetadata(str));
        return b != null ? b : uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.l;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.l = null;
            this.m = false;
            com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan = this.p;
            if (cacheSpan != null) {
                this.a.releaseHoleSpan(cacheSpan);
                this.p = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.b.addTransferListener(transferListener);
        this.d.addTransferListener(transferListener);
    }

    public final void c(java.lang.Throwable th) {
        if (e() || (th instanceof com.google.android.exoplayer2.upstream.cache.Cache.CacheException)) {
            this.q = true;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws java.io.IOException {
        this.k = null;
        this.j = null;
        this.n = 0L;
        h();
        try {
            a();
        } catch (java.lang.Throwable th) {
            c(th);
            throw th;
        }
    }

    public final boolean d() {
        return this.l == this.d;
    }

    public final boolean e() {
        return this.l == this.b;
    }

    public final boolean f() {
        return !e();
    }

    public final boolean g() {
        return this.l == this.c;
    }

    public com.google.android.exoplayer2.upstream.cache.Cache getCache() {
        return this.a;
    }

    public com.google.android.exoplayer2.upstream.cache.CacheKeyFactory getCacheKeyFactory() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return f() ? this.d.getResponseHeaders() : java.util.Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.j;
    }

    public final void h() {
        com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener = this.f;
        if (eventListener == null || this.f369s <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.a.getCacheSpace(), this.f369s);
        this.f369s = 0L;
    }

    public final void i(int i) {
        com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener eventListener = this.f;
        if (eventListener != null) {
            eventListener.onCacheIgnored(i);
        }
    }

    public final void j(com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.cache.CacheSpan startReadWrite;
        long j;
        com.google.android.exoplayer2.upstream.DataSpec build;
        com.google.android.exoplayer2.upstream.DataSource dataSource;
        java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(dataSpec.key);
        if (this.r) {
            startReadWrite = null;
        } else if (this.g) {
            try {
                startReadWrite = this.a.startReadWrite(str, this.n, this.o);
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
                throw new java.io.InterruptedIOException();
            }
        } else {
            startReadWrite = this.a.startReadWriteNonBlocking(str, this.n, this.o);
        }
        if (startReadWrite == null) {
            dataSource = this.d;
            build = dataSpec.buildUpon().setPosition(this.n).setLength(this.o).build();
        } else if (startReadWrite.isCached) {
            android.net.Uri fromFile = android.net.Uri.fromFile((java.io.File) com.google.android.exoplayer2.util.Util.castNonNull(startReadWrite.file));
            long j2 = startReadWrite.position;
            long j3 = this.n - j2;
            long j4 = startReadWrite.length - j3;
            long j5 = this.o;
            if (j5 != -1) {
                j4 = java.lang.Math.min(j4, j5);
            }
            build = dataSpec.buildUpon().setUri(fromFile).setUriPositionOffset(j2).setPosition(j3).setLength(j4).build();
            dataSource = this.b;
        } else {
            if (startReadWrite.isOpenEnded()) {
                j = this.o;
            } else {
                j = startReadWrite.length;
                long j6 = this.o;
                if (j6 != -1) {
                    j = java.lang.Math.min(j, j6);
                }
            }
            build = dataSpec.buildUpon().setPosition(this.n).setLength(j).build();
            dataSource = this.c;
            if (dataSource == null) {
                dataSource = this.d;
                this.a.releaseHoleSpan(startReadWrite);
                startReadWrite = null;
            }
        }
        this.t = (this.r || dataSource != this.d) ? Long.MAX_VALUE : this.n + com.alibaba.sdk.android.oss.common.OSSConstants.MIN_PART_SIZE_LIMIT;
        if (z) {
            com.google.android.exoplayer2.util.Assertions.checkState(d());
            if (dataSource == this.d) {
                return;
            }
            try {
                a();
            } finally {
            }
        }
        if (startReadWrite != null && startReadWrite.isHoleSpan()) {
            this.p = startReadWrite;
        }
        this.l = dataSource;
        this.m = build.length == -1;
        long open = dataSource.open(build);
        com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations = new com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations();
        if (this.m && open != -1) {
            this.o = open;
            com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations.setContentLength(contentMetadataMutations, this.n + open);
        }
        if (f()) {
            android.net.Uri uri = dataSource.getUri();
            this.j = uri;
            com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations.setRedirectedUri(contentMetadataMutations, dataSpec.uri.equals(uri) ^ true ? this.j : null);
        }
        if (g()) {
            this.a.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    public final void k(java.lang.String str) throws java.io.IOException {
        this.o = 0L;
        if (g()) {
            com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations = new com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations();
            com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations.setContentLength(contentMetadataMutations, this.n);
            this.a.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    public final int l(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        if (this.h && this.q) {
            return 0;
        }
        return (this.i && dataSpec.length == -1) ? 1 : -1;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        try {
            java.lang.String buildCacheKey = this.e.buildCacheKey(dataSpec);
            com.google.android.exoplayer2.upstream.DataSpec build = dataSpec.buildUpon().setKey(buildCacheKey).build();
            this.k = build;
            this.j = b(this.a, buildCacheKey, build.uri);
            this.n = dataSpec.position;
            int l = l(dataSpec);
            boolean z = l != -1;
            this.r = z;
            if (z) {
                i(l);
            }
            long j = dataSpec.length;
            if (j == -1 && !this.r) {
                long a = defpackage.js.a(this.a.getContentMetadata(buildCacheKey));
                this.o = a;
                if (a != -1) {
                    long j2 = a - dataSpec.position;
                    this.o = j2;
                    if (j2 <= 0) {
                        throw new com.google.android.exoplayer2.upstream.DataSourceException(0);
                    }
                }
                j(build, false);
                return this.o;
            }
            this.o = j;
            j(build, false);
            return this.o;
        } catch (java.lang.Throwable th) {
            c(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.k);
        if (i2 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        try {
            if (this.n >= this.t) {
                j(dataSpec, true);
            }
            int read = ((com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.l)).read(bArr, i, i2);
            if (read != -1) {
                if (e()) {
                    this.f369s += read;
                }
                long j = read;
                this.n += j;
                long j2 = this.o;
                if (j2 != -1) {
                    this.o = j2 - j;
                }
            } else {
                if (!this.m) {
                    long j3 = this.o;
                    if (j3 <= 0) {
                        if (j3 == -1) {
                        }
                    }
                    a();
                    j(dataSpec, false);
                    return read(bArr, i, i2);
                }
                k((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(dataSpec.key));
            }
            return read;
        } catch (java.io.IOException e) {
            if (this.m && com.google.android.exoplayer2.upstream.DataSourceException.isCausedByPositionOutOfRange(e)) {
                k((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(dataSpec.key));
                return -1;
            }
            c(e);
            throw e;
        } catch (java.lang.Throwable th) {
            c(th);
            throw th;
        }
    }
}
