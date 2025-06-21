package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class ExoPlayerImpl extends com.google.android.exoplayer2.BasePlayer implements com.google.android.exoplayer2.ExoPlayer {
    public boolean A;
    public com.google.android.exoplayer2.PlaybackInfo B;
    public int C;
    public int D;
    public long E;
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult a;
    public final com.google.android.exoplayer2.Renderer[] b;
    public final com.google.android.exoplayer2.trackselection.TrackSelector c;
    public final android.os.Handler d;
    public final com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener e;
    public final com.google.android.exoplayer2.ExoPlayerImplInternal f;
    public final android.os.Handler g;
    public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.BasePlayer.ListenerHolder> h;
    public final com.google.android.exoplayer2.Timeline.Period i;
    public final java.util.ArrayDeque<java.lang.Runnable> j;
    public final java.util.List<com.google.android.exoplayer2.ExoPlayerImpl.MediaSourceHolderSnapshot> k;
    public final boolean l;
    public final com.google.android.exoplayer2.source.MediaSourceFactory m;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.analytics.AnalyticsCollector n;
    public final android.os.Looper o;
    public final com.google.android.exoplayer2.upstream.BandwidthMeter p;
    public int q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f336s;
    public boolean t;
    public int u;
    public int v;
    public boolean w;
    public com.google.android.exoplayer2.SeekParameters x;
    public com.google.android.exoplayer2.source.ShuffleOrder y;
    public boolean z;

    public static final class MediaSourceHolderSnapshot implements com.google.android.exoplayer2.MediaSourceInfoHolder {
        public final java.lang.Object a;
        public com.google.android.exoplayer2.Timeline b;

        public MediaSourceHolderSnapshot(java.lang.Object obj, com.google.android.exoplayer2.Timeline timeline) {
            this.a = obj;
            this.b = timeline;
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public com.google.android.exoplayer2.Timeline a() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public java.lang.Object getUid() {
            return this.a;
        }
    }

    public static final class PlaybackInfoUpdate implements java.lang.Runnable {

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.MediaItem A;
        public final int B;
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final com.google.android.exoplayer2.PlaybackInfo n;
        public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.BasePlayer.ListenerHolder> t;
        public final com.google.android.exoplayer2.trackselection.TrackSelector u;
        public final boolean v;
        public final int w;
        public final int x;
        public final boolean y;
        public final int z;

        public PlaybackInfoUpdate(com.google.android.exoplayer2.PlaybackInfo playbackInfo, com.google.android.exoplayer2.PlaybackInfo playbackInfo2, java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.BasePlayer.ListenerHolder> copyOnWriteArrayList, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, boolean z, int i, int i2, boolean z2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem mediaItem, int i4, boolean z3) {
            this.n = playbackInfo;
            this.t = new java.util.concurrent.CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.u = trackSelector;
            this.v = z;
            this.w = i;
            this.x = i2;
            this.y = z2;
            this.z = i3;
            this.A = mediaItem;
            this.B = i4;
            this.C = z3;
            this.D = playbackInfo2.d != playbackInfo.d;
            com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException = playbackInfo2.e;
            com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException2 = playbackInfo.e;
            this.E = (exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null) ? false : true;
            this.F = playbackInfo2.f != playbackInfo.f;
            this.G = !playbackInfo2.a.equals(playbackInfo.a);
            this.H = playbackInfo2.h != playbackInfo.h;
            this.I = playbackInfo2.j != playbackInfo.j;
            this.J = playbackInfo2.k != playbackInfo.k;
            this.K = n(playbackInfo2) != n(playbackInfo);
            this.L = !playbackInfo2.l.equals(playbackInfo.l);
            this.M = playbackInfo2.m != playbackInfo.m;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onPlaybackSuppressionReasonChanged(this.n.k);
        }

        public static boolean n(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
            return playbackInfo.d == 3 && playbackInfo.j && playbackInfo.k == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onTimelineChanged(this.n.a, this.x);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onPositionDiscontinuity(this.w);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onIsPlayingChanged(n(this.n));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onPlaybackParametersChanged(this.n.l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onExperimentalOffloadSchedulingEnabledChanged(this.n.m);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onMediaItemTransition(this.A, this.z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onPlayerError(this.n.e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(com.google.android.exoplayer2.Player.EventListener eventListener) {
            com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.n;
            eventListener.onTracksChanged(playbackInfo.g, playbackInfo.h.selections);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onIsLoadingChanged(this.n.f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(com.google.android.exoplayer2.Player.EventListener eventListener) {
            com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.n;
            eventListener.onPlayerStateChanged(playbackInfo.j, playbackInfo.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onPlaybackStateChanged(this.n.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(com.google.android.exoplayer2.Player.EventListener eventListener) {
            eventListener.onPlayWhenReadyChanged(this.n.j, this.B);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.G) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.j(this));
            }
            if (this.v) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.s(this));
            }
            if (this.y) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.t(this));
            }
            if (this.E) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.u(this));
            }
            if (this.H) {
                this.u.onSelectionActivated(this.n.h.info);
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.v(this));
            }
            if (this.F) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.w(this));
            }
            if (this.D || this.I) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.k(this));
            }
            if (this.D) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.l(this));
            }
            if (this.I) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.m(this));
            }
            if (this.J) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.n(this));
            }
            if (this.K) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.o(this));
            }
            if (this.L) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.p(this));
            }
            if (this.C) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new defpackage.ka0());
            }
            if (this.M) {
                com.google.android.exoplayer2.ExoPlayerImpl.t(this.t, new com.google.android.exoplayer2.q(this));
            }
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, @androidx.annotation.Nullable com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, boolean z, com.google.android.exoplayer2.SeekParameters seekParameters, boolean z2, com.google.android.exoplayer2.util.Clock clock, android.os.Looper looper) {
        java.lang.String hexString = java.lang.Integer.toHexString(java.lang.System.identityHashCode(this));
        java.lang.String str = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(hexString).length() + 30 + java.lang.String.valueOf(str).length());
        sb.append("Init ");
        sb.append(hexString);
        sb.append(" [");
        sb.append(com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY);
        sb.append("] [");
        sb.append(str);
        sb.append("]");
        com.google.android.exoplayer2.util.Log.i("ExoPlayerImpl", sb.toString());
        com.google.android.exoplayer2.util.Assertions.checkState(rendererArr.length > 0);
        this.b = (com.google.android.exoplayer2.Renderer[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(rendererArr);
        this.c = (com.google.android.exoplayer2.trackselection.TrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(trackSelector);
        this.m = mediaSourceFactory;
        this.p = bandwidthMeter;
        this.n = analyticsCollector;
        this.l = z;
        this.x = seekParameters;
        this.z = z2;
        this.o = looper;
        this.q = 0;
        this.h = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.k = new java.util.ArrayList();
        this.y = new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(0);
        com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult = new com.google.android.exoplayer2.trackselection.TrackSelectorResult(new com.google.android.exoplayer2.RendererConfiguration[rendererArr.length], new com.google.android.exoplayer2.trackselection.TrackSelection[rendererArr.length], null);
        this.a = trackSelectorResult;
        this.i = new com.google.android.exoplayer2.Timeline.Period();
        this.C = -1;
        this.d = new android.os.Handler(looper);
        com.google.android.exoplayer2.b bVar = new com.google.android.exoplayer2.b(this);
        this.e = bVar;
        this.B = com.google.android.exoplayer2.PlaybackInfo.j(trackSelectorResult);
        this.j = new java.util.ArrayDeque<>();
        if (analyticsCollector != null) {
            analyticsCollector.setPlayer(this);
            addListener(analyticsCollector);
            bandwidthMeter.addEventListener(new android.os.Handler(looper), analyticsCollector);
        }
        com.google.android.exoplayer2.ExoPlayerImplInternal exoPlayerImplInternal = new com.google.android.exoplayer2.ExoPlayerImplInternal(rendererArr, trackSelector, trackSelectorResult, loadControl, bandwidthMeter, this.q, this.r, analyticsCollector, seekParameters, z2, looper, clock, bVar);
        this.f = exoPlayerImplInternal;
        this.g = new android.os.Handler(exoPlayerImplInternal.u());
    }

    public static void t(java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.BasePlayer.ListenerHolder> copyOnWriteArrayList, com.google.android.exoplayer2.BasePlayer.ListenerInvocation listenerInvocation) {
        java.util.Iterator<com.google.android.exoplayer2.BasePlayer.ListenerHolder> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().invoke(listenerInvocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.d.post(new com.google.android.exoplayer2.h(this, playbackInfoUpdate));
    }

    public static /* synthetic */ void x(com.google.android.exoplayer2.Player.EventListener eventListener) {
        eventListener.onPlayerError(com.google.android.exoplayer2.ExoPlaybackException.createForTimeout(new java.util.concurrent.TimeoutException("Player release timed out."), 1));
    }

    public static /* synthetic */ void y(com.google.android.exoplayer2.Player.EventListener eventListener) {
        eventListener.onPlayerError(com.google.android.exoplayer2.ExoPlaybackException.createForTimeout(new java.util.concurrent.TimeoutException("Setting foreground mode timed out."), 2));
    }

    public final com.google.android.exoplayer2.PlaybackInfo B(com.google.android.exoplayer2.PlaybackInfo playbackInfo, com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable android.util.Pair<java.lang.Object, java.lang.Long> pair) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(timeline.isEmpty() || pair != null);
        com.google.android.exoplayer2.Timeline timeline2 = playbackInfo.a;
        com.google.android.exoplayer2.PlaybackInfo i = playbackInfo.i(timeline);
        if (timeline.isEmpty()) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId k = com.google.android.exoplayer2.PlaybackInfo.k();
            com.google.android.exoplayer2.PlaybackInfo b = i.c(k, com.google.android.exoplayer2.C.msToUs(this.E), com.google.android.exoplayer2.C.msToUs(this.E), 0L, com.google.android.exoplayer2.source.TrackGroupArray.EMPTY, this.a).b(k);
            b.n = b.p;
            return b;
        }
        java.lang.Object obj = i.b.periodUid;
        boolean z = !obj.equals(((android.util.Pair) com.google.android.exoplayer2.util.Util.castNonNull(pair)).first);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = z ? new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(pair.first) : i.b;
        long longValue = ((java.lang.Long) pair.second).longValue();
        long msToUs = com.google.android.exoplayer2.C.msToUs(getContentPosition());
        if (!timeline2.isEmpty()) {
            msToUs -= timeline2.getPeriodByUid(obj, this.i).getPositionInWindowUs();
        }
        if (z || longValue < msToUs) {
            com.google.android.exoplayer2.util.Assertions.checkState(!mediaPeriodId.isAd());
            com.google.android.exoplayer2.PlaybackInfo b2 = i.c(mediaPeriodId, longValue, longValue, 0L, z ? com.google.android.exoplayer2.source.TrackGroupArray.EMPTY : i.g, z ? this.a : i.h).b(mediaPeriodId);
            b2.n = longValue;
            return b2;
        }
        if (longValue != msToUs) {
            com.google.android.exoplayer2.util.Assertions.checkState(!mediaPeriodId.isAd());
            long max = java.lang.Math.max(0L, i.o - (longValue - msToUs));
            long j = i.n;
            if (i.i.equals(i.b)) {
                j = longValue + max;
            }
            com.google.android.exoplayer2.PlaybackInfo c = i.c(mediaPeriodId, longValue, longValue, max, i.g, i.h);
            c.n = j;
            return c;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(i.i.periodUid);
        if (indexOfPeriod != -1 && timeline.getPeriod(indexOfPeriod, this.i).windowIndex == timeline.getPeriodByUid(mediaPeriodId.periodUid, this.i).windowIndex) {
            return i;
        }
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.i);
        long adDurationUs = mediaPeriodId.isAd() ? this.i.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) : this.i.durationUs;
        com.google.android.exoplayer2.PlaybackInfo b3 = i.c(mediaPeriodId, i.p, i.p, adDurationUs - i.p, i.g, i.h).b(mediaPeriodId);
        b3.n = adDurationUs;
        return b3;
    }

    public final void C(com.google.android.exoplayer2.BasePlayer.ListenerInvocation listenerInvocation) {
        D(new com.google.android.exoplayer2.i(new java.util.concurrent.CopyOnWriteArrayList(this.h), listenerInvocation));
    }

    public final void D(java.lang.Runnable runnable) {
        boolean z = !this.j.isEmpty();
        this.j.addLast(runnable);
        if (z) {
            return;
        }
        while (!this.j.isEmpty()) {
            this.j.peekFirst().run();
            this.j.removeFirst();
        }
    }

    public final long E(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j) {
        long usToMs = com.google.android.exoplayer2.C.usToMs(j);
        this.B.a.getPeriodByUid(mediaPeriodId.periodUid, this.i);
        return usToMs + this.i.getPositionInWindowMs();
    }

    public final com.google.android.exoplayer2.PlaybackInfo F(int i, int i2) {
        boolean z = false;
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0 && i2 >= i && i2 <= this.k.size());
        int currentWindowIndex = getCurrentWindowIndex();
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        int size = this.k.size();
        this.f336s++;
        G(i, i2);
        com.google.android.exoplayer2.Timeline k = k();
        com.google.android.exoplayer2.PlaybackInfo B = B(this.B, k, q(currentTimeline, k));
        int i3 = B.d;
        if (i3 != 1 && i3 != 4 && i < i2 && i2 == size && currentWindowIndex >= B.a.getWindowCount()) {
            z = true;
        }
        if (z) {
            B = B.h(4);
        }
        this.f.c0(i, i2, this.y);
        return B;
    }

    public final void G(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.k.remove(i3);
        }
        this.y = this.y.cloneAndRemove(i, i2);
        if (this.k.isEmpty()) {
            this.A = false;
        }
    }

    public final void H(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, int i, long j, boolean z) {
        int i2;
        long j2;
        K(list, true);
        int p = p();
        long currentPosition = getCurrentPosition();
        this.f336s++;
        if (!this.k.isEmpty()) {
            G(0, this.k.size());
        }
        java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> j3 = j(0, list);
        com.google.android.exoplayer2.Timeline k = k();
        if (!k.isEmpty() && i >= k.getWindowCount()) {
            throw new com.google.android.exoplayer2.IllegalSeekPositionException(k, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            i2 = k.getFirstWindowIndex(this.r);
        } else if (i == -1) {
            i2 = p;
            j2 = currentPosition;
        } else {
            i2 = i;
            j2 = j;
        }
        com.google.android.exoplayer2.PlaybackInfo B = B(this.B, k, r(k, i2, j2));
        int i3 = B.d;
        if (i2 != -1 && i3 != 1) {
            i3 = (k.isEmpty() || i2 >= k.getWindowCount()) ? 4 : 2;
        }
        com.google.android.exoplayer2.PlaybackInfo h = B.h(i3);
        this.f.C0(j3, i2, com.google.android.exoplayer2.C.msToUs(j2), this.y);
        J(h, false, 4, 0, 1, false);
    }

    public void I(boolean z, int i, int i2) {
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        if (playbackInfo.j == z && playbackInfo.k == i) {
            return;
        }
        this.f336s++;
        com.google.android.exoplayer2.PlaybackInfo e = playbackInfo.e(z, i);
        this.f.G0(z, i);
        J(e, false, 4, 0, i2, false);
    }

    public final void J(com.google.android.exoplayer2.PlaybackInfo playbackInfo, boolean z, int i, int i2, int i3, boolean z2) {
        com.google.android.exoplayer2.MediaItem mediaItem;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo2 = this.B;
        this.B = playbackInfo;
        android.util.Pair<java.lang.Boolean, java.lang.Integer> m = m(playbackInfo, playbackInfo2, z, i, !playbackInfo2.a.equals(playbackInfo.a));
        boolean booleanValue = ((java.lang.Boolean) m.first).booleanValue();
        int intValue = ((java.lang.Integer) m.second).intValue();
        if (!booleanValue || playbackInfo.a.isEmpty()) {
            mediaItem = null;
        } else {
            mediaItem = playbackInfo.a.getWindow(playbackInfo.a.getPeriodByUid(playbackInfo.b.periodUid, this.i).windowIndex, this.window).mediaItem;
        }
        D(new com.google.android.exoplayer2.ExoPlayerImpl.PlaybackInfoUpdate(playbackInfo, playbackInfo2, this.h, this.c, z, i, i2, booleanValue, intValue, mediaItem, i3, z2));
    }

    public final void K(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, boolean z) {
        if (this.A && !z && !list.isEmpty()) {
            throw new java.lang.IllegalStateException();
        }
        int size = list.size() + (z ? 0 : this.k.size());
        for (int i = 0; i < list.size(); i++) {
            if (((com.google.android.exoplayer2.source.MediaSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(list.get(i))) instanceof com.google.android.exoplayer2.source.ads.AdsMediaSource) {
                if (size > 1) {
                    throw new java.lang.IllegalArgumentException();
                }
                this.A = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
        this.h.addIfAbsent(new com.google.android.exoplayer2.BasePlayer.ListenerHolder(eventListener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        addMediaSources(i, l(list));
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        addMediaItems(this.k.size(), list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(int i, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        addMediaSources(i, java.util.Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        addMediaSources(java.util.Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i, java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0);
        K(list, false);
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        this.f336s++;
        java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> j = j(i, list);
        com.google.android.exoplayer2.Timeline k = k();
        com.google.android.exoplayer2.PlaybackInfo B = B(this.B, k, q(currentTimeline, k));
        this.f.g(i, j, this.y);
        J(B, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        addMediaSources(this.k.size(), list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearMediaItems() {
        removeMediaItems(0, this.k.size());
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.PlayerMessage createMessage(com.google.android.exoplayer2.PlayerMessage.Target target) {
        return new com.google.android.exoplayer2.PlayerMessage(this.f, target, this.B.a, getCurrentWindowIndex(), this.g);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.f.p(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public android.os.Looper getApplicationLooper() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.AudioComponent getAudioComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        return playbackInfo.i.equals(playbackInfo.b) ? com.google.android.exoplayer2.C.usToMs(this.B.n) : getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        if (this.B.a.isEmpty()) {
            return this.E;
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        if (playbackInfo.i.windowSequenceNumber != playbackInfo.b.windowSequenceNumber) {
            return playbackInfo.a.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j = playbackInfo.n;
        if (this.B.i.isAd()) {
            com.google.android.exoplayer2.PlaybackInfo playbackInfo2 = this.B;
            com.google.android.exoplayer2.Timeline.Period periodByUid = playbackInfo2.a.getPeriodByUid(playbackInfo2.i.periodUid, this.i);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.B.i.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return E(this.B.i, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        playbackInfo.a.getPeriodByUid(playbackInfo.b.periodUid, this.i);
        com.google.android.exoplayer2.PlaybackInfo playbackInfo2 = this.B;
        return playbackInfo2.c == -9223372036854775807L ? playbackInfo2.a.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs() : this.i.getPositionInWindowMs() + com.google.android.exoplayer2.C.usToMs(this.B.c);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.B.b.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.B.b.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        if (this.B.a.isEmpty()) {
            return this.D;
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        return playbackInfo.a.getIndexOfPeriod(playbackInfo.b.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if (this.B.a.isEmpty()) {
            return this.E;
        }
        if (this.B.b.isAd()) {
            return com.google.android.exoplayer2.C.usToMs(this.B.p);
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        return E(playbackInfo.b, playbackInfo.p);
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Timeline getCurrentTimeline() {
        return this.B.a;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.source.TrackGroupArray getCurrentTrackGroups() {
        return this.B.g;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.trackselection.TrackSelectionArray getCurrentTrackSelections() {
        return this.B.h.selections;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        int p = p();
        if (p == -1) {
            return 0;
        }
        return p;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.DeviceComponent getDeviceComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.b;
        playbackInfo.a.getPeriodByUid(mediaPeriodId.periodUid, this.i);
        return com.google.android.exoplayer2.C.usToMs(this.i.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.MetadataComponent getMetadataComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        return this.z;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.B.j;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public com.google.android.exoplayer2.ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public android.os.Looper getPlaybackLooper() {
        return this.f.u();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.B.l;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.B.d;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.B.k;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ExoPlaybackException getPlayerError() {
        return this.B.e;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.b.length;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i) {
        return this.b[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.SeekParameters getSeekParameters() {
        return this.x;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return com.google.android.exoplayer2.C.usToMs(this.B.o);
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.TrackSelector getTrackSelector() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.VideoComponent getVideoComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.B.f;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return this.B.b.isAd();
    }

    public final java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> j(int i, java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder mediaSourceHolder = new com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder(list.get(i2), this.l);
            arrayList.add(mediaSourceHolder);
            this.k.add(i2 + i, new com.google.android.exoplayer2.ExoPlayerImpl.MediaSourceHolderSnapshot(mediaSourceHolder.b, mediaSourceHolder.a.getTimeline()));
        }
        this.y = this.y.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    public final com.google.android.exoplayer2.Timeline k() {
        return new com.google.android.exoplayer2.PlaylistTimeline(this.k, this.y);
    }

    public final java.util.List<com.google.android.exoplayer2.source.MediaSource> l(java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.m.createMediaSource(list.get(i)));
        }
        return arrayList;
    }

    public final android.util.Pair<java.lang.Boolean, java.lang.Integer> m(com.google.android.exoplayer2.PlaybackInfo playbackInfo, com.google.android.exoplayer2.PlaybackInfo playbackInfo2, boolean z, int i, boolean z2) {
        com.google.android.exoplayer2.Timeline timeline = playbackInfo2.a;
        com.google.android.exoplayer2.Timeline timeline2 = playbackInfo.a;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return new android.util.Pair<>(java.lang.Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return new android.util.Pair<>(java.lang.Boolean.TRUE, 3);
        }
        java.lang.Object obj = timeline.getWindow(timeline.getPeriodByUid(playbackInfo2.b.periodUid, this.i).windowIndex, this.window).uid;
        java.lang.Object obj2 = timeline2.getWindow(timeline2.getPeriodByUid(playbackInfo.b.periodUid, this.i).windowIndex, this.window).uid;
        int i3 = this.window.firstPeriodIndex;
        if (obj.equals(obj2)) {
            return (z && i == 0 && timeline2.getIndexOfPeriod(playbackInfo.b.periodUid) == i3) ? new android.util.Pair<>(java.lang.Boolean.TRUE, 0) : new android.util.Pair<>(java.lang.Boolean.FALSE, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            throw new java.lang.IllegalStateException();
        }
        return new android.util.Pair<>(java.lang.Boolean.TRUE, java.lang.Integer.valueOf(i2));
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= this.k.size() && i3 >= 0);
        com.google.android.exoplayer2.Timeline currentTimeline = getCurrentTimeline();
        this.f336s++;
        int min = java.lang.Math.min(i3, this.k.size() - (i2 - i));
        com.google.android.exoplayer2.util.Util.moveItems(this.k, i, i2, min);
        com.google.android.exoplayer2.Timeline k = k();
        com.google.android.exoplayer2.PlaybackInfo B = B(this.B, k, q(currentTimeline, k));
        this.f.U(i, i2, min, this.y);
        J(B, false, 4, 0, 1, false);
    }

    public void n() {
        this.f.o();
    }

    public void o(long j) {
        this.f.q(j);
    }

    public final int p() {
        if (this.B.a.isEmpty()) {
            return this.C;
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        return playbackInfo.a.getPeriodByUid(playbackInfo.b.periodUid, this.i).windowIndex;
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
        if (playbackInfo.d != 1) {
            return;
        }
        com.google.android.exoplayer2.PlaybackInfo f = playbackInfo.f(null);
        com.google.android.exoplayer2.PlaybackInfo h = f.h(f.a.isEmpty() ? 4 : 2);
        this.f336s++;
        this.f.X();
        J(h, false, 4, 1, 1, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        setMediaSource(mediaSource);
        prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z, boolean z2) {
        setMediaSource(mediaSource, z);
        prepare();
    }

    @androidx.annotation.Nullable
    public final android.util.Pair<java.lang.Object, java.lang.Long> q(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2) {
        long contentPosition = getContentPosition();
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            boolean z = !timeline.isEmpty() && timeline2.isEmpty();
            int p = z ? -1 : p();
            if (z) {
                contentPosition = -9223372036854775807L;
            }
            return r(timeline2, p, contentPosition);
        }
        android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(this.window, this.i, getCurrentWindowIndex(), com.google.android.exoplayer2.C.msToUs(contentPosition));
        java.lang.Object obj = ((android.util.Pair) com.google.android.exoplayer2.util.Util.castNonNull(periodPosition)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPosition;
        }
        java.lang.Object n0 = com.google.android.exoplayer2.ExoPlayerImplInternal.n0(this.window, this.i, this.q, this.r, obj, timeline, timeline2);
        if (n0 == null) {
            return r(timeline2, -1, -9223372036854775807L);
        }
        timeline2.getPeriodByUid(n0, this.i);
        int i = this.i.windowIndex;
        return r(timeline2, i, timeline2.getWindow(i, this.window).getDefaultPositionMs());
    }

    @androidx.annotation.Nullable
    public final android.util.Pair<java.lang.Object, java.lang.Long> r(com.google.android.exoplayer2.Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            this.C = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.E = j;
            this.D = 0;
            return null;
        }
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.r);
            j = timeline.getWindow(i, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPosition(this.window, this.i, i, com.google.android.exoplayer2.C.msToUs(j));
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        java.lang.String hexString = java.lang.Integer.toHexString(java.lang.System.identityHashCode(this));
        java.lang.String str = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO;
        java.lang.String registeredModules = com.google.android.exoplayer2.ExoPlayerLibraryInfo.registeredModules();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(hexString).length() + 36 + java.lang.String.valueOf(str).length() + java.lang.String.valueOf(registeredModules).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [");
        sb.append(com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY);
        sb.append("] [");
        sb.append(str);
        sb.append("] [");
        sb.append(registeredModules);
        sb.append("]");
        com.google.android.exoplayer2.util.Log.i("ExoPlayerImpl", sb.toString());
        if (!this.f.Z()) {
            C(new com.google.android.exoplayer2.f());
        }
        this.d.removeCallbacksAndMessages(null);
        com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector = this.n;
        if (analyticsCollector != null) {
            this.p.removeEventListener(analyticsCollector);
        }
        com.google.android.exoplayer2.PlaybackInfo h = this.B.h(1);
        this.B = h;
        com.google.android.exoplayer2.PlaybackInfo b = h.b(h.b);
        this.B = b;
        b.n = b.p;
        this.B.o = 0L;
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        java.util.Iterator<com.google.android.exoplayer2.BasePlayer.ListenerHolder> it = this.h.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.BasePlayer.ListenerHolder next = it.next();
            if (next.listener.equals(eventListener)) {
                next.release();
                this.h.remove(next);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        J(F(i, i2), false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void retry() {
        prepare();
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void u(com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        int i = this.f336s - playbackInfoUpdate.operationAcks;
        this.f336s = i;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.t = true;
            this.u = playbackInfoUpdate.discontinuityReason;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.v = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (i == 0) {
            com.google.android.exoplayer2.Timeline timeline = playbackInfoUpdate.playbackInfo.a;
            if (!this.B.a.isEmpty() && timeline.isEmpty()) {
                this.C = -1;
                this.E = 0L;
                this.D = 0;
            }
            if (!timeline.isEmpty()) {
                java.util.List<com.google.android.exoplayer2.Timeline> c = ((com.google.android.exoplayer2.PlaylistTimeline) timeline).c();
                com.google.android.exoplayer2.util.Assertions.checkState(c.size() == this.k.size());
                for (int i2 = 0; i2 < c.size(); i2++) {
                    this.k.get(i2).b = c.get(i2);
                }
            }
            boolean z = this.t;
            this.t = false;
            J(playbackInfoUpdate.playbackInfo, z, this.u, 1, this.v, false);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        com.google.android.exoplayer2.Timeline timeline = this.B.a;
        if (i < 0 || (!timeline.isEmpty() && i >= timeline.getWindowCount())) {
            throw new com.google.android.exoplayer2.IllegalSeekPositionException(timeline, i, j);
        }
        this.f336s++;
        if (isPlayingAd()) {
            com.google.android.exoplayer2.util.Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.e.onPlaybackInfoUpdate(new com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate(this.B));
        } else {
            com.google.android.exoplayer2.PlaybackInfo B = B(this.B.h(getPlaybackState() != 1 ? 2 : 1), timeline, r(timeline, i, j));
            this.f.p0(timeline, i, com.google.android.exoplayer2.C.msToUs(j));
            J(B, true, 1, 0, 1, true);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (this.f.z0(z)) {
                return;
            }
            C(new com.google.android.exoplayer2.d());
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list, int i, long j) {
        setMediaSources(l(list), i, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list, boolean z) {
        setMediaSources(l(list), z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        setMediaSources(java.util.Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j) {
        setMediaSources(java.util.Collections.singletonList(mediaSource), 0, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z) {
        setMediaSources(java.util.Collections.singletonList(mediaSource), z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        setMediaSources(list, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, int i, long j) {
        H(list, i, j, false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, boolean z) {
        H(list, -1, -9223372036854775807L, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        if (this.z == z) {
            return;
        }
        this.z = z;
        this.f.E0(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        I(z, 0, 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        }
        if (this.B.l.equals(playbackParameters)) {
            return;
        }
        com.google.android.exoplayer2.PlaybackInfo g = this.B.g(playbackParameters);
        this.f336s++;
        this.f.I0(playbackParameters);
        J(g, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        if (this.q != i) {
            this.q = i;
            this.f.K0(i);
            C(new com.google.android.exoplayer2.g(i));
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@androidx.annotation.Nullable com.google.android.exoplayer2.SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = com.google.android.exoplayer2.SeekParameters.DEFAULT;
        }
        if (this.x.equals(seekParameters)) {
            return;
        }
        this.x = seekParameters;
        this.f.M0(seekParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        if (this.r != z) {
            this.r = z;
            this.f.O0(z);
            C(new com.google.android.exoplayer2.e(z));
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        com.google.android.exoplayer2.Timeline k = k();
        com.google.android.exoplayer2.PlaybackInfo B = B(this.B, k, r(k, getCurrentWindowIndex(), getCurrentPosition()));
        this.f336s++;
        this.y = shuffleOrder;
        this.f.Q0(shuffleOrder);
        J(B, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z) {
        com.google.android.exoplayer2.PlaybackInfo b;
        if (z) {
            b = F(0, this.k.size()).f(null);
        } else {
            com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.B;
            b = playbackInfo.b(playbackInfo.b);
            b.n = b.p;
            b.o = 0L;
        }
        com.google.android.exoplayer2.PlaybackInfo h = b.h(1);
        this.f336s++;
        this.f.Z0();
        J(h, false, 4, 0, 1, false);
    }
}
