package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class MediaPeriodQueue {
    public final com.google.android.exoplayer2.Timeline.Period a = new com.google.android.exoplayer2.Timeline.Period();
    public final com.google.android.exoplayer2.Timeline.Window b = new com.google.android.exoplayer2.Timeline.Window();

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.analytics.AnalyticsCollector c;
    public final android.os.Handler d;
    public long e;
    public int f;
    public boolean g;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder h;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder i;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder j;
    public int k;

    @androidx.annotation.Nullable
    public java.lang.Object l;
    public long m;

    public MediaPeriodQueue(@androidx.annotation.Nullable com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, android.os.Handler handler) {
        this.c = analyticsCollector;
        this.d = handler;
    }

    public static com.google.android.exoplayer2.source.MediaSource.MediaPeriodId A(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, long j, long j2, com.google.android.exoplayer2.Timeline.Period period) {
        timeline.getPeriodByUid(obj, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(j);
        return adGroupIndexForPositionUs == -1 ? new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, j2, period.getAdGroupIndexAfterPositionUs(j)) : new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(com.google.common.collect.ImmutableList.Builder builder, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        this.c.updateMediaPeriodQueueInfo(builder.build(), mediaPeriodId);
    }

    public final long B(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        int indexOfPeriod;
        int i = timeline.getPeriodByUid(obj, this.a).windowIndex;
        java.lang.Object obj2 = this.l;
        if (obj2 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) != -1 && timeline.getPeriod(indexOfPeriod, this.a).windowIndex == i) {
            return this.m;
        }
        for (com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.j()) {
            if (mediaPeriodHolder.b.equals(obj)) {
                return mediaPeriodHolder.f.a.windowSequenceNumber;
            }
        }
        for (com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = this.h; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.j()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(mediaPeriodHolder2.b);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.a).windowIndex == i) {
                return mediaPeriodHolder2.f.a.windowSequenceNumber;
            }
        }
        long j = this.e;
        this.e = 1 + j;
        if (this.h == null) {
            this.l = obj;
            this.m = j;
        }
        return j;
    }

    public boolean C() {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.j;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.f.h && mediaPeriodHolder.q() && this.j.f.e != -9223372036854775807L && this.k < 100);
    }

    public final boolean D(com.google.android.exoplayer2.Timeline timeline) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.h;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodHolder.b);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.a, this.b, this.f, this.g);
            while (mediaPeriodHolder.j() != null && !mediaPeriodHolder.f.f) {
                mediaPeriodHolder = mediaPeriodHolder.j();
            }
            com.google.android.exoplayer2.MediaPeriodHolder j = mediaPeriodHolder.j();
            if (indexOfPeriod == -1 || j == null || timeline.getIndexOfPeriod(j.b) != indexOfPeriod) {
                break;
            }
            mediaPeriodHolder = j;
        }
        boolean y = y(mediaPeriodHolder);
        mediaPeriodHolder.f = q(timeline, mediaPeriodHolder.f);
        return !y;
    }

    public boolean E(com.google.android.exoplayer2.Timeline timeline, long j, long j2) {
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo;
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.h;
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = null;
        while (mediaPeriodHolder != null) {
            com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f;
            if (mediaPeriodHolder2 != null) {
                com.google.android.exoplayer2.MediaPeriodInfo i = i(timeline, mediaPeriodHolder2, j);
                if (i != null && e(mediaPeriodInfo2, i)) {
                    mediaPeriodInfo = i;
                }
                return !y(mediaPeriodHolder2);
            }
            mediaPeriodInfo = q(timeline, mediaPeriodInfo2);
            mediaPeriodHolder.f = mediaPeriodInfo.a(mediaPeriodInfo2.c);
            if (!d(mediaPeriodInfo2.e, mediaPeriodInfo.e)) {
                long j3 = mediaPeriodInfo.e;
                return (y(mediaPeriodHolder) || (mediaPeriodHolder == this.i && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : mediaPeriodHolder.z(j3)) ? 1 : (j2 == ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : mediaPeriodHolder.z(j3)) ? 0 : -1)) >= 0))) ? false : true;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder.j();
        }
        return true;
    }

    public boolean F(com.google.android.exoplayer2.Timeline timeline, int i) {
        this.f = i;
        return D(timeline);
    }

    public boolean G(com.google.android.exoplayer2.Timeline timeline, boolean z) {
        this.g = z;
        return D(timeline);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder b() {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.h;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.i) {
            this.i = mediaPeriodHolder.j();
        }
        this.h.t();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = this.h;
            this.l = mediaPeriodHolder2.b;
            this.m = mediaPeriodHolder2.f.a.windowSequenceNumber;
        }
        this.h = this.h.j();
        w();
        return this.h;
    }

    public com.google.android.exoplayer2.MediaPeriodHolder c() {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.i;
        com.google.android.exoplayer2.util.Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.j() == null) ? false : true);
        this.i = this.i.j();
        w();
        return this.i;
    }

    public final boolean d(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public final boolean e(com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.b == mediaPeriodInfo2.b && mediaPeriodInfo.a.equals(mediaPeriodInfo2.a);
    }

    public void f() {
        if (this.k == 0) {
            return;
        }
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = (com.google.android.exoplayer2.MediaPeriodHolder) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.h);
        this.l = mediaPeriodHolder.b;
        this.m = mediaPeriodHolder.f.a.windowSequenceNumber;
        while (mediaPeriodHolder != null) {
            mediaPeriodHolder.t();
            mediaPeriodHolder = mediaPeriodHolder.j();
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        w();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r1 != (-9223372036854775807L)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.google.android.exoplayer2.MediaPeriodHolder g(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.MediaSourceList mediaSourceList, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        long l;
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.j;
        if (mediaPeriodHolder == null) {
            if (mediaPeriodInfo.a.isAd()) {
                l = mediaPeriodInfo.c;
            }
            l = 0;
        } else {
            l = (mediaPeriodHolder.l() + this.j.f.e) - mediaPeriodInfo.b;
        }
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = new com.google.android.exoplayer2.MediaPeriodHolder(rendererCapabilitiesArr, l, trackSelector, allocator, mediaSourceList, mediaPeriodInfo, trackSelectorResult);
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder3 = this.j;
        if (mediaPeriodHolder3 != null) {
            mediaPeriodHolder3.w(mediaPeriodHolder2);
        } else {
            this.h = mediaPeriodHolder2;
            this.i = mediaPeriodHolder2;
        }
        this.l = null;
        this.j = mediaPeriodHolder2;
        this.k++;
        w();
        return mediaPeriodHolder2;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.MediaPeriodInfo h(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
        return k(playbackInfo.a, playbackInfo.b, playbackInfo.c, playbackInfo.p);
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.MediaPeriodInfo i(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder, long j) {
        long j2;
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f;
        long l = (mediaPeriodHolder.l() + mediaPeriodInfo.e) - j;
        if (mediaPeriodInfo.f) {
            long j3 = 0;
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline.getIndexOfPeriod(mediaPeriodInfo.a.periodUid), this.a, this.b, this.f, this.g);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = timeline.getPeriod(nextPeriodIndex, this.a, true).windowIndex;
            java.lang.Object obj = this.a.uid;
            long j4 = mediaPeriodInfo.a.windowSequenceNumber;
            if (timeline.getWindow(i, this.b).firstPeriodIndex == nextPeriodIndex) {
                android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(this.b, this.a, i, -9223372036854775807L, java.lang.Math.max(0L, l));
                if (periodPosition == null) {
                    return null;
                }
                obj = periodPosition.first;
                long longValue = ((java.lang.Long) periodPosition.second).longValue();
                com.google.android.exoplayer2.MediaPeriodHolder j5 = mediaPeriodHolder.j();
                if (j5 == null || !j5.b.equals(obj)) {
                    j4 = this.e;
                    this.e = 1 + j4;
                } else {
                    j4 = j5.f.a.windowSequenceNumber;
                }
                j2 = longValue;
                j3 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return k(timeline, A(timeline, obj, j2, j4, this.a), j3, j2);
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.a;
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a);
        if (!mediaPeriodId.isAd()) {
            int adGroupIndexForPositionUs = this.a.getAdGroupIndexForPositionUs(mediaPeriodInfo.d);
            if (adGroupIndexForPositionUs == -1) {
                java.lang.Object obj2 = mediaPeriodId.periodUid;
                long j6 = mediaPeriodInfo.e;
                return m(timeline, obj2, j6, j6, mediaPeriodId.windowSequenceNumber);
            }
            int firstAdIndexToPlay = this.a.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
            if (this.a.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
                return l(timeline, mediaPeriodId.periodUid, adGroupIndexForPositionUs, firstAdIndexToPlay, mediaPeriodInfo.e, mediaPeriodId.windowSequenceNumber);
            }
            return null;
        }
        int i2 = mediaPeriodId.adGroupIndex;
        int adCountInAdGroup = this.a.getAdCountInAdGroup(i2);
        if (adCountInAdGroup == -1) {
            return null;
        }
        int nextAdIndexToPlay = this.a.getNextAdIndexToPlay(i2, mediaPeriodId.adIndexInAdGroup);
        if (nextAdIndexToPlay < adCountInAdGroup) {
            if (this.a.isAdAvailable(i2, nextAdIndexToPlay)) {
                return l(timeline, mediaPeriodId.periodUid, i2, nextAdIndexToPlay, mediaPeriodInfo.c, mediaPeriodId.windowSequenceNumber);
            }
            return null;
        }
        long j7 = mediaPeriodInfo.c;
        if (j7 == -9223372036854775807L) {
            com.google.android.exoplayer2.Timeline.Window window = this.b;
            com.google.android.exoplayer2.Timeline.Period period = this.a;
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition2 = timeline.getPeriodPosition(window, period, period.windowIndex, -9223372036854775807L, java.lang.Math.max(0L, l));
            if (periodPosition2 == null) {
                return null;
            }
            j7 = ((java.lang.Long) periodPosition2.second).longValue();
        }
        return m(timeline, mediaPeriodId.periodUid, j7, mediaPeriodInfo.c, mediaPeriodId.windowSequenceNumber);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder j() {
        return this.j;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.MediaPeriodInfo k(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a);
        if (!mediaPeriodId.isAd()) {
            return m(timeline, mediaPeriodId.periodUid, j2, j, mediaPeriodId.windowSequenceNumber);
        }
        if (this.a.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
            return l(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j, mediaPeriodId.windowSequenceNumber);
        }
        return null;
    }

    public final com.google.android.exoplayer2.MediaPeriodInfo l(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i, int i2, long j, long j2) {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, i, i2, j2);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = i2 == this.a.getFirstAdIndexToPlay(i) ? this.a.getAdResumePositionUs() : 0L;
        return new com.google.android.exoplayer2.MediaPeriodInfo(mediaPeriodId, (adDurationUs == -9223372036854775807L || adResumePositionUs < adDurationUs) ? adResumePositionUs : java.lang.Math.max(0L, adDurationUs - 1), j, -9223372036854775807L, adDurationUs, false, false, false);
    }

    public final com.google.android.exoplayer2.MediaPeriodInfo m(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, long j, long j2, long j3) {
        long j4 = j;
        timeline.getPeriodByUid(obj, this.a);
        int adGroupIndexAfterPositionUs = this.a.getAdGroupIndexAfterPositionUs(j4);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, j3, adGroupIndexAfterPositionUs);
        boolean r = r(mediaPeriodId);
        boolean t = t(timeline, mediaPeriodId);
        boolean s2 = s(timeline, mediaPeriodId, r);
        long adGroupTimeUs = adGroupIndexAfterPositionUs != -1 ? this.a.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : -9223372036854775807L;
        long j5 = (adGroupTimeUs == -9223372036854775807L || adGroupTimeUs == Long.MIN_VALUE) ? this.a.durationUs : adGroupTimeUs;
        if (j5 != -9223372036854775807L && j4 >= j5) {
            j4 = java.lang.Math.max(0L, j5 - 1);
        }
        return new com.google.android.exoplayer2.MediaPeriodInfo(mediaPeriodId, j4, j2, adGroupTimeUs, j5, r, t, s2);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodInfo n(long j, com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.j;
        return mediaPeriodHolder == null ? h(playbackInfo) : i(playbackInfo.a, mediaPeriodHolder, j);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder o() {
        return this.h;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder p() {
        return this.i;
    }

    public com.google.android.exoplayer2.MediaPeriodInfo q(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo) {
        long j;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.a;
        boolean r = r(mediaPeriodId);
        boolean t = t(timeline, mediaPeriodId);
        boolean s2 = s(timeline, mediaPeriodId, r);
        timeline.getPeriodByUid(mediaPeriodInfo.a.periodUid, this.a);
        if (mediaPeriodId.isAd()) {
            j = this.a.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else {
            j = mediaPeriodInfo.d;
            if (j == -9223372036854775807L || j == Long.MIN_VALUE) {
                j = this.a.getDurationUs();
            }
        }
        return new com.google.android.exoplayer2.MediaPeriodInfo(mediaPeriodId, mediaPeriodInfo.b, mediaPeriodInfo.c, mediaPeriodInfo.d, j, r, t, s2);
    }

    public final boolean r(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    public final boolean s(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        return !timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.a).windowIndex, this.b).isDynamic && timeline.isLastPeriod(indexOfPeriod, this.a, this.b, this.f, this.g) && z;
    }

    public final boolean t(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        if (r(mediaPeriodId)) {
            return timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.a).windowIndex, this.b).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        }
        return false;
    }

    public boolean u(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.j;
        return mediaPeriodHolder != null && mediaPeriodHolder.a == mediaPeriod;
    }

    public final void w() {
        if (this.c != null) {
            com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
            for (com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.j()) {
                builder.add((com.google.common.collect.ImmutableList.Builder) mediaPeriodHolder.f.a);
            }
            com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder2 = this.i;
            this.d.post(new com.google.android.exoplayer2.a0(this, builder, mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.f.a));
        }
    }

    public void x(long j) {
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder = this.j;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.s(j);
        }
    }

    public boolean y(com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder) {
        boolean z = false;
        com.google.android.exoplayer2.util.Assertions.checkState(mediaPeriodHolder != null);
        if (mediaPeriodHolder.equals(this.j)) {
            return false;
        }
        this.j = mediaPeriodHolder;
        while (mediaPeriodHolder.j() != null) {
            mediaPeriodHolder = mediaPeriodHolder.j();
            if (mediaPeriodHolder == this.i) {
                this.i = this.h;
                z = true;
            }
            mediaPeriodHolder.t();
            this.k--;
        }
        this.j.w(null);
        w();
        return z;
    }

    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId z(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, long j) {
        return A(timeline, obj, j, B(timeline, obj), this.a);
    }
}
