package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class ProgressiveMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource implements com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory A;
    public final com.google.android.exoplayer2.extractor.ExtractorsFactory B;
    public final com.google.android.exoplayer2.drm.DrmSessionManager C;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy D;
    public final int E;
    public boolean F = true;
    public long G = -9223372036854775807L;
    public boolean H;
    public boolean I;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener J;
    public final com.google.android.exoplayer2.MediaItem y;
    public final com.google.android.exoplayer2.MediaItem.PlaybackProperties z;

    /* renamed from: com.google.android.exoplayer2.source.ProgressiveMediaSource$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.exoplayer2.source.ForwardingTimeline {
        public AnonymousClass1(com.google.android.exoplayer2.source.ProgressiveMediaSource progressiveMediaSource, com.google.android.exoplayer2.Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
            super.getWindow(i, window, j);
            window.isPlaceholder = true;
            return window;
        }
    }

    public static final class Factory implements com.google.android.exoplayer2.source.MediaSourceFactory {
        public final com.google.android.exoplayer2.upstream.DataSource.Factory a;
        public final com.google.android.exoplayer2.source.MediaSourceDrmHelper b;
        public com.google.android.exoplayer2.extractor.ExtractorsFactory c;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmSessionManager d;
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy e;
        public int f;

        @androidx.annotation.Nullable
        public java.lang.String g;

        @androidx.annotation.Nullable
        public java.lang.Object h;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(factory, new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory());
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
            this.a = factory;
            this.c = extractorsFactory;
            this.b = new com.google.android.exoplayer2.source.MediaSourceDrmHelper();
            this.e = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.f = 1048576;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ProgressiveMediaSource createMediaSource(android.net.Uri uri) {
            return createMediaSource(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).build());
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ProgressiveMediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            boolean z = playbackProperties.tag == null && this.h != null;
            boolean z2 = playbackProperties.customCacheKey == null && this.g != null;
            if (z && z2) {
                mediaItem = mediaItem.buildUpon().setTag(this.h).setCustomCacheKey(this.g).build();
            } else if (z) {
                mediaItem = mediaItem.buildUpon().setTag(this.h).build();
            } else if (z2) {
                mediaItem = mediaItem.buildUpon().setCustomCacheKey(this.g).build();
            }
            com.google.android.exoplayer2.MediaItem mediaItem2 = mediaItem;
            com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.a;
            com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory = this.c;
            com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.d;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(mediaItem2);
            }
            return new com.google.android.exoplayer2.source.ProgressiveMediaSource(mediaItem2, factory, extractorsFactory, drmSessionManager, this.e, this.f);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.f = i;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setCustomCacheKey(@androidx.annotation.Nullable java.lang.String str) {
            this.g = str;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
            this.b.setDrmHttpDataSourceFactory(factory);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
            this.d = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
            this.b.setDrmUserAgent(str);
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setExtractorsFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
            if (extractorsFactory == null) {
                extractorsFactory = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory();
            }
            this.c = extractorsFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            }
            this.e = loadErrorHandlingPolicy;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(java.util.List list) {
            return defpackage.ud1.b(this, list);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.h = obj;
            return this;
        }
    }

    public ProgressiveMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i) {
        this.z = (com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.y = mediaItem;
        this.A = factory;
        this.B = extractorsFactory;
        this.C = drmSessionManager;
        this.D = loadErrorHandlingPolicy;
        this.E = i;
    }

    public final void a() {
        com.google.android.exoplayer2.Timeline singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(this.G, this.H, false, this.I, (java.lang.Object) null, this.y);
        if (this.F) {
            singlePeriodTimeline = new com.google.android.exoplayer2.source.ProgressiveMediaSource.AnonymousClass1(this, singlePeriodTimeline);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        com.google.android.exoplayer2.upstream.DataSource createDataSource = this.A.createDataSource();
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.J;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        return new com.google.android.exoplayer2.source.ProgressiveMediaPeriod(this.z.uri, createDataSource, this.B, this.C, createDrmEventDispatcher(mediaPeriodId), this.D, createEventDispatcher(mediaPeriodId), this, allocator, this.z.customCacheKey, this.E);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.y;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.z.tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener
    public void onSourceInfoRefreshed(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.G;
        }
        if (!this.F && this.G == j && this.H == z && this.I == z2) {
            return;
        }
        this.G = j;
        this.H = z;
        this.I = z2;
        this.F = false;
        a();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.J = transferListener;
        this.C.prepare();
        a();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.ProgressiveMediaPeriod) mediaPeriod).H();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.C.release();
    }
}
