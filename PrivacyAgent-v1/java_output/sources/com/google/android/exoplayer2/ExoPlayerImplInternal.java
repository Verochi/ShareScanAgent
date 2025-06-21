package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class ExoPlayerImplInternal implements android.os.Handler.Callback, com.google.android.exoplayer2.source.MediaPeriod.Callback, com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener, com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener, com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener, com.google.android.exoplayer2.PlayerMessage.Sender {
    public final android.os.Looper A;
    public final com.google.android.exoplayer2.Timeline.Window B;
    public final com.google.android.exoplayer2.Timeline.Period C;
    public final long D;
    public final boolean E;
    public final com.google.android.exoplayer2.DefaultMediaClock F;
    public final java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo> G;
    public final com.google.android.exoplayer2.util.Clock H;
    public final com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener I;
    public final com.google.android.exoplayer2.MediaPeriodQueue J;
    public final com.google.android.exoplayer2.MediaSourceList K;
    public com.google.android.exoplayer2.SeekParameters L;
    public com.google.android.exoplayer2.PlaybackInfo M;
    public com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition Z;
    public long a0;
    public int b0;
    public boolean c0;
    public long d0;
    public boolean e0 = true;
    public final com.google.android.exoplayer2.Renderer[] n;
    public final com.google.android.exoplayer2.RendererCapabilities[] t;
    public final com.google.android.exoplayer2.trackselection.TrackSelector u;
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult v;
    public final com.google.android.exoplayer2.LoadControl w;
    public final com.google.android.exoplayer2.upstream.BandwidthMeter x;
    public final com.google.android.exoplayer2.util.HandlerWrapper y;
    public final android.os.HandlerThread z;

    /* renamed from: com.google.android.exoplayer2.ExoPlayerImplInternal$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.Renderer.WakeupListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.exoplayer2.Renderer.WakeupListener
        public void onSleep(long j) {
            if (j >= 2000) {
                com.google.android.exoplayer2.ExoPlayerImplInternal.this.W = true;
            }
        }

        @Override // com.google.android.exoplayer2.Renderer.WakeupListener
        public void onWakeup() {
            com.google.android.exoplayer2.ExoPlayerImplInternal.this.y.sendEmptyMessage(2);
        }
    }

    public static final class MediaSourceListUpdateMessage {
        public final java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> a;
        public final com.google.android.exoplayer2.source.ShuffleOrder b;
        public final int c;
        public final long d;

        public MediaSourceListUpdateMessage(java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> list, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, int i, long j) {
            this.a = list;
            this.b = shuffleOrder;
            this.c = i;
            this.d = j;
        }

        public /* synthetic */ MediaSourceListUpdateMessage(java.util.List list, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, int i, long j, com.google.android.exoplayer2.ExoPlayerImplInternal.AnonymousClass1 anonymousClass1) {
            this(list, shuffleOrder, i, j);
        }
    }

    public static class MoveMediaItemsMessage {
        public final int a;
        public final int b;
        public final int c;
        public final com.google.android.exoplayer2.source.ShuffleOrder d;

        public MoveMediaItemsMessage(int i, int i2, int i3, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = shuffleOrder;
        }
    }

    public static final class PendingMessageInfo implements java.lang.Comparable<com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo> {
        public final com.google.android.exoplayer2.PlayerMessage n;
        public int t;
        public long u;

        @androidx.annotation.Nullable
        public java.lang.Object v;

        public PendingMessageInfo(com.google.android.exoplayer2.PlayerMessage playerMessage) {
            this.n = playerMessage;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo) {
            java.lang.Object obj = this.v;
            if ((obj == null) != (pendingMessageInfo.v == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.t - pendingMessageInfo.t;
            return i != 0 ? i : com.google.android.exoplayer2.util.Util.compareLong(this.u, pendingMessageInfo.u);
        }

        public void b(int i, long j, java.lang.Object obj) {
            this.t = i;
            this.u = j;
            this.v = obj;
        }
    }

    public static final class PlaybackInfoUpdate {
        public boolean a;
        public int discontinuityReason;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public com.google.android.exoplayer2.PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i) {
            this.a |= i > 0;
            this.operationAcks += i;
        }

        public void setPlayWhenReadyChangeReason(int i) {
            this.a = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }

        public void setPlaybackInfo(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
            this.a |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i) {
            if (this.positionDiscontinuity && this.discontinuityReason != 4) {
                com.google.android.exoplayer2.util.Assertions.checkArgument(i == 4);
                return;
            }
            this.a = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i;
        }
    }

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class PositionUpdateForPlaylistChange {
        public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;

        public PositionUpdateForPlaylistChange(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2) {
            this.a = mediaPeriodId;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
        }
    }

    public static final class SeekPosition {
        public final com.google.android.exoplayer2.Timeline a;
        public final int b;
        public final long c;

        public SeekPosition(com.google.android.exoplayer2.Timeline timeline, int i, long j) {
            this.a = timeline;
            this.b = i;
            this.c = j;
        }
    }

    public ExoPlayerImplInternal(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int i, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, com.google.android.exoplayer2.SeekParameters seekParameters, boolean z2, android.os.Looper looper, com.google.android.exoplayer2.util.Clock clock, com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener) {
        this.I = playbackInfoUpdateListener;
        this.n = rendererArr;
        this.u = trackSelector;
        this.v = trackSelectorResult;
        this.w = loadControl;
        this.x = bandwidthMeter;
        this.T = i;
        this.U = z;
        this.L = seekParameters;
        this.P = z2;
        this.H = clock;
        this.D = loadControl.getBackBufferDurationUs();
        this.E = loadControl.retainBackBufferFromKeyframe();
        com.google.android.exoplayer2.PlaybackInfo j = com.google.android.exoplayer2.PlaybackInfo.j(trackSelectorResult);
        this.M = j;
        this.N = new com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate(j);
        this.t = new com.google.android.exoplayer2.RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.t[i2] = rendererArr[i2].getCapabilities();
        }
        this.F = new com.google.android.exoplayer2.DefaultMediaClock(this, clock);
        this.G = new java.util.ArrayList<>();
        this.B = new com.google.android.exoplayer2.Timeline.Window();
        this.C = new com.google.android.exoplayer2.Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.c0 = true;
        android.os.Handler handler = new android.os.Handler(looper);
        this.J = new com.google.android.exoplayer2.MediaPeriodQueue(analyticsCollector, handler);
        this.K = new com.google.android.exoplayer2.MediaSourceList(this, analyticsCollector, handler);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:Playback", -16);
        this.z = handlerThread;
        handlerThread.start();
        android.os.Looper looper2 = handlerThread.getLooper();
        this.A = looper2;
        this.y = clock.createHandler(looper2, this);
    }

    public static boolean F(com.google.android.exoplayer2.Renderer renderer) {
        return renderer.getState() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Boolean H() {
        return java.lang.Boolean.valueOf(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Boolean I() {
        return java.lang.Boolean.valueOf(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(com.google.android.exoplayer2.PlayerMessage playerMessage) {
        try {
            h(playerMessage);
        } catch (com.google.android.exoplayer2.ExoPlaybackException e) {
            com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new java.lang.RuntimeException(e);
        }
    }

    public static boolean X0(com.google.android.exoplayer2.PlaybackInfo playbackInfo, com.google.android.exoplayer2.Timeline.Period period, com.google.android.exoplayer2.Timeline.Window window) {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.b;
        com.google.android.exoplayer2.Timeline timeline = playbackInfo.a;
        return mediaPeriodId.isAd() || timeline.isEmpty() || timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, period).windowIndex, window).isPlaceholder;
    }

    public static void i0(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo, com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.v, period).windowIndex, window).lastPeriodIndex;
        java.lang.Object obj = timeline.getPeriod(i, period, true).uid;
        long j = period.durationUs;
        pendingMessageInfo.b(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean j0(com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo, com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2, int i, boolean z, com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period) {
        java.lang.Object obj = pendingMessageInfo.v;
        if (obj == null) {
            android.util.Pair<java.lang.Object, java.lang.Long> m0 = m0(timeline, new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition(pendingMessageInfo.n.getTimeline(), pendingMessageInfo.n.getWindowIndex(), pendingMessageInfo.n.getPositionMs() == Long.MIN_VALUE ? -9223372036854775807L : com.google.android.exoplayer2.C.msToUs(pendingMessageInfo.n.getPositionMs())), false, i, z, window, period);
            if (m0 == null) {
                return false;
            }
            pendingMessageInfo.b(timeline.getIndexOfPeriod(m0.first), ((java.lang.Long) m0.second).longValue(), m0.first);
            if (pendingMessageInfo.n.getPositionMs() == Long.MIN_VALUE) {
                i0(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.n.getPositionMs() == Long.MIN_VALUE) {
            i0(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.t = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.v, period);
        if (timeline2.getWindow(period.windowIndex, window).isPlaceholder) {
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(pendingMessageInfo.v, period).windowIndex, pendingMessageInfo.u + period.getPositionInWindowUs());
            pendingMessageInfo.b(timeline.getIndexOfPeriod(periodPosition.first), ((java.lang.Long) periodPosition.second).longValue(), periodPosition.first);
        }
        return true;
    }

    public static com.google.android.exoplayer2.ExoPlayerImplInternal.PositionUpdateForPlaylistChange l0(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.PlaybackInfo playbackInfo, @androidx.annotation.Nullable com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition, com.google.android.exoplayer2.MediaPeriodQueue mediaPeriodQueue, int i, boolean z, com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        com.google.android.exoplayer2.MediaPeriodQueue mediaPeriodQueue2;
        long j;
        int i6;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        if (timeline.isEmpty()) {
            return new com.google.android.exoplayer2.ExoPlayerImplInternal.PositionUpdateForPlaylistChange(com.google.android.exoplayer2.PlaybackInfo.k(), 0L, -9223372036854775807L, false, true);
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.b;
        java.lang.Object obj = mediaPeriodId.periodUid;
        boolean X0 = X0(playbackInfo, period, window);
        long j2 = X0 ? playbackInfo.c : playbackInfo.p;
        if (seekPosition != null) {
            i2 = -1;
            android.util.Pair<java.lang.Object, java.lang.Long> m0 = m0(timeline, seekPosition, true, i, z, window, period);
            if (m0 == null) {
                i8 = timeline.getFirstWindowIndex(z);
                z5 = false;
                z6 = true;
            } else {
                if (seekPosition.c == -9223372036854775807L) {
                    i7 = timeline.getPeriodByUid(m0.first, period).windowIndex;
                } else {
                    obj = m0.first;
                    j2 = ((java.lang.Long) m0.second).longValue();
                    i7 = -1;
                }
                z5 = playbackInfo.d == 4;
                i8 = i7;
                z6 = false;
            }
            i3 = i8;
            z4 = z5;
            z3 = z6;
        } else {
            i2 = -1;
            if (playbackInfo.a.isEmpty()) {
                i4 = timeline.getFirstWindowIndex(z);
            } else if (timeline.getIndexOfPeriod(obj) == -1) {
                java.lang.Object n0 = n0(window, period, i, z, obj, playbackInfo.a, timeline);
                if (n0 == null) {
                    i5 = timeline.getFirstWindowIndex(z);
                    z2 = true;
                } else {
                    i5 = timeline.getPeriodByUid(n0, period).windowIndex;
                    z2 = false;
                }
                i3 = i5;
                z3 = z2;
                z4 = false;
            } else {
                if (X0) {
                    if (j2 == -9223372036854775807L) {
                        i4 = timeline.getPeriodByUid(obj, period).windowIndex;
                    } else {
                        playbackInfo.a.getPeriodByUid(mediaPeriodId.periodUid, period);
                        android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(obj, period).windowIndex, j2 + period.getPositionInWindowUs());
                        obj = periodPosition.first;
                        j2 = ((java.lang.Long) periodPosition.second).longValue();
                    }
                }
                i3 = -1;
                z4 = false;
                z3 = false;
            }
            i3 = i4;
            z4 = false;
            z3 = false;
        }
        if (i3 != i2) {
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition2 = timeline.getPeriodPosition(window, period, i3, -9223372036854775807L);
            obj = periodPosition2.first;
            mediaPeriodQueue2 = mediaPeriodQueue;
            j = ((java.lang.Long) periodPosition2.second).longValue();
            j2 = -9223372036854775807L;
        } else {
            mediaPeriodQueue2 = mediaPeriodQueue;
            j = j2;
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId z7 = mediaPeriodQueue2.z(timeline, obj, j);
        if (mediaPeriodId.periodUid.equals(obj) && !mediaPeriodId.isAd() && !z7.isAd() && (z7.nextAdGroupIndex == i2 || ((i6 = mediaPeriodId.nextAdGroupIndex) != i2 && z7.adGroupIndex >= i6))) {
            z7 = mediaPeriodId;
        }
        if (z7.isAd()) {
            if (z7.equals(mediaPeriodId)) {
                j = playbackInfo.p;
            } else {
                timeline.getPeriodByUid(z7.periodUid, period);
                j = z7.adIndexInAdGroup == period.getFirstAdIndexToPlay(z7.adGroupIndex) ? period.getAdResumePositionUs() : 0L;
            }
        }
        return new com.google.android.exoplayer2.ExoPlayerImplInternal.PositionUpdateForPlaylistChange(z7, j, j2, z4, z3);
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Object, java.lang.Long> m0(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition, boolean z, int i, boolean z2, com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period) {
        android.util.Pair<java.lang.Object, java.lang.Long> periodPosition;
        java.lang.Object n0;
        com.google.android.exoplayer2.Timeline timeline2 = seekPosition.a;
        if (timeline.isEmpty()) {
            return null;
        }
        com.google.android.exoplayer2.Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            periodPosition = timeline3.getPeriodPosition(window, period, seekPosition.b, seekPosition.c);
        } catch (java.lang.IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline3)) {
            return periodPosition;
        }
        if (timeline.getIndexOfPeriod(periodPosition.first) != -1) {
            timeline3.getPeriodByUid(periodPosition.first, period);
            return timeline3.getWindow(period.windowIndex, window).isPlaceholder ? timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(periodPosition.first, period).windowIndex, seekPosition.c) : periodPosition;
        }
        if (z && (n0 = n0(window, period, i, z2, periodPosition.first, timeline3, timeline)) != null) {
            return timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(n0, period).windowIndex, -9223372036854775807L);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.lang.Object n0(com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period, int i, boolean z, java.lang.Object obj, com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i2 = indexOfPeriod;
        int i3 = -1;
        for (int i4 = 0; i4 < periodCount && i3 == -1; i4++) {
            i2 = timeline.getNextPeriodIndex(i2, period, window, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i3);
    }

    public static com.google.android.exoplayer2.Format[] r(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        int length = trackSelection != null ? trackSelection.length() : 0;
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = trackSelection.getFormat(i);
        }
        return formatArr;
    }

    public final void A(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.J.u(mediaPeriod)) {
            com.google.android.exoplayer2.MediaPeriodHolder j = this.J.j();
            j.p(this.F.getPlaybackParameters().speed, this.M.a);
            d1(j.n(), j.o());
            if (j == this.J.o()) {
                h0(j.f.b);
                l();
                com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
                this.M = C(playbackInfo.b, j.f.b, playbackInfo.c);
            }
            K();
        }
    }

    public final void A0(boolean z, @androidx.annotation.Nullable java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
        if (this.V != z) {
            this.V = z;
            if (!z) {
                for (com.google.android.exoplayer2.Renderer renderer : this.n) {
                    if (!F(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void B(com.google.android.exoplayer2.PlaybackParameters playbackParameters, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(z ? 1 : 0);
        this.M = this.M.g(playbackParameters);
        g1(playbackParameters.speed);
        for (com.google.android.exoplayer2.Renderer renderer : this.n) {
            if (renderer != null) {
                renderer.setOperatingRate(playbackParameters.speed);
            }
        }
    }

    public final void B0(com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.c != -1) {
            this.Z = new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition(new com.google.android.exoplayer2.PlaylistTimeline(mediaSourceListUpdateMessage.a, mediaSourceListUpdateMessage.b), mediaSourceListUpdateMessage.c, mediaSourceListUpdateMessage.d);
        }
        z(this.K.C(mediaSourceListUpdateMessage.a, mediaSourceListUpdateMessage.b));
    }

    @androidx.annotation.CheckResult
    public final com.google.android.exoplayer2.PlaybackInfo C(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray;
        com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult;
        this.c0 = (!this.c0 && j == this.M.p && mediaPeriodId.equals(this.M.b)) ? false : true;
        g0();
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray2 = playbackInfo.g;
        com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult2 = playbackInfo.h;
        if (this.K.s()) {
            com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
            trackGroupArray2 = o == null ? com.google.android.exoplayer2.source.TrackGroupArray.EMPTY : o.n();
            trackSelectorResult2 = o == null ? this.v : o.o();
        } else if (!mediaPeriodId.equals(this.M.b)) {
            trackGroupArray = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
            trackSelectorResult = this.v;
            return this.M.c(mediaPeriodId, j, j2, v(), trackGroupArray, trackSelectorResult);
        }
        trackSelectorResult = trackSelectorResult2;
        trackGroupArray = trackGroupArray2;
        return this.M.c(mediaPeriodId, j, j2, v(), trackGroupArray, trackSelectorResult);
    }

    public void C0(java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> list, int i, long j, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.y.obtainMessage(17, new com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceListUpdateMessage(list, shuffleOrder, i, j, null)).sendToTarget();
    }

    public final boolean D() {
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        if (!p.d) {
            return false;
        }
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.Renderer[] rendererArr = this.n;
            if (i >= rendererArr.length) {
                return true;
            }
            com.google.android.exoplayer2.Renderer renderer = rendererArr[i];
            com.google.android.exoplayer2.source.SampleStream sampleStream = p.c[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd())) {
                break;
            }
            i++;
        }
        return false;
    }

    public final void D0(boolean z) {
        if (z == this.X) {
            return;
        }
        this.X = z;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        int i = playbackInfo.d;
        if (z || i == 4 || i == 1) {
            this.M = playbackInfo.d(z);
        } else {
            this.y.sendEmptyMessage(2);
        }
    }

    public final boolean E() {
        com.google.android.exoplayer2.MediaPeriodHolder j = this.J.j();
        return (j == null || j.k() == Long.MIN_VALUE) ? false : true;
    }

    public void E0(boolean z) {
        this.y.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public final void F0(boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.P = z;
        g0();
        if (!this.Q || this.J.p() == this.J.o()) {
            return;
        }
        q0(true);
        y(false);
    }

    public final boolean G() {
        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
        long j = o.f.e;
        return o.d && (j == -9223372036854775807L || this.M.p < j || !V0());
    }

    public void G0(boolean z, int i) {
        this.y.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public final void H0(boolean z, int i, boolean z2, int i2) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.N.setPlayWhenReadyChangeReason(i2);
        this.M = this.M.e(z, i);
        this.R = false;
        if (!V0()) {
            b1();
            f1();
            return;
        }
        int i3 = this.M.d;
        if (i3 == 3) {
            Y0();
            this.y.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.y.sendEmptyMessage(2);
        }
    }

    public void I0(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.y.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public final void J0(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.F.setPlaybackParameters(playbackParameters);
        x0(this.F.getPlaybackParameters(), true);
    }

    public final void K() {
        boolean U0 = U0();
        this.S = U0;
        if (U0) {
            this.J.j().d(this.a0);
        }
        c1();
    }

    public void K0(int i) {
        this.y.obtainMessage(11, i, 0).sendToTarget();
    }

    public final void L() {
        this.N.setPlaybackInfo(this.M);
        if (this.N.a) {
            this.I.onPlaybackInfoUpdate(this.N);
            this.N = new com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate(this.M);
        }
    }

    public final void L0(int i) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.T = i;
        if (!this.J.F(this.M.a, i)) {
            q0(true);
        }
        y(false);
    }

    public final void M(long j, long j2) {
        if (this.X && this.W) {
            return;
        }
        o0(j, j2);
    }

    public void M0(com.google.android.exoplayer2.SeekParameters seekParameters) {
        this.y.obtainMessage(5, seekParameters).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0074, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0045, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo;
        com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo2;
        if (this.G.isEmpty() || this.M.b.isAd()) {
            return;
        }
        if (this.c0) {
            j--;
            this.c0 = false;
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        int indexOfPeriod = playbackInfo.a.getIndexOfPeriod(playbackInfo.b.periodUid);
        int min = java.lang.Math.min(this.b0, this.G.size());
        if (min > 0) {
            pendingMessageInfo = this.G.get(min - 1);
            while (pendingMessageInfo != null) {
                int i = pendingMessageInfo.t;
                if (i <= indexOfPeriod && (i != indexOfPeriod || pendingMessageInfo.u <= j)) {
                    break;
                }
                min--;
                if (min > 0) {
                    pendingMessageInfo = this.G.get(min - 1);
                }
            }
            if (min < this.G.size()) {
                pendingMessageInfo2 = this.G.get(min);
                while (pendingMessageInfo2 != null && pendingMessageInfo2.v != null) {
                    int i2 = pendingMessageInfo2.t;
                    if (i2 >= indexOfPeriod && (i2 != indexOfPeriod || pendingMessageInfo2.u > j)) {
                        break;
                    }
                    min++;
                    if (min < this.G.size()) {
                        pendingMessageInfo2 = this.G.get(min);
                    }
                }
                while (pendingMessageInfo2 != null && pendingMessageInfo2.v != null && pendingMessageInfo2.t == indexOfPeriod) {
                    long j3 = pendingMessageInfo2.u;
                    if (j3 <= j || j3 > j2) {
                        break;
                    }
                    try {
                        v0(pendingMessageInfo2.n);
                        if (pendingMessageInfo2.n.getDeleteAfterDelivery() || pendingMessageInfo2.n.isCanceled()) {
                            this.G.remove(min);
                        } else {
                            min++;
                        }
                        pendingMessageInfo2 = min < this.G.size() ? this.G.get(min) : null;
                    } catch (java.lang.Throwable th) {
                        if (pendingMessageInfo2.n.getDeleteAfterDelivery() || pendingMessageInfo2.n.isCanceled()) {
                            this.G.remove(min);
                        }
                        throw th;
                    }
                }
                this.b0 = min;
                return;
            }
            pendingMessageInfo2 = null;
        }
        pendingMessageInfo = null;
    }

    public final void N0(com.google.android.exoplayer2.SeekParameters seekParameters) {
        this.L = seekParameters;
    }

    public final void O() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodInfo n;
        this.J.x(this.a0);
        if (this.J.C() && (n = this.J.n(this.a0, this.M)) != null) {
            com.google.android.exoplayer2.MediaPeriodHolder g = this.J.g(this.t, this.u, this.w.getAllocator(), this.K, n, this.v);
            g.a.prepare(this, n.b);
            if (this.J.o() == g) {
                h0(g.m());
            }
            y(false);
        }
        if (!this.S) {
            K();
        } else {
            this.S = E();
            c1();
        }
    }

    public void O0(boolean z) {
        this.y.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public final void P() throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean z = false;
        while (T0()) {
            if (z) {
                L();
            }
            com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
            com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo = this.J.b().f;
            this.M = C(mediaPeriodInfo.a, mediaPeriodInfo.b, mediaPeriodInfo.c);
            this.N.setPositionDiscontinuity(o.f.f ? 0 : 3);
            g0();
            f1();
            z = true;
        }
    }

    public final void P0(boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.U = z;
        if (!this.J.G(this.M.a, z)) {
            q0(true);
        }
        y(false);
    }

    public final void Q() {
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        if (p == null) {
            return;
        }
        int i = 0;
        if (p.j() != null && !this.Q) {
            if (D()) {
                if (p.j().d || this.a0 >= p.j().m()) {
                    com.google.android.exoplayer2.trackselection.TrackSelectorResult o = p.o();
                    com.google.android.exoplayer2.MediaPeriodHolder c = this.J.c();
                    com.google.android.exoplayer2.trackselection.TrackSelectorResult o2 = c.o();
                    if (c.d && c.a.readDiscontinuity() != -9223372036854775807L) {
                        y0();
                        return;
                    }
                    for (int i2 = 0; i2 < this.n.length; i2++) {
                        boolean isRendererEnabled = o.isRendererEnabled(i2);
                        boolean isRendererEnabled2 = o2.isRendererEnabled(i2);
                        if (isRendererEnabled && !this.n[i2].isCurrentStreamFinal()) {
                            boolean z = this.t[i2].getTrackType() == 6;
                            com.google.android.exoplayer2.RendererConfiguration rendererConfiguration = o.rendererConfigurations[i2];
                            com.google.android.exoplayer2.RendererConfiguration rendererConfiguration2 = o2.rendererConfigurations[i2];
                            if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                                this.n[i2].setCurrentStreamFinal();
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!p.f.h && !this.Q) {
            return;
        }
        while (true) {
            com.google.android.exoplayer2.Renderer[] rendererArr = this.n;
            if (i >= rendererArr.length) {
                return;
            }
            com.google.android.exoplayer2.Renderer renderer = rendererArr[i];
            com.google.android.exoplayer2.source.SampleStream sampleStream = p.c[i];
            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                renderer.setCurrentStreamFinal();
            }
            i++;
        }
    }

    public void Q0(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.y.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public final void R() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        if (p == null || this.J.o() == p || p.g || !d0()) {
            return;
        }
        l();
    }

    public final void R0(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(1);
        z(this.K.D(shuffleOrder));
    }

    public final void S() throws com.google.android.exoplayer2.ExoPlaybackException {
        z(this.K.i());
    }

    public final void S0(int i) {
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        if (playbackInfo.d != i) {
            this.M = playbackInfo.h(i);
        }
    }

    public final void T(com.google.android.exoplayer2.ExoPlayerImplInternal.MoveMediaItemsMessage moveMediaItemsMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(1);
        z(this.K.v(moveMediaItemsMessage.a, moveMediaItemsMessage.b, moveMediaItemsMessage.c, moveMediaItemsMessage.d));
    }

    public final boolean T0() {
        com.google.android.exoplayer2.MediaPeriodHolder o;
        com.google.android.exoplayer2.MediaPeriodHolder j;
        return V0() && !this.Q && (o = this.J.o()) != null && (j = o.j()) != null && this.a0 >= j.m() && j.g;
    }

    public void U(int i, int i2, int i3, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.y.obtainMessage(19, new com.google.android.exoplayer2.ExoPlayerImplInternal.MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    public final boolean U0() {
        if (!E()) {
            return false;
        }
        com.google.android.exoplayer2.MediaPeriodHolder j = this.J.j();
        return this.w.shouldContinueLoading(j == this.J.o() ? j.y(this.a0) : j.y(this.a0) - j.f.b, w(j.k()), this.F.getPlaybackParameters().speed);
    }

    public final void V() {
        for (com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o(); o != null; o = o.j()) {
            for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : o.o().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onDiscontinuity();
                }
            }
        }
    }

    public final boolean V0() {
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        return playbackInfo.j && playbackInfo.k == 0;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.y.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    public final boolean W0(boolean z) {
        if (this.Y == 0) {
            return G();
        }
        if (!z) {
            return false;
        }
        if (!this.M.f) {
            return true;
        }
        com.google.android.exoplayer2.MediaPeriodHolder j = this.J.j();
        return (j.q() && j.f.h) || this.w.shouldStartPlayback(v(), this.F.getPlaybackParameters().speed, this.R);
    }

    public void X() {
        this.y.obtainMessage(0).sendToTarget();
    }

    public final void Y() {
        this.N.incrementPendingOperationAcks(1);
        f0(false, false, false, true);
        this.w.onPrepared();
        S0(this.M.a.isEmpty() ? 4 : 2);
        this.K.w(this.x.getTransferListener());
        this.y.sendEmptyMessage(2);
    }

    public final void Y0() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.R = false;
        this.F.e();
        for (com.google.android.exoplayer2.Renderer renderer : this.n) {
            if (F(renderer)) {
                renderer.start();
            }
        }
    }

    public synchronized boolean Z() {
        if (!this.O && this.z.isAlive()) {
            this.y.sendEmptyMessage(7);
            if (this.d0 > 0) {
                i1(new com.google.android.exoplayer2.y(this), this.d0);
            } else {
                h1(new com.google.android.exoplayer2.z(this));
            }
            return this.O;
        }
        return true;
    }

    public void Z0() {
        this.y.obtainMessage(6).sendToTarget();
    }

    public final void a0() {
        f0(true, false, true, false);
        this.w.onReleased();
        S0(1);
        this.z.quit();
        synchronized (this) {
            this.O = true;
            notifyAll();
        }
    }

    public final void a1(boolean z, boolean z2) {
        f0(z || !this.V, false, true, false);
        this.N.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.w.onStopped();
        S0(1);
    }

    public final void b0(int i, int i2, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(1);
        z(this.K.A(i, i2, shuffleOrder));
    }

    public final void b1() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.F.f();
        for (com.google.android.exoplayer2.Renderer renderer : this.n) {
            if (F(renderer)) {
                n(renderer);
            }
        }
    }

    public void c0(int i, int i2, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.y.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public final void c1() {
        com.google.android.exoplayer2.MediaPeriodHolder j = this.J.j();
        boolean z = this.S || (j != null && j.a.isLoading());
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        if (z != playbackInfo.f) {
            this.M = playbackInfo.a(z);
        }
    }

    public final boolean d0() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        com.google.android.exoplayer2.trackselection.TrackSelectorResult o = p.o();
        int i = 0;
        boolean z = false;
        while (true) {
            com.google.android.exoplayer2.Renderer[] rendererArr = this.n;
            if (i >= rendererArr.length) {
                return !z;
            }
            com.google.android.exoplayer2.Renderer renderer = rendererArr[i];
            if (F(renderer)) {
                boolean z2 = renderer.getStream() != p.c[i];
                if (!o.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(r(o.selections.get(i)), p.c[i], p.m(), p.l());
                    } else if (renderer.isEnded()) {
                        i(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    public final void d1(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        this.w.onTracksSelected(this.n, trackGroupArray, trackSelectorResult.selections);
    }

    public final void e0() throws com.google.android.exoplayer2.ExoPlaybackException {
        float f = this.F.getPlaybackParameters().speed;
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        boolean z = true;
        for (com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o(); o != null && o.d; o = o.j()) {
            com.google.android.exoplayer2.trackselection.TrackSelectorResult v = o.v(f, this.M.a);
            int i = 0;
            if (!v.isEquivalent(o.o())) {
                if (z) {
                    com.google.android.exoplayer2.MediaPeriodHolder o2 = this.J.o();
                    boolean y = this.J.y(o2);
                    boolean[] zArr = new boolean[this.n.length];
                    long b = o2.b(v, this.M.p, y, zArr);
                    com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
                    com.google.android.exoplayer2.PlaybackInfo C = C(playbackInfo.b, b, playbackInfo.c);
                    this.M = C;
                    if (C.d != 4 && b != C.p) {
                        this.N.setPositionDiscontinuity(4);
                        h0(b);
                    }
                    boolean[] zArr2 = new boolean[this.n.length];
                    while (true) {
                        com.google.android.exoplayer2.Renderer[] rendererArr = this.n;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        com.google.android.exoplayer2.Renderer renderer = rendererArr[i];
                        boolean F = F(renderer);
                        zArr2[i] = F;
                        com.google.android.exoplayer2.source.SampleStream sampleStream = o2.c[i];
                        if (F) {
                            if (sampleStream != renderer.getStream()) {
                                i(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.a0);
                            }
                        }
                        i++;
                    }
                    m(zArr2);
                } else {
                    this.J.y(o);
                    if (o.d) {
                        o.a(v, java.lang.Math.max(o.f.b, o.y(this.a0)), false);
                    }
                }
                y(true);
                if (this.M.d != 4) {
                    K();
                    f1();
                    this.y.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (o == p) {
                z = false;
            }
        }
    }

    public final void e1() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        if (this.M.a.isEmpty() || !this.K.s()) {
            return;
        }
        O();
        Q();
        R();
        P();
    }

    public final void f(com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.N.incrementPendingOperationAcks(1);
        com.google.android.exoplayer2.MediaSourceList mediaSourceList = this.K;
        if (i == -1) {
            i = mediaSourceList.q();
        }
        z(mediaSourceList.f(i, mediaSourceListUpdateMessage.a, mediaSourceListUpdateMessage.b));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(boolean z, boolean z2, boolean z3, boolean z4) {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        long j;
        long j2;
        boolean z5;
        this.y.removeMessages(2);
        this.R = false;
        this.F.f();
        this.a0 = 0L;
        for (com.google.android.exoplayer2.Renderer renderer : this.n) {
            try {
                i(renderer);
            } catch (com.google.android.exoplayer2.ExoPlaybackException | java.lang.RuntimeException e) {
                com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        if (z) {
            for (com.google.android.exoplayer2.Renderer renderer2 : this.n) {
                try {
                    renderer2.reset();
                } catch (java.lang.RuntimeException e2) {
                    com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.Y = 0;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo.b;
        long j3 = playbackInfo.p;
        long j4 = X0(this.M, this.C, this.B) ? this.M.c : this.M.p;
        if (z2) {
            this.Z = null;
            android.util.Pair<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, java.lang.Long> t = t(this.M.a);
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId3 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) t.first;
            long longValue = ((java.lang.Long) t.second).longValue();
            if (!mediaPeriodId3.equals(this.M.b)) {
                z5 = true;
                mediaPeriodId = mediaPeriodId3;
                j = longValue;
                j2 = -9223372036854775807L;
                this.J.f();
                this.S = false;
                com.google.android.exoplayer2.PlaybackInfo playbackInfo2 = this.M;
                this.M = new com.google.android.exoplayer2.PlaybackInfo(playbackInfo2.a, mediaPeriodId, j2, playbackInfo2.d, z4 ? null : playbackInfo2.e, false, !z5 ? com.google.android.exoplayer2.source.TrackGroupArray.EMPTY : playbackInfo2.g, !z5 ? this.v : playbackInfo2.h, mediaPeriodId, playbackInfo2.j, playbackInfo2.k, playbackInfo2.l, j, 0L, j, this.X);
                if (z3) {
                    return;
                }
                this.K.y();
                return;
            }
            mediaPeriodId = mediaPeriodId3;
            j = longValue;
            j2 = -9223372036854775807L;
        } else {
            mediaPeriodId = mediaPeriodId2;
            j = j3;
            j2 = j4;
        }
        z5 = false;
        this.J.f();
        this.S = false;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo22 = this.M;
        this.M = new com.google.android.exoplayer2.PlaybackInfo(playbackInfo22.a, mediaPeriodId, j2, playbackInfo22.d, z4 ? null : playbackInfo22.e, false, !z5 ? com.google.android.exoplayer2.source.TrackGroupArray.EMPTY : playbackInfo22.g, !z5 ? this.v : playbackInfo22.h, mediaPeriodId, playbackInfo22.j, playbackInfo22.k, playbackInfo22.l, j, 0L, j, this.X);
        if (z3) {
        }
    }

    public final void f1() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
        if (o == null) {
            return;
        }
        long readDiscontinuity = o.d ? o.a.readDiscontinuity() : -9223372036854775807L;
        if (readDiscontinuity != -9223372036854775807L) {
            h0(readDiscontinuity);
            if (readDiscontinuity != this.M.p) {
                com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
                this.M = C(playbackInfo.b, readDiscontinuity, playbackInfo.c);
                this.N.setPositionDiscontinuity(4);
            }
        } else {
            long g = this.F.g(o != this.J.p());
            this.a0 = g;
            long y = o.y(g);
            N(this.M.p, y);
            this.M.p = y;
        }
        this.M.n = this.J.j().i();
        this.M.o = v();
    }

    public void g(int i, java.util.List<com.google.android.exoplayer2.MediaSourceList.MediaSourceHolder> list, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.y.obtainMessage(18, i, 0, new com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L, null)).sendToTarget();
    }

    public final void g0() {
        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
        this.Q = o != null && o.f.g && this.P;
    }

    public final void g1(float f) {
        for (com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o(); o != null; o = o.j()) {
            for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : o.o().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    public final void h(com.google.android.exoplayer2.PlayerMessage playerMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    public final void h0(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
        if (o != null) {
            j = o.z(j);
        }
        this.a0 = j;
        this.F.c(j);
        for (com.google.android.exoplayer2.Renderer renderer : this.n) {
            if (F(renderer)) {
                renderer.resetPosition(this.a0);
            }
        }
        V();
    }

    public final synchronized void h1(com.google.common.base.Supplier<java.lang.Boolean> supplier) {
        boolean z = false;
        while (!supplier.get().booleanValue()) {
            try {
                wait();
            } catch (java.lang.InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f9  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(android.os.Message message) {
        com.google.android.exoplayer2.MediaPeriodHolder p;
        try {
            switch (message.what) {
                case 0:
                    Y();
                    break;
                case 1:
                    H0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    j();
                    break;
                case 3:
                    r0((com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition) message.obj);
                    break;
                case 4:
                    J0((com.google.android.exoplayer2.PlaybackParameters) message.obj);
                    break;
                case 5:
                    N0((com.google.android.exoplayer2.SeekParameters) message.obj);
                    break;
                case 6:
                    a1(false, true);
                    break;
                case 7:
                    a0();
                    return true;
                case 8:
                    A((com.google.android.exoplayer2.source.MediaPeriod) message.obj);
                    break;
                case 9:
                    x((com.google.android.exoplayer2.source.MediaPeriod) message.obj);
                    break;
                case 10:
                    e0();
                    break;
                case 11:
                    L0(message.arg1);
                    break;
                case 12:
                    P0(message.arg1 != 0);
                    break;
                case 13:
                    A0(message.arg1 != 0, (java.util.concurrent.atomic.AtomicBoolean) message.obj);
                    break;
                case 14:
                    u0((com.google.android.exoplayer2.PlayerMessage) message.obj);
                    break;
                case 15:
                    w0((com.google.android.exoplayer2.PlayerMessage) message.obj);
                    break;
                case 16:
                    B((com.google.android.exoplayer2.PlaybackParameters) message.obj, message.arg1 != 0);
                    break;
                case 17:
                    B0((com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    f((com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    T((com.google.android.exoplayer2.ExoPlayerImplInternal.MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    b0(message.arg1, message.arg2, (com.google.android.exoplayer2.source.ShuffleOrder) message.obj);
                    break;
                case 21:
                    R0((com.google.android.exoplayer2.source.ShuffleOrder) message.obj);
                    break;
                case 22:
                    S();
                    break;
                case 23:
                    F0(message.arg1 != 0);
                    break;
                case 24:
                    D0(message.arg1 == 1);
                    break;
                default:
                    return false;
            }
            L();
        } catch (com.google.android.exoplayer2.ExoPlaybackException e) {
            e = e;
            if (e.type == 1 && (p = this.J.p()) != null) {
                e = e.copyWithMediaPeriodId(p.f.a);
            }
            com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Playback error", e);
            a1(true, false);
            this.M = this.M.f(e);
            L();
        } catch (java.io.IOException e2) {
            com.google.android.exoplayer2.ExoPlaybackException createForSource = com.google.android.exoplayer2.ExoPlaybackException.createForSource(e2);
            com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
            if (o != null) {
                createForSource = createForSource.copyWithMediaPeriodId(o.f.a);
            }
            com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Playback error", createForSource);
            a1(false, false);
            this.M = this.M.f(createForSource);
            L();
        } catch (java.lang.OutOfMemoryError e3) {
            e = e3;
            com.google.android.exoplayer2.ExoPlaybackException createForOutOfMemory = !(e instanceof java.lang.OutOfMemoryError) ? com.google.android.exoplayer2.ExoPlaybackException.createForOutOfMemory((java.lang.OutOfMemoryError) e) : com.google.android.exoplayer2.ExoPlaybackException.createForUnexpected((java.lang.RuntimeException) e);
            com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Playback error", createForOutOfMemory);
            a1(true, false);
            this.M = this.M.f(createForOutOfMemory);
            L();
        } catch (java.lang.RuntimeException e4) {
            e = e4;
            if (!(e instanceof java.lang.OutOfMemoryError)) {
            }
            com.google.android.exoplayer2.util.Log.e("ExoPlayerImplInternal", "Playback error", createForOutOfMemory);
            a1(true, false);
            this.M = this.M.f(createForOutOfMemory);
            L();
        }
        return true;
    }

    public final void i(com.google.android.exoplayer2.Renderer renderer) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (F(renderer)) {
            this.F.a(renderer);
            n(renderer);
            renderer.disable();
            this.Y--;
        }
    }

    public final synchronized void i1(com.google.common.base.Supplier<java.lang.Boolean> supplier, long j) {
        long elapsedRealtime = this.H.elapsedRealtime() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (java.lang.InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - this.H.elapsedRealtime();
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo;
        int i2;
        long uptimeMillis = this.H.uptimeMillis();
        e1();
        int i3 = this.M.d;
        if (i3 == 1 || i3 == 4) {
            this.y.removeMessages(2);
            return;
        }
        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
        if (o == null) {
            o0(uptimeMillis, 10L);
            return;
        }
        com.google.android.exoplayer2.util.TraceUtil.beginSection("doSomeWork");
        f1();
        if (o.d) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
            o.a.discardBuffer(this.M.p - this.D, this.E);
            int i4 = 0;
            z = true;
            z2 = true;
            while (true) {
                com.google.android.exoplayer2.Renderer[] rendererArr = this.n;
                if (i4 >= rendererArr.length) {
                    break;
                }
                com.google.android.exoplayer2.Renderer renderer = rendererArr[i4];
                if (F(renderer)) {
                    renderer.render(this.a0, elapsedRealtime);
                    z = z && renderer.isEnded();
                    boolean z4 = o.c[i4] != renderer.getStream();
                    boolean z5 = z4 || (!z4 && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    z2 = z2 && z5;
                    if (!z5) {
                        renderer.maybeThrowStreamError();
                    }
                }
                i4++;
            }
        } else {
            o.a.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j = o.f.e;
        boolean z6 = z && o.d && (j == -9223372036854775807L || j <= this.M.p);
        if (z6 && this.Q) {
            this.Q = false;
            H0(false, this.M.k, false, 5);
        }
        if (z6 && o.f.h) {
            S0(4);
            b1();
        } else if (this.M.d == 2 && W0(z2)) {
            S0(3);
            if (V0()) {
                Y0();
            }
        } else if (this.M.d == 3 && (this.Y != 0 ? !z2 : !G())) {
            this.R = V0();
            i = 2;
            S0(2);
            b1();
            if (this.M.d == i) {
                int i5 = 0;
                while (true) {
                    com.google.android.exoplayer2.Renderer[] rendererArr2 = this.n;
                    if (i5 >= rendererArr2.length) {
                        break;
                    }
                    if (F(rendererArr2[i5]) && this.n[i5].getStream() == o.c[i5]) {
                        this.n[i5].maybeThrowStreamError();
                    }
                    i5++;
                }
                if (this.e0) {
                    com.google.android.exoplayer2.PlaybackInfo playbackInfo2 = this.M;
                    if (!playbackInfo2.f && playbackInfo2.o < 500000 && E()) {
                        throw new java.lang.IllegalStateException("Playback stuck buffering and not loading");
                    }
                }
            }
            z3 = this.X;
            playbackInfo = this.M;
            if (z3 != playbackInfo.m) {
                this.M = playbackInfo.d(z3);
            }
            if ((!V0() && this.M.d == 3) || (i2 = this.M.d) == 2) {
                M(uptimeMillis, 10L);
            } else if (this.Y != 0 || i2 == 4) {
                this.y.removeMessages(2);
            } else {
                o0(uptimeMillis, 1000L);
            }
            this.W = false;
            com.google.android.exoplayer2.util.TraceUtil.endSection();
        }
        i = 2;
        if (this.M.d == i) {
        }
        z3 = this.X;
        playbackInfo = this.M;
        if (z3 != playbackInfo.m) {
        }
        if (!V0()) {
        }
        if (this.Y != 0) {
        }
        this.y.removeMessages(2);
        this.W = false;
        com.google.android.exoplayer2.util.TraceUtil.endSection();
    }

    public final void k(int i, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.Renderer renderer = this.n[i];
        if (F(renderer)) {
            return;
        }
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        boolean z2 = p == this.J.o();
        com.google.android.exoplayer2.trackselection.TrackSelectorResult o = p.o();
        com.google.android.exoplayer2.RendererConfiguration rendererConfiguration = o.rendererConfigurations[i];
        com.google.android.exoplayer2.Format[] r = r(o.selections.get(i));
        boolean z3 = V0() && this.M.d == 3;
        boolean z4 = !z && z3;
        this.Y++;
        renderer.enable(rendererConfiguration, r, p.c[i], this.a0, z4, z2, p.m(), p.l());
        renderer.handleMessage(103, new com.google.android.exoplayer2.ExoPlayerImplInternal.AnonymousClass1());
        this.F.b(renderer);
        if (z3) {
            renderer.start();
        }
    }

    public final void k0(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        for (int size = this.G.size() - 1; size >= 0; size--) {
            if (!j0(this.G.get(size), timeline, timeline2, this.T, this.U, this.B, this.C)) {
                this.G.get(size).n.markAsProcessed(false);
                this.G.remove(size);
            }
        }
        java.util.Collections.sort(this.G);
    }

    public final void l() throws com.google.android.exoplayer2.ExoPlaybackException {
        m(new boolean[this.n.length]);
    }

    public final void m(boolean[] zArr) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        com.google.android.exoplayer2.trackselection.TrackSelectorResult o = p.o();
        for (int i = 0; i < this.n.length; i++) {
            if (!o.isRendererEnabled(i)) {
                this.n[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.n.length; i2++) {
            if (o.isRendererEnabled(i2)) {
                k(i2, zArr[i2]);
            }
        }
        p.g = true;
    }

    public final void n(com.google.android.exoplayer2.Renderer renderer) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    public void o() {
        this.e0 = false;
    }

    public final void o0(long j, long j2) {
        this.y.removeMessages(2);
        this.y.sendEmptyMessageAtTime(2, j + j2);
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        x0(playbackParameters, false);
    }

    @Override // com.google.android.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.y.sendEmptyMessage(22);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.y.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.y.sendEmptyMessage(10);
    }

    public void p(boolean z) {
        this.y.obtainMessage(24, z ? 1 : 0, 0).sendToTarget();
    }

    public void p0(com.google.android.exoplayer2.Timeline timeline, int i, long j) {
        this.y.obtainMessage(3, new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition(timeline, i, j)).sendToTarget();
    }

    public void q(long j) {
        this.d0 = j;
    }

    public final void q0(boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = this.J.o().f.a;
        long t0 = t0(mediaPeriodId, this.M.p, true, false);
        if (t0 != this.M.p) {
            this.M = C(mediaPeriodId, t0, this.M.c);
            if (z) {
                this.N.setPositionDiscontinuity(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r0(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition) throws com.google.android.exoplayer2.ExoPlaybackException {
        long j;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId z;
        boolean z2;
        long j2;
        long j3;
        long j4;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo;
        int i;
        this.N.incrementPendingOperationAcks(1);
        android.util.Pair<java.lang.Object, java.lang.Long> m0 = m0(this.M.a, seekPosition, true, this.T, this.U, this.B, this.C);
        if (m0 == null) {
            android.util.Pair<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, java.lang.Long> t = t(this.M.a);
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) t.first;
            long longValue = ((java.lang.Long) t.second).longValue();
            z2 = !this.M.a.isEmpty();
            z = mediaPeriodId;
            j2 = longValue;
            j = -9223372036854775807L;
        } else {
            java.lang.Object obj = m0.first;
            long longValue2 = ((java.lang.Long) m0.second).longValue();
            j = seekPosition.c == -9223372036854775807L ? -9223372036854775807L : longValue2;
            z = this.J.z(this.M.a, obj, longValue2);
            if (z.isAd()) {
                this.M.a.getPeriodByUid(z.periodUid, this.C);
                j2 = this.C.getFirstAdIndexToPlay(z.adGroupIndex) == z.adIndexInAdGroup ? this.C.getAdResumePositionUs() : 0L;
                z2 = true;
            } else {
                z2 = seekPosition.c == -9223372036854775807L;
                j2 = longValue2;
            }
        }
        try {
            if (this.M.a.isEmpty()) {
                this.Z = seekPosition;
            } else {
                if (m0 != null) {
                    if (z.equals(this.M.b)) {
                        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
                        long adjustedSeekPositionUs = (o == null || !o.d || j2 == 0) ? j2 : o.a.getAdjustedSeekPositionUs(j2, this.L);
                        long j5 = adjustedSeekPositionUs;
                        if (com.google.android.exoplayer2.C.usToMs(adjustedSeekPositionUs) == com.google.android.exoplayer2.C.usToMs(this.M.p) && ((i = (playbackInfo = this.M).d) == 2 || i == 3)) {
                            this.M = C(z, playbackInfo.p, j);
                            if (z2) {
                                this.N.setPositionDiscontinuity(2);
                                return;
                            }
                            return;
                        }
                        j3 = j5;
                    } else {
                        j3 = j2;
                    }
                    long s0 = s0(z, j3, this.M.d == 4);
                    z2 |= j2 != s0;
                    j4 = s0;
                    this.M = C(z, j4, j);
                    if (z2) {
                        return;
                    }
                    this.N.setPositionDiscontinuity(2);
                    return;
                }
                if (this.M.d != 1) {
                    S0(4);
                }
                f0(false, true, false, true);
            }
            j4 = j2;
            this.M = C(z, j4, j);
            if (z2) {
            }
        } catch (java.lang.Throwable th) {
            this.M = C(z, j2, j);
            if (z2) {
                this.N.setPositionDiscontinuity(2);
            }
            throw th;
        }
    }

    public final long s() {
        com.google.android.exoplayer2.MediaPeriodHolder p = this.J.p();
        if (p == null) {
            return 0L;
        }
        long l = p.l();
        if (!p.d) {
            return l;
        }
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.Renderer[] rendererArr = this.n;
            if (i >= rendererArr.length) {
                return l;
            }
            if (F(rendererArr[i]) && this.n[i].getStream() == p.c[i]) {
                long readingPositionUs = this.n[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l = java.lang.Math.max(readingPositionUs, l);
            }
            i++;
        }
    }

    public final long s0(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        return t0(mediaPeriodId, j, this.J.o() != this.J.p(), z);
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(com.google.android.exoplayer2.PlayerMessage playerMessage) {
        if (!this.O && this.z.isAlive()) {
            this.y.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        com.google.android.exoplayer2.util.Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public final android.util.Pair<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, java.lang.Long> t(com.google.android.exoplayer2.Timeline timeline) {
        if (timeline.isEmpty()) {
            return android.util.Pair.create(com.google.android.exoplayer2.PlaybackInfo.k(), 0L);
        }
        android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(this.B, this.C, timeline.getFirstWindowIndex(this.U), -9223372036854775807L);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId z = this.J.z(timeline, periodPosition.first, 0L);
        long longValue = ((java.lang.Long) periodPosition.second).longValue();
        if (z.isAd()) {
            timeline.getPeriodByUid(z.periodUid, this.C);
            longValue = z.adIndexInAdGroup == this.C.getFirstAdIndexToPlay(z.adGroupIndex) ? this.C.getAdResumePositionUs() : 0L;
        }
        return android.util.Pair.create(z, java.lang.Long.valueOf(longValue));
    }

    public final long t0(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
        b1();
        this.R = false;
        if (z2 || this.M.d == 3) {
            S0(2);
        }
        com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o();
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = o;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.f.a)) {
            mediaPeriodHolder = mediaPeriodHolder.j();
        }
        if (z || o != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.z(j) < 0)) {
            for (com.google.android.exoplayer2.Renderer renderer : this.n) {
                i(renderer);
            }
            if (mediaPeriodHolder != null) {
                while (this.J.o() != mediaPeriodHolder) {
                    this.J.b();
                }
                this.J.y(mediaPeriodHolder);
                mediaPeriodHolder.x(0L);
                l();
            }
        }
        if (mediaPeriodHolder != null) {
            this.J.y(mediaPeriodHolder);
            if (mediaPeriodHolder.d) {
                long j2 = mediaPeriodHolder.f.e;
                if (j2 != -9223372036854775807L && j >= j2) {
                    j = java.lang.Math.max(0L, j2 - 1);
                }
                if (mediaPeriodHolder.e) {
                    long seekToUs = mediaPeriodHolder.a.seekToUs(j);
                    mediaPeriodHolder.a.discardBuffer(seekToUs - this.D, this.E);
                    j = seekToUs;
                }
            } else {
                mediaPeriodHolder.f = mediaPeriodHolder.f.b(j);
            }
            h0(j);
            K();
        } else {
            this.J.f();
            h0(j);
        }
        y(false);
        this.y.sendEmptyMessage(2);
        return j;
    }

    public android.os.Looper u() {
        return this.A;
    }

    public final void u0(com.google.android.exoplayer2.PlayerMessage playerMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            v0(playerMessage);
            return;
        }
        if (this.M.a.isEmpty()) {
            this.G.add(new com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo(playerMessage));
            return;
        }
        com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo = new com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo(playerMessage);
        com.google.android.exoplayer2.Timeline timeline = this.M.a;
        if (!j0(pendingMessageInfo, timeline, timeline, this.T, this.U, this.B, this.C)) {
            playerMessage.markAsProcessed(false);
        } else {
            this.G.add(pendingMessageInfo);
            java.util.Collections.sort(this.G);
        }
    }

    public final long v() {
        return w(this.M.n);
    }

    public final void v0(com.google.android.exoplayer2.PlayerMessage playerMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() != this.A) {
            this.y.obtainMessage(15, playerMessage).sendToTarget();
            return;
        }
        h(playerMessage);
        int i = this.M.d;
        if (i == 3 || i == 2) {
            this.y.sendEmptyMessage(2);
        }
    }

    public final long w(long j) {
        com.google.android.exoplayer2.MediaPeriodHolder j2 = this.J.j();
        if (j2 == null) {
            return 0L;
        }
        return java.lang.Math.max(0L, j - j2.y(this.a0));
    }

    public final void w0(com.google.android.exoplayer2.PlayerMessage playerMessage) {
        android.os.Handler handler = playerMessage.getHandler();
        if (handler.getLooper().getThread().isAlive()) {
            handler.post(new com.google.android.exoplayer2.x(this, playerMessage));
        } else {
            com.google.android.exoplayer2.util.Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        }
    }

    public final void x(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        if (this.J.u(mediaPeriod)) {
            this.J.x(this.a0);
            K();
        }
    }

    public final void x0(com.google.android.exoplayer2.PlaybackParameters playbackParameters, boolean z) {
        this.y.obtainMessage(16, z ? 1 : 0, 0, playbackParameters).sendToTarget();
    }

    public final void y(boolean z) {
        com.google.android.exoplayer2.MediaPeriodHolder j = this.J.j();
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = j == null ? this.M.b : j.f.a;
        boolean z2 = !this.M.i.equals(mediaPeriodId);
        if (z2) {
            this.M = this.M.b(mediaPeriodId);
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        playbackInfo.n = j == null ? playbackInfo.p : j.i();
        this.M.o = v();
        if ((z2 || z) && j != null && j.d) {
            d1(j.n(), j.o());
        }
    }

    public final void y0() {
        for (com.google.android.exoplayer2.Renderer renderer : this.n) {
            if (renderer.getStream() != null) {
                renderer.setCurrentStreamFinal();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.exoplayer2.Timeline$Period] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.exoplayer2.Timeline] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.google.android.exoplayer2.ExoPlayerImplInternal] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.android.exoplayer2.PlaybackInfo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(com.google.android.exoplayer2.Timeline timeline) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.Timeline timeline2;
        long s0;
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.M;
        com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition = this.Z;
        com.google.android.exoplayer2.MediaPeriodQueue mediaPeriodQueue = this.J;
        int i = this.T;
        boolean z = this.U;
        com.google.android.exoplayer2.Timeline.Window window = this.B;
        ?? r15 = this.C;
        com.google.android.exoplayer2.ExoPlayerImplInternal.PositionUpdateForPlaylistChange l0 = l0(timeline, playbackInfo, seekPosition, mediaPeriodQueue, i, z, window, r15);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = l0.a;
        long j = l0.c;
        boolean z2 = l0.d;
        long j2 = l0.b;
        boolean z3 = (this.M.b.equals(mediaPeriodId) && j2 == this.M.p) ? false : true;
        try {
            if (l0.e) {
                if (this.M.d != 1) {
                    S0(4);
                }
                f0(false, false, false, true);
            }
            try {
                if (z3) {
                    timeline2 = timeline;
                    if (!timeline.isEmpty()) {
                        for (com.google.android.exoplayer2.MediaPeriodHolder o = this.J.o(); o != null; o = o.j()) {
                            if (o.f.a.equals(mediaPeriodId)) {
                                o.f = this.J.q(timeline2, o.f);
                            }
                        }
                        s0 = s0(mediaPeriodId, j2, z2);
                        if (!z3 || j != this.M.c) {
                            this.M = C(mediaPeriodId, s0, j);
                        }
                        g0();
                        k0(timeline2, this.M.a);
                        this.M = this.M.i(timeline2);
                        if (!timeline.isEmpty()) {
                            this.Z = null;
                        }
                        y(false);
                    }
                } else {
                    timeline2 = timeline;
                    if (!this.J.E(timeline, this.a0, s())) {
                        q0(false);
                    }
                }
                s0 = j2;
                if (!z3) {
                }
                this.M = C(mediaPeriodId, s0, j);
                g0();
                k0(timeline2, this.M.a);
                this.M = this.M.i(timeline2);
                if (!timeline.isEmpty()) {
                }
                y(false);
            } catch (java.lang.Throwable th) {
                th = th;
                if (z3 || j != this.M.c) {
                    this.M = C(mediaPeriodId, j2, j);
                }
                g0();
                k0(r15, this.M.a);
                this.M = this.M.i(r15);
                if (!timeline.isEmpty()) {
                    this.Z = null;
                }
                y(false);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            r15 = timeline;
        }
    }

    public synchronized boolean z0(boolean z) {
        if (!this.O && this.z.isAlive()) {
            if (z) {
                this.y.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();
            this.y.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            if (this.d0 > 0) {
                i1(new defpackage.la0(atomicBoolean), this.d0);
            } else {
                h1(new defpackage.la0(atomicBoolean));
            }
            return atomicBoolean.get();
        }
        return true;
    }
}
