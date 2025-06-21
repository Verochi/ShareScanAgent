package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public abstract class CompositeMediaSource<T> extends com.google.android.exoplayer2.source.BaseMediaSource {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener A;
    public final java.util.HashMap<T, com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener> y = new java.util.HashMap<>();

    @androidx.annotation.Nullable
    public android.os.Handler z;

    public final class ForwardingEventListener implements com.google.android.exoplayer2.source.MediaSourceEventListener, com.google.android.exoplayer2.drm.DrmSessionEventListener {

        @com.google.android.exoplayer2.util.UnknownNull
        public final T n;
        public com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher t;
        public com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher u;

        public ForwardingEventListener(@com.google.android.exoplayer2.util.UnknownNull T t) {
            this.t = com.google.android.exoplayer2.source.CompositeMediaSource.this.createEventDispatcher(null);
            this.u = com.google.android.exoplayer2.source.CompositeMediaSource.this.createDrmEventDispatcher(null);
            this.n = t;
        }

        public final boolean a(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = com.google.android.exoplayer2.source.CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.n, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int windowIndexForChildWindowIndex = com.google.android.exoplayer2.source.CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.n, i);
            com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher = this.t;
            if (eventDispatcher.windowIndex != windowIndexForChildWindowIndex || !com.google.android.exoplayer2.util.Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
                this.t = com.google.android.exoplayer2.source.CompositeMediaSource.this.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2, 0L);
            }
            com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.u;
            if (eventDispatcher2.windowIndex == windowIndexForChildWindowIndex && com.google.android.exoplayer2.util.Util.areEqual(eventDispatcher2.mediaPeriodId, mediaPeriodId2)) {
                return true;
            }
            this.u = com.google.android.exoplayer2.source.CompositeMediaSource.this.createDrmEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2);
            return true;
        }

        public final com.google.android.exoplayer2.source.MediaLoadData b(com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            long mediaTimeForChildMediaTime = com.google.android.exoplayer2.source.CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.n, mediaLoadData.mediaStartTimeMs);
            long mediaTimeForChildMediaTime2 = com.google.android.exoplayer2.source.CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.n, mediaLoadData.mediaEndTimeMs);
            return (mediaTimeForChildMediaTime == mediaLoadData.mediaStartTimeMs && mediaTimeForChildMediaTime2 == mediaLoadData.mediaEndTimeMs) ? mediaLoadData : new com.google.android.exoplayer2.source.MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.downstreamFormatChanged(b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysLoaded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.u.drmKeysLoaded();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRemoved(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.u.drmKeysRemoved();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRestored(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.u.drmKeysRestored();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionAcquired(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.u.drmSessionAcquired();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.lang.Exception exc) {
            if (a(i, mediaPeriodId)) {
                this.u.drmSessionManagerError(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionReleased(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.u.drmSessionReleased();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.loadCanceled(loadEventInfo, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.loadCompleted(loadEventInfo, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
            if (a(i, mediaPeriodId)) {
                this.t.loadError(loadEventInfo, b(mediaLoadData), iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.loadStarted(loadEventInfo, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.upstreamDiscarded(b(mediaLoadData));
            }
        }
    }

    public static final class MediaSourceAndListener {
        public final com.google.android.exoplayer2.source.MediaSource a;
        public final com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller b;
        public final com.google.android.exoplayer2.source.MediaSourceEventListener c;

        public MediaSourceAndListener(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            this.a = mediaSource;
            this.b = mediaSourceCaller;
            this.c = mediaSourceEventListener;
        }
    }

    public final void disableChildSource(@com.google.android.exoplayer2.util.UnknownNull T t) {
        com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener = (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.y.get(t));
        mediaSourceAndListener.a.disable(mediaSourceAndListener.b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @androidx.annotation.CallSuper
    public void disableInternal() {
        for (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener : this.y.values()) {
            mediaSourceAndListener.a.disable(mediaSourceAndListener.b);
        }
    }

    public final void enableChildSource(@com.google.android.exoplayer2.util.UnknownNull T t) {
        com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener = (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.y.get(t));
        mediaSourceAndListener.a.enable(mediaSourceAndListener.b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @androidx.annotation.CallSuper
    public void enableInternal() {
        for (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener : this.y.values()) {
            mediaSourceAndListener.a.enable(mediaSourceAndListener.b);
        }
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(@com.google.android.exoplayer2.util.UnknownNull T t, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    public long getMediaTimeForChildMediaTime(@com.google.android.exoplayer2.util.UnknownNull T t, long j) {
        return j;
    }

    public int getWindowIndexForChildWindowIndex(@com.google.android.exoplayer2.util.UnknownNull T t, int i) {
        return i;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.CallSuper
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        java.util.Iterator<com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener> it = this.y.values().iterator();
        while (it.hasNext()) {
            it.next().a.maybeThrowSourceInfoRefreshError();
        }
    }

    /* renamed from: onChildSourceInfoRefreshed, reason: merged with bridge method [inline-methods] */
    public abstract void b(@com.google.android.exoplayer2.util.UnknownNull T t, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline);

    public final void prepareChildSource(@com.google.android.exoplayer2.util.UnknownNull T t, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(!this.y.containsKey(t));
        com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller yrVar = new defpackage.yr(this, t);
        com.google.android.exoplayer2.source.CompositeMediaSource.ForwardingEventListener forwardingEventListener = new com.google.android.exoplayer2.source.CompositeMediaSource.ForwardingEventListener(t);
        this.y.put(t, new com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener(mediaSource, yrVar, forwardingEventListener));
        mediaSource.addEventListener((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.z), forwardingEventListener);
        mediaSource.addDrmEventListener((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.z), forwardingEventListener);
        mediaSource.prepareSource(yrVar, this.A);
        if (isEnabled()) {
            return;
        }
        mediaSource.disable(yrVar);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @androidx.annotation.CallSuper
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.A = transferListener;
        this.z = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
    }

    public final void releaseChildSource(@com.google.android.exoplayer2.util.UnknownNull T t) {
        com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener = (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.y.remove(t));
        mediaSourceAndListener.a.releaseSource(mediaSourceAndListener.b);
        mediaSourceAndListener.a.removeEventListener(mediaSourceAndListener.c);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @androidx.annotation.CallSuper
    public void releaseSourceInternal() {
        for (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener : this.y.values()) {
            mediaSourceAndListener.a.releaseSource(mediaSourceAndListener.b);
            mediaSourceAndListener.a.removeEventListener(mediaSourceAndListener.c);
        }
        this.y.clear();
    }
}
