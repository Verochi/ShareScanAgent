package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class SingleSampleMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {
    public final com.google.android.exoplayer2.Format A;
    public final long B;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy C;
    public final boolean D;
    public final com.google.android.exoplayer2.Timeline E;
    public final com.google.android.exoplayer2.MediaItem F;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener G;
    public final com.google.android.exoplayer2.upstream.DataSpec y;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory z;

    @java.lang.Deprecated
    public interface EventListener {
        void onLoadError(int i, java.io.IOException iOException);
    }

    @java.lang.Deprecated
    public static final class EventListenerWrapper implements com.google.android.exoplayer2.source.MediaSourceEventListener {
        public final com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener n;
        public final int t;

        public EventListenerWrapper(com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener eventListener, int i) {
            this.n = (com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
            this.t = i;
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
            this.n.onLoadError(this.t, iOException);
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

    public static final class Factory {
        public final com.google.android.exoplayer2.upstream.DataSource.Factory a;
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy b = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
        public boolean c;

        @androidx.annotation.Nullable
        public java.lang.Object d;

        @androidx.annotation.Nullable
        public java.lang.String e;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.a = (com.google.android.exoplayer2.upstream.DataSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.SingleSampleMediaSource createMediaSource(android.net.Uri uri, com.google.android.exoplayer2.Format format, long j) {
            java.lang.String str = format.id;
            if (str == null) {
                str = this.e;
            }
            return new com.google.android.exoplayer2.source.SingleSampleMediaSource(str, new com.google.android.exoplayer2.MediaItem.Subtitle(uri, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType), format.language, format.selectionFlags), this.a, j, this.b, this.c, this.d, null);
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource createMediaSource(com.google.android.exoplayer2.MediaItem.Subtitle subtitle, long j) {
            return new com.google.android.exoplayer2.source.SingleSampleMediaSource(this.e, subtitle, this.a, j, this.b, this.c, this.d, null);
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            }
            this.b = loadErrorHandlingPolicy;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy(new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i));
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.d = obj;
            return this;
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setTrackId(@androidx.annotation.Nullable java.lang.String str) {
            this.e = str;
            return this;
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setTreatLoadErrorsAsEndOfStream(boolean z) {
            this.c = z;
            return this;
        }
    }

    @java.lang.Deprecated
    public SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j) {
        this(uri, factory, format, j, 3);
    }

    @java.lang.Deprecated
    public SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j, int i) {
        this(uri, factory, format, j, i, null, null, -1, false);
    }

    @java.lang.Deprecated
    public SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j, int i, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener eventListener, int i2, boolean z) {
        this(null, new com.google.android.exoplayer2.MediaItem.Subtitle(uri, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType), format.language, format.selectionFlags), factory, j, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i), z, null);
        if (handler == null || eventListener == null) {
            return;
        }
        addEventListener(handler, new com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListenerWrapper(eventListener, i2));
    }

    public SingleSampleMediaSource(@androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.MediaItem.Subtitle subtitle, com.google.android.exoplayer2.upstream.DataSource.Factory factory, long j, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, @androidx.annotation.Nullable java.lang.Object obj) {
        this.z = factory;
        this.B = j;
        this.C = loadErrorHandlingPolicy;
        this.D = z;
        com.google.android.exoplayer2.MediaItem build = new com.google.android.exoplayer2.MediaItem.Builder().setUri(android.net.Uri.EMPTY).setMediaId(subtitle.uri.toString()).setSubtitles(java.util.Collections.singletonList(subtitle)).setTag(obj).build();
        this.F = build;
        this.A = new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType(subtitle.mimeType).setLanguage(subtitle.language).setSelectionFlags(subtitle.selectionFlags).setRoleFlags(subtitle.roleFlags).setLabel(subtitle.label).build();
        this.y = new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(subtitle.uri).setFlags(1).build();
        this.E = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j, true, false, false, (java.lang.Object) null, build);
    }

    public /* synthetic */ SingleSampleMediaSource(java.lang.String str, com.google.android.exoplayer2.MediaItem.Subtitle subtitle, com.google.android.exoplayer2.upstream.DataSource.Factory factory, long j, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, java.lang.Object obj, com.google.android.exoplayer2.source.SingleSampleMediaSource.AnonymousClass1 anonymousClass1) {
        this(str, subtitle, factory, j, loadErrorHandlingPolicy, z, obj);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        return new com.google.android.exoplayer2.source.SingleSampleMediaPeriod(this.y, this.z, this.G, this.A, this.B, this.C, createEventDispatcher(mediaPeriodId), this.D);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.F;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return ((com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Util.castNonNull(this.F.playbackProperties)).tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.G = transferListener;
        refreshSourceInfo(this.E);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.SingleSampleMediaPeriod) mediaPeriod).e();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }
}
