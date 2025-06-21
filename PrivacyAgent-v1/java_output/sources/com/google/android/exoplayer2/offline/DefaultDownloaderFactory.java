package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public class DefaultDownloaderFactory implements com.google.android.exoplayer2.offline.DownloaderFactory {
    public static final android.util.SparseArray<java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.offline.Downloader>> c = b();
    public final com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory a;
    public final java.util.concurrent.Executor b;

    @java.lang.Deprecated
    public DefaultDownloaderFactory(com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(factory, new defpackage.jz());
    }

    public DefaultDownloaderFactory(com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this.a = (com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        this.b = (java.util.concurrent.Executor) com.google.android.exoplayer2.util.Assertions.checkNotNull(executor);
    }

    public static android.util.SparseArray<java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.offline.Downloader>> b() {
        android.util.SparseArray<java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.offline.Downloader>> sparseArray = new android.util.SparseArray<>();
        try {
            sparseArray.put(0, c(com.google.android.exoplayer2.source.dash.offline.DashDownloader.class));
        } catch (java.lang.ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, c(com.google.android.exoplayer2.source.hls.offline.HlsDownloader.class));
        } catch (java.lang.ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, c(com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader.class));
        } catch (java.lang.ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    public static java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.offline.Downloader> c(java.lang.Class<?> cls) {
        try {
            return cls.asSubclass(com.google.android.exoplayer2.offline.Downloader.class).getConstructor(com.google.android.exoplayer2.MediaItem.class, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory.class, java.util.concurrent.Executor.class);
        } catch (java.lang.NoSuchMethodException e) {
            throw new java.lang.IllegalStateException("Downloader constructor missing", e);
        }
    }

    public final com.google.android.exoplayer2.offline.Downloader a(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i) {
        java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.offline.Downloader> constructor = c.get(i);
        if (constructor == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(43);
            sb.append("Module missing for content type ");
            sb.append(i);
            throw new java.lang.IllegalStateException(sb.toString());
        }
        try {
            return constructor.newInstance(new com.google.android.exoplayer2.MediaItem.Builder().setUri(downloadRequest.uri).setStreamKeys(downloadRequest.streamKeys).setCustomCacheKey(downloadRequest.customCacheKey).setDrmKeySetId(downloadRequest.keySetId).build(), this.a, this.b);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(61);
            sb2.append("Failed to instantiate downloader for content type ");
            sb2.append(i);
            throw new java.lang.IllegalStateException(sb2.toString());
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloaderFactory
    public com.google.android.exoplayer2.offline.Downloader createDownloader(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest) {
        int inferContentTypeForUriAndMimeType = com.google.android.exoplayer2.util.Util.inferContentTypeForUriAndMimeType(downloadRequest.uri, downloadRequest.mimeType);
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 1 || inferContentTypeForUriAndMimeType == 2) {
            return a(downloadRequest, inferContentTypeForUriAndMimeType);
        }
        if (inferContentTypeForUriAndMimeType == 3) {
            return new com.google.android.exoplayer2.offline.ProgressiveDownloader(new com.google.android.exoplayer2.MediaItem.Builder().setUri(downloadRequest.uri).setCustomCacheKey(downloadRequest.customCacheKey).build(), this.a, this.b);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(29);
        sb.append("Unsupported type: ");
        sb.append(inferContentTypeForUriAndMimeType);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }
}
