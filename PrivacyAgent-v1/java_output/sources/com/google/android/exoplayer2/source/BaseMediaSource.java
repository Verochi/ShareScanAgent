package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public abstract class BaseMediaSource implements com.google.android.exoplayer2.source.MediaSource {
    public final java.util.ArrayList<com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller> n = new java.util.ArrayList<>(1);
    public final java.util.HashSet<com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller> t = new java.util.HashSet<>(1);
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher u = new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher();
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher v = new com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher();

    @androidx.annotation.Nullable
    public android.os.Looper w;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Timeline x;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addDrmEventListener(android.os.Handler handler, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(handler);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(drmSessionEventListener);
        this.v.addEventListener(handler, drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(handler);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSourceEventListener);
        this.u.addEventListener(handler, mediaSourceEventListener);
    }

    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return this.v.withParameters(i, mediaPeriodId);
    }

    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(@androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return this.v.withParameters(0, mediaPeriodId);
    }

    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j) {
        return this.u.withParameters(i, mediaPeriodId, j);
    }

    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher(@androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return this.u.withParameters(0, mediaPeriodId, 0L);
    }

    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaPeriodId);
        return this.u.withParameters(0, mediaPeriodId, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void disable(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z = !this.t.isEmpty();
        this.t.remove(mediaSourceCaller);
        if (z && this.t.isEmpty()) {
            disableInternal();
        }
    }

    public void disableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void enable(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.w);
        boolean isEmpty = this.t.isEmpty();
        this.t.add(mediaSourceCaller);
        if (isEmpty) {
            enableInternal();
        }
    }

    public void enableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ com.google.android.exoplayer2.Timeline getInitialTimeline() {
        return defpackage.md1.a(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ java.lang.Object getTag() {
        return defpackage.md1.b(this);
    }

    public final boolean isEnabled() {
        return !this.t.isEmpty();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ boolean isSingleWindow() {
        return defpackage.md1.c(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void prepareSource(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        android.os.Looper myLooper = android.os.Looper.myLooper();
        android.os.Looper looper = this.w;
        com.google.android.exoplayer2.util.Assertions.checkArgument(looper == null || looper == myLooper);
        com.google.android.exoplayer2.Timeline timeline = this.x;
        this.n.add(mediaSourceCaller);
        if (this.w == null) {
            this.w = myLooper;
            this.t.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline != null) {
            enable(mediaSourceCaller);
            mediaSourceCaller.onSourceInfoRefreshed(this, timeline);
        }
    }

    public abstract void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener);

    public final void refreshSourceInfo(com.google.android.exoplayer2.Timeline timeline) {
        this.x = timeline;
        java.util.Iterator<com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, timeline);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void releaseSource(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.n.remove(mediaSourceCaller);
        if (!this.n.isEmpty()) {
            disable(mediaSourceCaller);
            return;
        }
        this.w = null;
        this.x = null;
        this.t.clear();
        releaseSourceInternal();
    }

    public abstract void releaseSourceInternal();

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeDrmEventListener(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
        this.v.removeEventListener(drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeEventListener(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this.u.removeEventListener(mediaSourceEventListener);
    }
}
