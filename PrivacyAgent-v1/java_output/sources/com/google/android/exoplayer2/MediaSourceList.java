package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class MediaSourceList {
    public final com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener d;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher e;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher f;
    public final java.util.HashMap<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder, com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener> g;
    public final java.util.Set<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> h;
    public boolean j;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener k;
    public com.google.android.exoplayer2.source.ShuffleOrder i = new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(0);
    public final java.util.IdentityHashMap<com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> b = new java.util.IdentityHashMap<>();
    public final java.util.Map<java.lang.Object, com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> c = new java.util.HashMap();
    public final java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> a = new java.util.ArrayList();

    public final class ForwardingEventListener implements com.google.android.exoplayer2.source.MediaSourceEventListener, com.google.android.exoplayer2.drm.DrmSessionEventListener {
        public final com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder n;
        public com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher t;
        public com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher u;

        public ForwardingEventListener(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder) {
            this.t = com.google.android.exoplayer2.MediaSourceList.this.e;
            this.u = com.google.android.exoplayer2.MediaSourceList.this.f;
            this.n = mediaSourceHolder;
        }

        public final boolean a(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = com.google.android.exoplayer2.MediaSourceList.n(this.n, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int r = com.google.android.exoplayer2.MediaSourceList.r(this.n, i);
            com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher = this.t;
            if (eventDispatcher.windowIndex != r || !com.google.android.exoplayer2.util.Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
                this.t = com.google.android.exoplayer2.MediaSourceList.this.e.withParameters(r, mediaPeriodId2, 0L);
            }
            com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.u;
            if (eventDispatcher2.windowIndex == r && com.google.android.exoplayer2.util.Util.areEqual(eventDispatcher2.mediaPeriodId, mediaPeriodId2)) {
                return true;
            }
            this.u = com.google.android.exoplayer2.MediaSourceList.this.f.withParameters(r, mediaPeriodId2);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.downstreamFormatChanged(mediaLoadData);
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
                this.t.loadCanceled(loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.loadCompleted(loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
            if (a(i, mediaPeriodId)) {
                this.t.loadError(loadEventInfo, mediaLoadData, iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.loadStarted(loadEventInfo, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.t.upstreamDiscarded(mediaLoadData);
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

    public static final class MediaSourceHolder implements com.google.android.exoplayer2.MediaSourceInfoHolder {
        public final com.google.android.exoplayer2.source.MaskingMediaSource a;
        public int d;
        public boolean e;
        public final java.util.List<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> c = new java.util.ArrayList();
        public final java.lang.Object b = new java.lang.Object();

        public MediaSourceHolder(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z) {
            this.a = new com.google.android.exoplayer2.source.MaskingMediaSource(mediaSource, z);
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public com.google.android.exoplayer2.Timeline a() {
            return this.a.getTimeline();
        }

        public void b(int i) {
            this.d = i;
            this.e = false;
            this.c.clear();
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public java.lang.Object getUid() {
            return this.b;
        }
    }

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public MediaSourceList(com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, @androidx.annotation.Nullable com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, android.os.Handler handler) {
        this.d = mediaSourceListInfoRefreshListener;
        com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher = new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher();
        this.e = eventDispatcher;
        com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher2 = new com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher();
        this.f = eventDispatcher2;
        this.g = new java.util.HashMap<>();
        this.h = new java.util.HashSet();
        if (analyticsCollector != null) {
            eventDispatcher.addEventListener(handler, analyticsCollector);
            eventDispatcher2.addEventListener(handler, analyticsCollector);
        }
    }

    public static java.lang.Object m(java.lang.Object obj) {
        return com.google.android.exoplayer2.AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.MediaSource.MediaPeriodId n(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.c.size(); i++) {
            if (mediaSourceHolder.c.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(p(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    public static java.lang.Object o(java.lang.Object obj) {
        return com.google.android.exoplayer2.AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    public static java.lang.Object p(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder, java.lang.Object obj) {
        return com.google.android.exoplayer2.AbstractConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.b, obj);
    }

    public static int r(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder, int i) {
        return i + mediaSourceHolder.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        this.d.onPlaylistUpdateRequested();
    }

    public com.google.android.exoplayer2.Timeline A(int i, int i2, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= q());
        this.i = shuffleOrder;
        B(i, i2);
        return i();
    }

    public final void B(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder remove = this.a.remove(i3);
            this.c.remove(remove.b);
            g(i3, -remove.a.getTimeline().getWindowCount());
            remove.e = true;
            if (this.j) {
                u(remove);
            }
        }
    }

    public com.google.android.exoplayer2.Timeline C(java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> list, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        B(0, this.a.size());
        return f(this.a.size(), list, shuffleOrder);
    }

    public com.google.android.exoplayer2.Timeline D(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        int q = q();
        if (shuffleOrder.getLength() != q) {
            shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, q);
        }
        this.i = shuffleOrder;
        return i();
    }

    public com.google.android.exoplayer2.Timeline f(int i, java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> list, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.i = shuffleOrder;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = list.get(i2 - i);
                if (i2 > 0) {
                    com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder2 = this.a.get(i2 - 1);
                    mediaSourceHolder.b(mediaSourceHolder2.d + mediaSourceHolder2.a.getTimeline().getWindowCount());
                } else {
                    mediaSourceHolder.b(0);
                }
                g(i2, mediaSourceHolder.a.getTimeline().getWindowCount());
                this.a.add(i2, mediaSourceHolder);
                this.c.put(mediaSourceHolder.b, mediaSourceHolder);
                if (this.j) {
                    x(mediaSourceHolder);
                    if (this.b.isEmpty()) {
                        this.h.add(mediaSourceHolder);
                    } else {
                        j(mediaSourceHolder);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i, int i2) {
        while (i < this.a.size()) {
            this.a.get(i).d += i2;
            i++;
        }
    }

    public com.google.android.exoplayer2.source.MediaPeriod h(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        java.lang.Object o = o(mediaPeriodId.periodUid);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(m(mediaPeriodId.periodUid));
        com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = (com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c.get(o));
        l(mediaSourceHolder);
        mediaSourceHolder.c.add(copyWithPeriodUid);
        com.google.android.exoplayer2.source.MaskingMediaPeriod createPeriod = mediaSourceHolder.a.createPeriod(copyWithPeriodUid, allocator, j);
        this.b.put(createPeriod, mediaSourceHolder);
        k();
        return createPeriod;
    }

    public com.google.android.exoplayer2.Timeline i() {
        if (this.a.isEmpty()) {
            return com.google.android.exoplayer2.Timeline.EMPTY;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = this.a.get(i2);
            mediaSourceHolder.d = i;
            i += mediaSourceHolder.a.getTimeline().getWindowCount();
        }
        return new com.google.android.exoplayer2.PlaylistTimeline(this.a, this.i);
    }

    public final void j(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder) {
        com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener mediaSourceAndListener = this.g.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.a.disable(mediaSourceAndListener.b);
        }
    }

    public final void k() {
        java.util.Iterator<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> it = this.h.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder next = it.next();
            if (next.c.isEmpty()) {
                j(next);
                it.remove();
            }
        }
    }

    public final void l(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder) {
        this.h.add(mediaSourceHolder);
        com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener mediaSourceAndListener = this.g.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.a.enable(mediaSourceAndListener.b);
        }
    }

    public int q() {
        return this.a.size();
    }

    public boolean s() {
        return this.j;
    }

    public final void u(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.e && mediaSourceHolder.c.isEmpty()) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener mediaSourceAndListener = (com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.g.remove(mediaSourceHolder));
            mediaSourceAndListener.a.releaseSource(mediaSourceAndListener.b);
            mediaSourceAndListener.a.removeEventListener(mediaSourceAndListener.c);
            this.h.remove(mediaSourceHolder);
        }
    }

    public com.google.android.exoplayer2.Timeline v(int i, int i2, int i3, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= q() && i3 >= 0);
        this.i = shuffleOrder;
        if (i == i2 || i == i3) {
            return i();
        }
        int min = java.lang.Math.min(i, i3);
        int max = java.lang.Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int i4 = this.a.get(min).d;
        com.google.android.exoplayer2.util.Util.moveItems(this.a, i, i2, i3);
        while (min <= max) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = this.a.get(min);
            mediaSourceHolder.d = i4;
            i4 += mediaSourceHolder.a.getTimeline().getWindowCount();
            min++;
        }
        return i();
    }

    public void w(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        this.k = transferListener;
        for (int i = 0; i < this.a.size(); i++) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = this.a.get(i);
            x(mediaSourceHolder);
            this.h.add(mediaSourceHolder);
        }
        this.j = true;
    }

    public final void x(com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder) {
        com.google.android.exoplayer2.source.MaskingMediaSource maskingMediaSource = mediaSourceHolder.a;
        com.google.android.exoplayer2.b0 b0Var = new com.google.android.exoplayer2.b0(this);
        com.google.android.exoplayer2.MediaSourceList.ForwardingEventListener forwardingEventListener = new com.google.android.exoplayer2.MediaSourceList.ForwardingEventListener(mediaSourceHolder);
        this.g.put(mediaSourceHolder, new com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener(maskingMediaSource, b0Var, forwardingEventListener));
        maskingMediaSource.addEventListener(com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper(), forwardingEventListener);
        maskingMediaSource.addDrmEventListener(com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper(), forwardingEventListener);
        maskingMediaSource.prepareSource(b0Var, this.k);
    }

    public void y() {
        for (com.google.android.exoplayer2.MediaSourceList.MediaSourceAndListener mediaSourceAndListener : this.g.values()) {
            try {
                mediaSourceAndListener.a.releaseSource(mediaSourceAndListener.b);
            } catch (java.lang.RuntimeException e) {
                com.google.android.exoplayer2.util.Log.e("MediaSourceList", "Failed to release child source.", e);
            }
            mediaSourceAndListener.a.removeEventListener(mediaSourceAndListener.c);
        }
        this.g.clear();
        this.h.clear();
        this.j = false;
    }

    public void z(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = (com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b.remove(mediaPeriod));
        mediaSourceHolder.a.releasePeriod(mediaPeriod);
        mediaSourceHolder.c.remove(((com.google.android.exoplayer2.source.MaskingMediaPeriod) mediaPeriod).id);
        if (!this.b.isEmpty()) {
            k();
        }
        u(mediaSourceHolder);
    }
}
