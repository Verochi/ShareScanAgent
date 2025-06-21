package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class ProgressiveDownloader implements com.google.android.exoplayer2.offline.Downloader {
    public final java.util.concurrent.Executor a;
    public final com.google.android.exoplayer2.upstream.DataSpec b;
    public final com.google.android.exoplayer2.upstream.cache.CacheDataSource c;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.util.PriorityTaskManager d;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.offline.Downloader.ProgressListener e;
    public volatile com.google.android.exoplayer2.util.RunnableFutureTask<java.lang.Void, java.io.IOException> f;
    public volatile boolean g;

    /* renamed from: com.google.android.exoplayer2.offline.ProgressiveDownloader$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.exoplayer2.util.RunnableFutureTask<java.lang.Void, java.io.IOException> {
        public final /* synthetic */ com.google.android.exoplayer2.upstream.cache.CacheWriter z;

        public AnonymousClass1(com.google.android.exoplayer2.offline.ProgressiveDownloader progressiveDownloader, com.google.android.exoplayer2.upstream.cache.CacheWriter cacheWriter) {
            this.z = cacheWriter;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.lang.Void doWork() throws java.io.IOException {
            this.z.cache();
            return null;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public void cancelWork() {
            this.z.cancel();
        }
    }

    @java.lang.Deprecated
    public ProgressiveDownloader(android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(uri, str, factory, new defpackage.jz());
    }

    @java.lang.Deprecated
    public ProgressiveDownloader(android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build(), factory, executor);
    }

    public ProgressiveDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(mediaItem, factory, new defpackage.jz());
    }

    public ProgressiveDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this.a = (java.util.concurrent.Executor) com.google.android.exoplayer2.util.Assertions.checkNotNull(executor);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.b = new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(mediaItem.playbackProperties.uri).setKey(mediaItem.playbackProperties.customCacheKey).setFlags(4).build();
        this.c = factory.createDataSourceForDownloading();
        this.d = factory.getUpstreamPriorityTaskManager();
    }

    public final void b(long j, long j2, long j3) {
        com.google.android.exoplayer2.offline.Downloader.ProgressListener progressListener = this.e;
        if (progressListener == null) {
            return;
        }
        progressListener.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (j2 * 100.0f) / j);
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.g = true;
        com.google.android.exoplayer2.util.RunnableFutureTask<java.lang.Void, java.io.IOException> runnableFutureTask = this.f;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void download(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.Downloader.ProgressListener progressListener) throws java.io.IOException, java.lang.InterruptedException {
        this.e = progressListener;
        if (this.f == null) {
            this.f = new com.google.android.exoplayer2.offline.ProgressiveDownloader.AnonymousClass1(this, new com.google.android.exoplayer2.upstream.cache.CacheWriter(this.c, this.b, false, null, new defpackage.b62(this)));
        }
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = this.d;
        if (priorityTaskManager != null) {
            priorityTaskManager.add(-1000);
        }
        boolean z = false;
        while (!z) {
            try {
                if (this.g) {
                    break;
                }
                com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager2 = this.d;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.proceed(-1000);
                }
                this.a.execute(this.f);
                try {
                    this.f.get();
                    z = true;
                } catch (java.util.concurrent.ExecutionException e) {
                    java.lang.Throwable th = (java.lang.Throwable) com.google.android.exoplayer2.util.Assertions.checkNotNull(e.getCause());
                    if (!(th instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException)) {
                        if (th instanceof java.io.IOException) {
                            throw ((java.io.IOException) th);
                        }
                        com.google.android.exoplayer2.util.Util.sneakyThrow(th);
                    }
                }
            } finally {
                this.f.blockUntilFinished();
                com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager3 = this.d;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.remove(-1000);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        this.c.getCache().removeResource(this.c.getCacheKeyFactory().buildCacheKey(this.b));
    }
}
