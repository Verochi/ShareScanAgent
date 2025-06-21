package com.google.android.exoplayer2.analytics;

/* loaded from: classes22.dex */
public class AnalyticsCollector implements com.google.android.exoplayer2.Player.EventListener, com.google.android.exoplayer2.metadata.MetadataOutput, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.video.VideoRendererEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener, com.google.android.exoplayer2.drm.DrmSessionEventListener, com.google.android.exoplayer2.video.VideoListener, com.google.android.exoplayer2.audio.AudioListener {
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.analytics.AnalyticsListener> n = new java.util.concurrent.CopyOnWriteArraySet<>();
    public final com.google.android.exoplayer2.util.Clock t;
    public final com.google.android.exoplayer2.Timeline.Period u;
    public final com.google.android.exoplayer2.Timeline.Window v;
    public final com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodQueueTracker w;
    public com.google.android.exoplayer2.Player x;
    public boolean y;

    public static final class MediaPeriodQueueTracker {
        public final com.google.android.exoplayer2.Timeline.Period a;
        public com.google.common.collect.ImmutableList<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> b = com.google.common.collect.ImmutableList.of();
        public com.google.common.collect.ImmutableMap<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, com.google.android.exoplayer2.Timeline> c = com.google.common.collect.ImmutableMap.of();

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId d;
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId e;
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId f;

        public MediaPeriodQueueTracker(com.google.android.exoplayer2.Timeline.Period period) {
            this.a = period;
        }

        @androidx.annotation.Nullable
        public static com.google.android.exoplayer2.source.MediaSource.MediaPeriodId c(com.google.android.exoplayer2.Player player, com.google.common.collect.ImmutableList<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> immutableList, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.Timeline.Period period) {
            com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            java.lang.Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period).getAdGroupIndexAfterPositionUs(com.google.android.exoplayer2.C.msToUs(player.getCurrentPosition()) - period.getPositionInWindowUs());
            for (int i = 0; i < immutableList.size(); i++) {
                com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i);
                if (i(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (i(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        public static boolean i(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, @androidx.annotation.Nullable java.lang.Object obj, boolean z, int i, int i2, int i3) {
            if (mediaPeriodId.periodUid.equals(obj)) {
                return (z && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == i2) || (!z && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i3);
            }
            return false;
        }

        public final void b(com.google.common.collect.ImmutableMap.Builder<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, com.google.android.exoplayer2.Timeline> builder, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.Timeline timeline) {
            if (mediaPeriodId == null) {
                return;
            }
            if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                builder.put(mediaPeriodId, timeline);
                return;
            }
            com.google.android.exoplayer2.Timeline timeline2 = this.c.get(mediaPeriodId);
            if (timeline2 != null) {
                builder.put(mediaPeriodId, timeline2);
            }
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId d() {
            return this.d;
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId e() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.common.collect.Iterables.getLast(this.b);
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.Timeline f(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            return this.c.get(mediaPeriodId);
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId g() {
            return this.e;
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId h() {
            return this.f;
        }

        public void j(com.google.android.exoplayer2.Player player) {
            this.d = c(player, this.b, this.e, this.a);
        }

        public void k(java.util.List<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.Player player) {
            this.b = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) list);
            if (!list.isEmpty()) {
                this.e = list.get(0);
                this.f = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.d == null) {
                this.d = c(player, this.b, this.e, this.a);
            }
            m(player.getCurrentTimeline());
        }

        public void l(com.google.android.exoplayer2.Player player) {
            this.d = c(player, this.b, this.e, this.a);
            m(player.getCurrentTimeline());
        }

        public final void m(com.google.android.exoplayer2.Timeline timeline) {
            com.google.common.collect.ImmutableMap.Builder<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, com.google.android.exoplayer2.Timeline> builder = com.google.common.collect.ImmutableMap.builder();
            if (this.b.isEmpty()) {
                b(builder, this.e, timeline);
                if (!com.google.common.base.Objects.equal(this.f, this.e)) {
                    b(builder, this.f, timeline);
                }
                if (!com.google.common.base.Objects.equal(this.d, this.e) && !com.google.common.base.Objects.equal(this.d, this.f)) {
                    b(builder, this.d, timeline);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    b(builder, this.b.get(i), timeline);
                }
                if (!this.b.contains(this.d)) {
                    b(builder, this.d, timeline);
                }
            }
            this.c = builder.build();
        }
    }

    public AnalyticsCollector(com.google.android.exoplayer2.util.Clock clock) {
        this.t = (com.google.android.exoplayer2.util.Clock) com.google.android.exoplayer2.util.Assertions.checkNotNull(clock);
        com.google.android.exoplayer2.Timeline.Period period = new com.google.android.exoplayer2.Timeline.Period();
        this.u = period;
        this.v = new com.google.android.exoplayer2.Timeline.Window();
        this.w = new com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodQueueTracker(period);
    }

    public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a() {
        return b(this.w.d());
    }

    public void addListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(analyticsListener);
        this.n.add(analyticsListener);
    }

    public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime b(@androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x);
        com.google.android.exoplayer2.Timeline f = mediaPeriodId == null ? null : this.w.f(mediaPeriodId);
        if (mediaPeriodId != null && f != null) {
            return generateEventTime(f, f.getPeriodByUid(mediaPeriodId.periodUid, this.u).windowIndex, mediaPeriodId);
        }
        int currentWindowIndex = this.x.getCurrentWindowIndex();
        com.google.android.exoplayer2.Timeline currentTimeline = this.x.getCurrentTimeline();
        if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
            currentTimeline = com.google.android.exoplayer2.Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentWindowIndex, null);
    }

    public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime c() {
        return b(this.w.e());
    }

    public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x);
        if (mediaPeriodId != null) {
            return this.w.f(mediaPeriodId) != null ? b(mediaPeriodId) : generateEventTime(com.google.android.exoplayer2.Timeline.EMPTY, i, mediaPeriodId);
        }
        com.google.android.exoplayer2.Timeline currentTimeline = this.x.getCurrentTimeline();
        if (!(i < currentTimeline.getWindowCount())) {
            currentTimeline = com.google.android.exoplayer2.Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, null);
    }

    public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime e() {
        return b(this.w.g());
    }

    public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f() {
        return b(this.w.h());
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({com.aliyun.vod.log.core.AliyunLogCommon.Product.VIDEO_PLAYER})
    public com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateEventTime(com.google.android.exoplayer2.Timeline timeline, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        long contentPosition;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.t.elapsedRealtime();
        boolean z = timeline.equals(this.x.getCurrentTimeline()) && i == this.x.getCurrentWindowIndex();
        long j = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (z && this.x.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.x.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
                j = this.x.getCurrentPosition();
            }
        } else {
            if (z) {
                contentPosition = this.x.getContentPosition();
                return new com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, contentPosition, this.x.getCurrentTimeline(), this.x.getCurrentWindowIndex(), this.w.d(), this.x.getCurrentPosition(), this.x.getTotalBufferedDuration());
            }
            if (!timeline.isEmpty()) {
                j = timeline.getWindow(i, this.v).getDefaultPositionMs();
            }
        }
        contentPosition = j;
        return new com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, contentPosition, this.x.getCurrentTimeline(), this.x.getCurrentWindowIndex(), this.w.d(), this.x.getCurrentPosition(), this.x.getTotalBufferedDuration());
    }

    public final void notifySeekStarted() {
        if (this.y) {
            return;
        }
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        this.y = true;
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onSeekStarted(a);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onAudioAttributesChanged(f, audioAttributes);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(java.lang.String str, long j, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onAudioDecoderInitialized(f, str, j2);
            next.onDecoderInitialized(f, 1, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime e = e();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onAudioDisabled(e, decoderCounters);
            next.onDecoderDisabled(e, 1, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onAudioEnabled(f, decoderCounters);
            next.onDecoderEnabled(f, 1, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onAudioInputFormatChanged(f, format);
            next.onDecoderInputFormatChanged(f, 1, format);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioPositionAdvancing(long j) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onAudioPositionAdvancing(f, j);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSessionId(int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(f, i);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioUnderrun(int i, long j, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onAudioUnderrun(f, i, j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(int i, long j, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime c = c();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onBandwidthEstimate(c, i, j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(d, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(d);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRemoved(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRemoved(d);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(d);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionAcquired(d);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.lang.Exception exc) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(d, exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionReleased(d);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int i, long j) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime e = e();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(e, i, j);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        defpackage.h32.a(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onIsLoadingChanged(boolean z) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onIsLoadingChanged(a, z);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean z) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onIsPlayingChanged(a, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onLoadCanceled(d, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onLoadCompleted(d, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(d, loadEventInfo, mediaLoadData, iOException, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onLoadStarted(d, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onLoadingChanged(boolean z) {
        defpackage.h32.d(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onMediaItemTransition(@androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem mediaItem, int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onMediaItemTransition(a, mediaItem, i);
        }
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(a, metadata);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPlayWhenReadyChanged(a, z, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackParametersChanged(a, playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackStateChanged(int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackStateChanged(a, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackSuppressionReasonChanged(int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSuppressionReasonChanged(a, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = exoPlaybackException.mediaPeriodId;
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime b = mediaPeriodId != null ? b(mediaPeriodId) : a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPlayerError(b, exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerStateChanged(boolean z, int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(a, z, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int i) {
        if (i == 1) {
            this.y = false;
        }
        this.w.j((com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x));
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(a, i);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public final void onRenderedFirstFrame() {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(@androidx.annotation.Nullable android.view.Surface surface) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onRenderedFirstFrame(f, surface);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onRepeatModeChanged(int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(a, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekProcessed() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onSeekProcessed(a);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onShuffleModeEnabledChanged(boolean z) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeChanged(a, z);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onSkipSilenceEnabledChanged(boolean z) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onSkipSilenceEnabledChanged(f, z);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int i, int i2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(f, i, i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
        this.w.l((com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x));
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(a, i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
        defpackage.h32.q(this, timeline, obj, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime a = a();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(a, trackGroupArray, trackSelectionArray);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime d = d(i, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onUpstreamDiscarded(d, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(java.lang.String str, long j, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onVideoDecoderInitialized(f, str, j2);
            next.onDecoderInitialized(f, 2, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime e = e();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onVideoDisabled(e, decoderCounters);
            next.onDecoderDisabled(e, 2, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onVideoEnabled(f, decoderCounters);
            next.onDecoderEnabled(f, 2, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoFrameProcessingOffset(long j, int i) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime e = e();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onVideoFrameProcessingOffset(e, j, i);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.AnalyticsListener next = it.next();
            next.onVideoInputFormatChanged(f, format);
            next.onDecoderInputFormatChanged(f, 2, format);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f2 = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(f2, i, i2, i3, f);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onVolumeChanged(float f) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime f2 = f();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(f2, f);
        }
    }

    public void removeListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        this.n.remove(analyticsListener);
    }

    public final void resetForNewPlaylist() {
    }

    public void setPlayer(com.google.android.exoplayer2.Player player) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.x == null || this.w.b.isEmpty());
        this.x = (com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(player);
    }

    public void updateMediaPeriodQueueInfo(java.util.List<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        this.w.k(list, mediaPeriodId, (com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x));
    }
}
