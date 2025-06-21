package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public abstract class SegmentDownloader<M extends com.google.android.exoplayer2.offline.FilterableManifest<M>> implements com.google.android.exoplayer2.offline.Downloader {
    public final com.google.android.exoplayer2.upstream.DataSpec a;
    public final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<M> b;
    public final java.util.ArrayList<com.google.android.exoplayer2.offline.StreamKey> c;
    public final com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory d;
    public final com.google.android.exoplayer2.upstream.cache.Cache e;
    public final com.google.android.exoplayer2.upstream.cache.CacheKeyFactory f;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.util.PriorityTaskManager g;
    public final java.util.concurrent.Executor h;
    public final java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> i;
    public volatile boolean j;

    /* renamed from: com.google.android.exoplayer2.offline.SegmentDownloader$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.exoplayer2.util.RunnableFutureTask<M, java.io.IOException> {
        public final /* synthetic */ com.google.android.exoplayer2.upstream.DataSpec A;
        public final /* synthetic */ com.google.android.exoplayer2.upstream.DataSource z;

        public AnonymousClass1(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this.z = dataSource;
            this.A = dataSpec;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public M doWork() throws java.io.IOException {
            return (M) com.google.android.exoplayer2.upstream.ParsingLoadable.load(this.z, com.google.android.exoplayer2.offline.SegmentDownloader.this.b, this.A, 4);
        }
    }

    public static final class ProgressNotifier implements com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener {
        public final com.google.android.exoplayer2.offline.Downloader.ProgressListener a;
        public final long b;
        public final int c;
        public long d;
        public int e;

        public ProgressNotifier(com.google.android.exoplayer2.offline.Downloader.ProgressListener progressListener, long j, int i, long j2, int i2) {
            this.a = progressListener;
            this.b = j;
            this.c = i;
            this.d = j2;
            this.e = i2;
        }

        public final float a() {
            long j = this.b;
            if (j != -1 && j != 0) {
                return (this.d * 100.0f) / j;
            }
            int i = this.c;
            if (i != 0) {
                return (this.e * 100.0f) / i;
            }
            return -1.0f;
        }

        public void b() {
            this.e++;
            this.a.onProgress(this.b, this.d, a());
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
        public void onProgress(long j, long j2, long j3) {
            long j4 = this.d + j3;
            this.d = j4;
            this.a.onProgress(this.b, j4, a());
        }
    }

    public static class Segment implements java.lang.Comparable<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> {
        public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.offline.SegmentDownloader.Segment segment) {
            return com.google.android.exoplayer2.util.Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public static final class SegmentDownloadRunnable extends com.google.android.exoplayer2.util.RunnableFutureTask<java.lang.Void, java.io.IOException> {
        public final com.google.android.exoplayer2.upstream.cache.CacheDataSource A;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.offline.SegmentDownloader.ProgressNotifier B;
        public final byte[] C;
        public final com.google.android.exoplayer2.upstream.cache.CacheWriter D;
        public final com.google.android.exoplayer2.offline.SegmentDownloader.Segment z;

        public SegmentDownloadRunnable(com.google.android.exoplayer2.offline.SegmentDownloader.Segment segment, com.google.android.exoplayer2.upstream.cache.CacheDataSource cacheDataSource, @androidx.annotation.Nullable com.google.android.exoplayer2.offline.SegmentDownloader.ProgressNotifier progressNotifier, byte[] bArr) {
            this.z = segment;
            this.A = cacheDataSource;
            this.B = progressNotifier;
            this.C = bArr;
            this.D = new com.google.android.exoplayer2.upstream.cache.CacheWriter(cacheDataSource, segment.dataSpec, false, bArr, progressNotifier);
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.lang.Void doWork() throws java.io.IOException {
            this.D.cache();
            com.google.android.exoplayer2.offline.SegmentDownloader.ProgressNotifier progressNotifier = this.B;
            if (progressNotifier == null) {
                return null;
            }
            progressNotifier.b();
            return null;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            this.D.cancel();
        }
    }

    public SegmentDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<M> parser, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.a = getCompressibleDataSpec(mediaItem.playbackProperties.uri);
        this.b = parser;
        this.c = new java.util.ArrayList<>(mediaItem.playbackProperties.streamKeys);
        this.d = factory;
        this.h = executor;
        this.e = (com.google.android.exoplayer2.upstream.cache.Cache) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory.getCache());
        this.f = factory.getCacheKeyFactory();
        this.g = factory.getUpstreamPriorityTaskManager();
        this.i = new java.util.ArrayList<>();
    }

    public static boolean c(com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSpec dataSpec2) {
        if (dataSpec.uri.equals(dataSpec2.uri)) {
            long j = dataSpec.length;
            if (j != -1 && dataSpec.position + j == dataSpec2.position && com.google.android.exoplayer2.util.Util.areEqual(dataSpec.key, dataSpec2.key) && dataSpec.flags == dataSpec2.flags && dataSpec.httpMethod == dataSpec2.httpMethod && dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders)) {
                return true;
            }
        }
        return false;
    }

    public static void d(java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> list, com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory) {
        java.util.HashMap hashMap = new java.util.HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.offline.SegmentDownloader.Segment segment = list.get(i2);
            java.lang.String buildCacheKey = cacheKeyFactory.buildCacheKey(segment.dataSpec);
            java.lang.Integer num = (java.lang.Integer) hashMap.get(buildCacheKey);
            com.google.android.exoplayer2.offline.SegmentDownloader.Segment segment2 = num == null ? null : list.get(num.intValue());
            if (segment2 == null || segment.startTimeUs > segment2.startTimeUs + 20000000 || !c(segment2.dataSpec, segment.dataSpec)) {
                hashMap.put(buildCacheKey, java.lang.Integer.valueOf(i));
                list.set(i, segment);
                i++;
            } else {
                long j = segment.dataSpec.length;
                list.set(((java.lang.Integer) com.google.android.exoplayer2.util.Assertions.checkNotNull(num)).intValue(), new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(segment2.startTimeUs, segment2.dataSpec.subrange(0L, j != -1 ? segment2.dataSpec.length + j : -1L)));
            }
        }
        com.google.android.exoplayer2.util.Util.removeRange(list, i, list.size());
    }

    public static com.google.android.exoplayer2.upstream.DataSpec getCompressibleDataSpec(android.net.Uri uri) {
        return new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    public final <T> void b(com.google.android.exoplayer2.util.RunnableFutureTask<T, ?> runnableFutureTask) throws java.lang.InterruptedException {
        synchronized (this.i) {
            if (this.j) {
                throw new java.lang.InterruptedException();
            }
            this.i.add(runnableFutureTask);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        synchronized (this.i) {
            this.j = true;
            for (int i = 0; i < this.i.size(); i++) {
                this.i.get(i).cancel(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a6 A[LOOP:1: B:37:0x019e->B:39:0x01a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01bf A[LOOP:2: B:42:0x01bd->B:43:0x01bf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d4  */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.exoplayer2.offline.SegmentDownloader] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.exoplayer2.offline.SegmentDownloader] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    @Override // com.google.android.exoplayer2.offline.Downloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void download(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.Downloader.ProgressListener progressListener) throws java.io.IOException, java.lang.InterruptedException {
        com.google.android.exoplayer2.offline.SegmentDownloader<M> segmentDownloader;
        int i;
        int size;
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
        com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSourceForDownloading;
        byte[] bArr;
        ?? r1 = this;
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        java.util.ArrayDeque arrayDeque2 = new java.util.ArrayDeque();
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager2 = r1.g;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.add(-1000);
        }
        try {
            com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSourceForDownloading2 = r1.d.createDataSourceForDownloading();
            com.google.android.exoplayer2.offline.FilterableManifest manifest = r1.getManifest(createDataSourceForDownloading2, r1.a, false);
            if (!r1.c.isEmpty()) {
                manifest = (com.google.android.exoplayer2.offline.FilterableManifest) manifest.copy(r1.c);
            }
            java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> segments = r1.getSegments(createDataSourceForDownloading2, manifest, false);
            java.util.Collections.sort(segments);
            d(segments, r1.f);
            int size2 = segments.size();
            int size3 = segments.size() - 1;
            long j = 0;
            long j2 = 0;
            int i2 = 0;
            r1 = r1;
            while (size3 >= 0) {
                try {
                    com.google.android.exoplayer2.upstream.DataSpec dataSpec = segments.get(size3).dataSpec;
                    java.lang.String buildCacheKey = r1.f.buildCacheKey(dataSpec);
                    long j3 = dataSpec.length;
                    if (j3 == -1) {
                        long a = defpackage.js.a(r1.e.getContentMetadata(buildCacheKey));
                        if (a != -1) {
                            j3 = a - dataSpec.position;
                        }
                    }
                    java.util.ArrayDeque arrayDeque3 = arrayDeque;
                    long cachedBytes = r1.e.getCachedBytes(buildCacheKey, dataSpec.position, j3);
                    j2 += cachedBytes;
                    if (j3 != -1) {
                        if (j3 == cachedBytes) {
                            i2++;
                            segments.remove(size3);
                        }
                        if (j != -1) {
                            j += j3;
                        }
                    } else {
                        j = -1;
                    }
                    size3--;
                    r1 = this;
                    arrayDeque = arrayDeque3;
                } catch (java.lang.Throwable th) {
                    th = th;
                    segmentDownloader = this;
                    while (i < segmentDownloader.i.size()) {
                    }
                    while (size >= 0) {
                    }
                    priorityTaskManager = segmentDownloader.g;
                    if (priorityTaskManager != null) {
                    }
                    throw th;
                }
            }
            java.util.ArrayDeque arrayDeque4 = arrayDeque;
            com.google.android.exoplayer2.offline.SegmentDownloader.ProgressNotifier progressNotifier = progressListener != null ? new com.google.android.exoplayer2.offline.SegmentDownloader.ProgressNotifier(progressListener, j, size2, j2, i2) : null;
            arrayDeque4.addAll(segments);
            segmentDownloader = this;
            while (!segmentDownloader.j && !arrayDeque4.isEmpty()) {
                try {
                    com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager3 = segmentDownloader.g;
                    if (priorityTaskManager3 != null) {
                        priorityTaskManager3.proceed(-1000);
                    }
                    if (arrayDeque2.isEmpty()) {
                        createDataSourceForDownloading = segmentDownloader.d.createDataSourceForDownloading();
                        bArr = new byte[131072];
                    } else {
                        com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable segmentDownloadRunnable = (com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable) arrayDeque2.removeFirst();
                        createDataSourceForDownloading = segmentDownloadRunnable.A;
                        bArr = segmentDownloadRunnable.C;
                    }
                    com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable segmentDownloadRunnable2 = new com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable((com.google.android.exoplayer2.offline.SegmentDownloader.Segment) arrayDeque4.removeFirst(), createDataSourceForDownloading, progressNotifier, bArr);
                    segmentDownloader.b(segmentDownloadRunnable2);
                    segmentDownloader.h.execute(segmentDownloadRunnable2);
                    for (int size4 = segmentDownloader.i.size() - 1; size4 >= 0; size4--) {
                        com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable segmentDownloadRunnable3 = (com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable) segmentDownloader.i.get(size4);
                        if (arrayDeque4.isEmpty() || segmentDownloadRunnable3.isDone()) {
                            try {
                                segmentDownloadRunnable3.get();
                                segmentDownloader.e(size4);
                                arrayDeque2.addLast(segmentDownloadRunnable3);
                            } catch (java.util.concurrent.ExecutionException e) {
                                java.lang.Throwable th2 = (java.lang.Throwable) com.google.android.exoplayer2.util.Assertions.checkNotNull(e.getCause());
                                if (th2 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException) {
                                    arrayDeque4.addFirst(segmentDownloadRunnable3.z);
                                    segmentDownloader.e(size4);
                                    arrayDeque2.addLast(segmentDownloadRunnable3);
                                } else {
                                    if (th2 instanceof java.io.IOException) {
                                        throw ((java.io.IOException) th2);
                                    }
                                    com.google.android.exoplayer2.util.Util.sneakyThrow(th2);
                                }
                            }
                        }
                    }
                    segmentDownloadRunnable2.blockUntilStarted();
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    for (i = 0; i < segmentDownloader.i.size(); i++) {
                        segmentDownloader.i.get(i).cancel(true);
                    }
                    for (size = segmentDownloader.i.size() - 1; size >= 0; size--) {
                        segmentDownloader.i.get(size).blockUntilFinished();
                        segmentDownloader.e(size);
                    }
                    priorityTaskManager = segmentDownloader.g;
                    if (priorityTaskManager != null) {
                        priorityTaskManager.remove(-1000);
                    }
                    throw th;
                }
            }
            for (int i3 = 0; i3 < segmentDownloader.i.size(); i3++) {
                segmentDownloader.i.get(i3).cancel(true);
            }
            for (int size5 = segmentDownloader.i.size() - 1; size5 >= 0; size5--) {
                segmentDownloader.i.get(size5).blockUntilFinished();
                segmentDownloader.e(size5);
            }
            com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager4 = segmentDownloader.g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.remove(-1000);
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            segmentDownloader = r1;
        }
    }

    public final void e(int i) {
        synchronized (this.i) {
            this.i.remove(i);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:27|28|29|(2:34|(2:36|37)(3:38|39|40))(2:31|32)|33) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        r0 = (java.lang.Throwable) com.google.android.exoplayer2.util.Assertions.checkNotNull(r4.getCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        if ((r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
    
        if ((r0 instanceof java.io.IOException) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        com.google.android.exoplayer2.util.Util.sneakyThrow(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0062, code lost:
    
        throw ((java.io.IOException) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0040, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        r3.blockUntilFinished();
        f(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> T execute(com.google.android.exoplayer2.util.RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws java.lang.InterruptedException, java.io.IOException {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (java.util.concurrent.ExecutionException e) {
                java.lang.Throwable th = (java.lang.Throwable) com.google.android.exoplayer2.util.Assertions.checkNotNull(e.getCause());
                if (th instanceof java.io.IOException) {
                    throw ((java.io.IOException) th);
                }
                com.google.android.exoplayer2.util.Util.sneakyThrow(e);
            }
        }
        while (!this.j) {
            com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = this.g;
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(-1000);
            }
            b(runnableFutureTask);
            this.h.execute(runnableFutureTask);
            return runnableFutureTask.get();
        }
        throw new java.lang.InterruptedException();
    }

    public final void f(com.google.android.exoplayer2.util.RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.i) {
            this.i.remove(runnableFutureTask);
        }
    }

    public final M getManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z) throws java.lang.InterruptedException, java.io.IOException {
        return (M) execute(new com.google.android.exoplayer2.offline.SegmentDownloader.AnonymousClass1(dataSource, dataSpec), z);
    }

    public abstract java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> getSegments(com.google.android.exoplayer2.upstream.DataSource dataSource, M m, boolean z) throws java.io.IOException, java.lang.InterruptedException;

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() {
        com.google.android.exoplayer2.upstream.cache.CacheDataSource createDataSourceForRemovingDownload = this.d.createDataSourceForRemovingDownload();
        try {
            try {
                java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> segments = getSegments(createDataSourceForRemovingDownload, getManifest(createDataSourceForRemovingDownload, this.a, true), true);
                for (int i = 0; i < segments.size(); i++) {
                    this.e.removeResource(this.f.buildCacheKey(segments.get(i).dataSpec));
                }
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            } catch (java.lang.Exception unused2) {
            }
        } finally {
            this.e.removeResource(this.f.buildCacheKey(this.a));
        }
    }
}
