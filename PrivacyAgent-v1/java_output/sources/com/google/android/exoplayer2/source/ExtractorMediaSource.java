package com.google.android.exoplayer2.source;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class ExtractorMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Void> {

    @java.lang.Deprecated
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    public final com.google.android.exoplayer2.source.ProgressiveMediaSource B;

    @java.lang.Deprecated
    public interface EventListener {
        void onLoadError(java.io.IOException iOException);
    }

    @java.lang.Deprecated
    public static final class EventListenerWrapper implements com.google.android.exoplayer2.source.MediaSourceEventListener {
        public final com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener n;

        public EventListenerWrapper(com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener) {
            this.n = (com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onDownstreamFormatChanged(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            defpackage.nd1.a(this, i, mediaPeriodId, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCanceled(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            defpackage.nd1.b(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCompleted(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            defpackage.nd1.c(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
            this.n.onLoadError(iOException);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadStarted(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            defpackage.nd1.e(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onUpstreamDiscarded(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            defpackage.nd1.f(this, i, mediaPeriodId, mediaLoadData);
        }
    }

    @java.lang.Deprecated
    public static final class Factory implements com.google.android.exoplayer2.source.MediaSourceFactory {
        public final com.google.android.exoplayer2.upstream.DataSource.Factory a;
        public com.google.android.exoplayer2.extractor.ExtractorsFactory b = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory();
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy c = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
        public int d = 1048576;

        @androidx.annotation.Nullable
        public java.lang.String e;

        @androidx.annotation.Nullable
        public java.lang.Object f;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.a = factory;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource createMediaSource(android.net.Uri uri) {
            return createMediaSource(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).build());
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource createMediaSource(android.net.Uri uri, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.ExtractorMediaSource createMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ExtractorMediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            android.net.Uri uri = playbackProperties.uri;
            com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.a;
            com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory = this.b;
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.c;
            java.lang.String str = this.e;
            int i = this.d;
            java.lang.Object obj = playbackProperties.tag;
            if (obj == null) {
                obj = this.f;
            }
            return new com.google.android.exoplayer2.source.ExtractorMediaSource(uri, factory, extractorsFactory, loadErrorHandlingPolicy, str, i, obj, null);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.d = i;
            return this;
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setCustomCacheKey(@androidx.annotation.Nullable java.lang.String str) {
            this.e = str;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.MediaSourceFactory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.MediaSourceFactory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
            throw new java.lang.UnsupportedOperationException();
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setExtractorsFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
            if (extractorsFactory == null) {
                extractorsFactory = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory();
            }
            this.b = extractorsFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            }
            this.c = loadErrorHandlingPolicy;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy((com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy) new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(java.util.List list) {
            return defpackage.ud1.b(this, list);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.f = obj;
            return this;
        }
    }

    @java.lang.Deprecated
    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, null);
    }

    @java.lang.Deprecated
    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener, @androidx.annotation.Nullable java.lang.String str) {
        this(uri, factory, extractorsFactory, handler, eventListener, str, 1048576);
    }

    @java.lang.Deprecated
    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener, @androidx.annotation.Nullable java.lang.String str, int i) {
        this(uri, factory, extractorsFactory, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(), str, i, (java.lang.Object) null);
        if (eventListener == null || handler == null) {
            return;
        }
        addEventListener(handler, new com.google.android.exoplayer2.source.ExtractorMediaSource.EventListenerWrapper(eventListener));
    }

    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, @androidx.annotation.Nullable java.lang.String str, int i, @androidx.annotation.Nullable java.lang.Object obj) {
        this.B = new com.google.android.exoplayer2.source.ProgressiveMediaSource(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setCustomCacheKey(str).setTag(obj).build(), factory, extractorsFactory, defpackage.z60.c(), loadErrorHandlingPolicy, i);
    }

    public /* synthetic */ ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, java.lang.String str, int i, java.lang.Object obj, com.google.android.exoplayer2.source.ExtractorMediaSource.AnonymousClass1 anonymousClass1) {
        this(uri, factory, extractorsFactory, loadErrorHandlingPolicy, str, i, obj);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        return this.B.createPeriod(mediaPeriodId, allocator, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.B.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.B.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(@androidx.annotation.Nullable java.lang.Void r1, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        refreshSourceInfo(timeline);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.B);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.B.releasePeriod(mediaPeriod);
    }
}
