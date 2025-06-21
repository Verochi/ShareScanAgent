package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class DefaultMediaSourceFactory implements com.google.android.exoplayer2.source.MediaSourceFactory {
    public final com.google.android.exoplayer2.source.MediaSourceDrmHelper a;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory b;
    public final android.util.SparseArray<com.google.android.exoplayer2.source.MediaSourceFactory> c;
    public final int[] d;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory.AdsLoaderProvider e;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider f;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSessionManager g;

    @androidx.annotation.Nullable
    public java.util.List<com.google.android.exoplayer2.offline.StreamKey> h;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy i;

    public interface AdsLoaderProvider {
        @androidx.annotation.Nullable
        com.google.android.exoplayer2.source.ads.AdsLoader getAdsLoader(android.net.Uri uri);
    }

    public DefaultMediaSourceFactory(android.content.Context context) {
        this(new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory(context));
    }

    public DefaultMediaSourceFactory(android.content.Context context, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
        this(new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(factory, new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
        this.b = factory;
        this.a = new com.google.android.exoplayer2.source.MediaSourceDrmHelper();
        android.util.SparseArray<com.google.android.exoplayer2.source.MediaSourceFactory> a = a(factory, extractorsFactory);
        this.c = a;
        this.d = new int[a.size()];
        for (int i = 0; i < this.c.size(); i++) {
            this.d[i] = this.c.keyAt(i);
        }
    }

    public static android.util.SparseArray<com.google.android.exoplayer2.source.MediaSourceFactory> a(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
        android.util.SparseArray<com.google.android.exoplayer2.source.MediaSourceFactory> sparseArray = new android.util.SparseArray<>();
        try {
            sparseArray.put(0, (com.google.android.exoplayer2.source.MediaSourceFactory) com.google.android.exoplayer2.source.dash.DashMediaSource.Factory.class.asSubclass(com.google.android.exoplayer2.source.MediaSourceFactory.class).getConstructor(com.google.android.exoplayer2.upstream.DataSource.Factory.class).newInstance(factory));
        } catch (java.lang.Exception unused) {
        }
        try {
            sparseArray.put(1, (com.google.android.exoplayer2.source.MediaSourceFactory) com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory.class.asSubclass(com.google.android.exoplayer2.source.MediaSourceFactory.class).getConstructor(com.google.android.exoplayer2.upstream.DataSource.Factory.class).newInstance(factory));
        } catch (java.lang.Exception unused2) {
        }
        try {
            sparseArray.put(2, (com.google.android.exoplayer2.source.MediaSourceFactory) com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class.asSubclass(com.google.android.exoplayer2.source.MediaSourceFactory.class).getConstructor(com.google.android.exoplayer2.upstream.DataSource.Factory.class).newInstance(factory));
        } catch (java.lang.Exception unused3) {
        }
        sparseArray.put(3, new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(factory, extractorsFactory));
        return sparseArray;
    }

    public static com.google.android.exoplayer2.source.MediaSource b(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties = mediaItem.clippingProperties;
        long j = clippingProperties.startPositionMs;
        if (j == 0 && clippingProperties.endPositionMs == Long.MIN_VALUE && !clippingProperties.relativeToDefaultPosition) {
            return mediaSource;
        }
        long msToUs = com.google.android.exoplayer2.C.msToUs(j);
        long msToUs2 = com.google.android.exoplayer2.C.msToUs(mediaItem.clippingProperties.endPositionMs);
        com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties2 = mediaItem.clippingProperties;
        return new com.google.android.exoplayer2.source.ClippingMediaSource(mediaSource, msToUs, msToUs2, !clippingProperties2.startsAtKeyFrame, clippingProperties2.relativeToLiveWindow, clippingProperties2.relativeToDefaultPosition);
    }

    public final com.google.android.exoplayer2.source.MediaSource c(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        android.net.Uri uri = mediaItem.playbackProperties.adTagUri;
        if (uri == null) {
            return mediaSource;
        }
        com.google.android.exoplayer2.source.DefaultMediaSourceFactory.AdsLoaderProvider adsLoaderProvider = this.e;
        com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider = this.f;
        if (adsLoaderProvider == null || adViewProvider == null) {
            com.google.android.exoplayer2.util.Log.w("DefaultMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        com.google.android.exoplayer2.source.ads.AdsLoader adsLoader = adsLoaderProvider.getAdsLoader(uri);
        if (adsLoader != null) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource(mediaSource, new com.google.android.exoplayer2.upstream.DataSpec(uri), this, adsLoader, adViewProvider);
        }
        com.google.android.exoplayer2.util.Log.w("DefaultMediaSourceFactory", "Playing media without ads. No AdsLoader for provided adTagUri");
        return mediaSource;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public /* synthetic */ com.google.android.exoplayer2.source.MediaSource createMediaSource(android.net.Uri uri) {
        return defpackage.ud1.a(this, uri);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public com.google.android.exoplayer2.source.MediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
        int inferContentTypeForUriAndMimeType = com.google.android.exoplayer2.util.Util.inferContentTypeForUriAndMimeType(playbackProperties.uri, playbackProperties.mimeType);
        com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory = this.c.get(inferContentTypeForUriAndMimeType);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(68);
        sb.append("No suitable media source factory found for content type: ");
        sb.append(inferContentTypeForUriAndMimeType);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSourceFactory, sb.toString());
        com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.g;
        if (drmSessionManager == null) {
            drmSessionManager = this.a.create(mediaItem);
        }
        mediaSourceFactory.setDrmSessionManager(drmSessionManager);
        mediaSourceFactory.setStreamKeys(!mediaItem.playbackProperties.streamKeys.isEmpty() ? mediaItem.playbackProperties.streamKeys : this.h);
        mediaSourceFactory.setLoadErrorHandlingPolicy(this.i);
        com.google.android.exoplayer2.source.MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        java.util.List<com.google.android.exoplayer2.MediaItem.Subtitle> list = mediaItem.playbackProperties.subtitles;
        if (!list.isEmpty()) {
            com.google.android.exoplayer2.source.MediaSource[] mediaSourceArr = new com.google.android.exoplayer2.source.MediaSource[list.size() + 1];
            int i = 0;
            mediaSourceArr[0] = createMediaSource;
            com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory factory = new com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory(this.b);
            while (i < list.size()) {
                int i2 = i + 1;
                mediaSourceArr[i2] = factory.createMediaSource(list.get(i), -9223372036854775807L);
                i = i2;
            }
            createMediaSource = new com.google.android.exoplayer2.source.MergingMediaSource(mediaSourceArr);
        }
        return c(mediaItem, b(mediaItem, createMediaSource));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public int[] getSupportedTypes() {
        int[] iArr = this.d;
        return java.util.Arrays.copyOf(iArr, iArr.length);
    }

    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setAdViewProvider(@androidx.annotation.Nullable com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        this.f = adViewProvider;
        return this;
    }

    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setAdsLoaderProvider(@androidx.annotation.Nullable com.google.android.exoplayer2.source.DefaultMediaSourceFactory.AdsLoaderProvider adsLoaderProvider) {
        this.e = adsLoaderProvider;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
        this.a.setDrmHttpDataSourceFactory(factory);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
        this.g = drmSessionManager;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
        this.a.setDrmUserAgent(str);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.i = loadErrorHandlingPolicy;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @java.lang.Deprecated
    public com.google.android.exoplayer2.source.DefaultMediaSourceFactory setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        if (list == null || list.isEmpty()) {
            list = null;
        }
        this.h = list;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(@androidx.annotation.Nullable java.util.List list) {
        return setStreamKeys((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }
}
