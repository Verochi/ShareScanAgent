package com.google.android.exoplayer2.analytics;

/* loaded from: classes22.dex */
public final class DefaultPlaybackSessionManager implements com.google.android.exoplayer2.analytics.PlaybackSessionManager {
    public static final com.google.common.base.Supplier<java.lang.String> DEFAULT_SESSION_ID_GENERATOR = new defpackage.rz();
    public static final java.util.Random h = new java.util.Random();
    public final com.google.android.exoplayer2.Timeline.Window a;
    public final com.google.android.exoplayer2.Timeline.Period b;
    public final java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor> c;
    public final com.google.common.base.Supplier<java.lang.String> d;
    public com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener e;
    public com.google.android.exoplayer2.Timeline f;

    @androidx.annotation.Nullable
    public java.lang.String g;

    public final class SessionDescriptor {
        public final java.lang.String a;
        public int b;
        public long c;
        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId d;
        public boolean e;
        public boolean f;

        public SessionDescriptor(java.lang.String str, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            this.a = str;
            this.b = i;
            this.c = mediaPeriodId == null ? -1L : mediaPeriodId.windowSequenceNumber;
            if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
                return;
            }
            this.d = mediaPeriodId;
        }

        public boolean i(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i == this.b;
            }
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = this.d;
            return mediaPeriodId2 == null ? !mediaPeriodId.isAd() && mediaPeriodId.windowSequenceNumber == this.c : mediaPeriodId.windowSequenceNumber == mediaPeriodId2.windowSequenceNumber && mediaPeriodId.adGroupIndex == mediaPeriodId2.adGroupIndex && mediaPeriodId.adIndexInAdGroup == mediaPeriodId2.adIndexInAdGroup;
        }

        public boolean j(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
            long j = this.c;
            if (j == -1) {
                return false;
            }
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId == null) {
                return this.b != eventTime.windowIndex;
            }
            if (mediaPeriodId.windowSequenceNumber > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
            int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.d.periodUid);
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
            if (mediaPeriodId2.windowSequenceNumber < this.d.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                return false;
            }
            if (indexOfPeriod > indexOfPeriod2) {
                return true;
            }
            if (!mediaPeriodId2.isAd()) {
                int i = eventTime.mediaPeriodId.nextAdGroupIndex;
                return i == -1 || i > this.d.adGroupIndex;
            }
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.mediaPeriodId;
            int i2 = mediaPeriodId3.adGroupIndex;
            int i3 = mediaPeriodId3.adIndexInAdGroup;
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId4 = this.d;
            int i4 = mediaPeriodId4.adGroupIndex;
            return i2 > i4 || (i2 == i4 && i3 > mediaPeriodId4.adIndexInAdGroup);
        }

        public void k(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.c == -1 && i == this.b && mediaPeriodId != null) {
                this.c = mediaPeriodId.windowSequenceNumber;
            }
        }

        public final int l(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2, int i) {
            if (i >= timeline.getWindowCount()) {
                if (i < timeline2.getWindowCount()) {
                    return i;
                }
                return -1;
            }
            timeline.getWindow(i, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this.a);
            for (int i2 = com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this.a.firstPeriodIndex; i2 <= com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this.a.lastPeriodIndex; i2++) {
                int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
                if (indexOfPeriod != -1) {
                    return timeline2.getPeriod(indexOfPeriod, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.this.b).windowIndex;
                }
            }
            return -1;
        }

        public boolean m(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2) {
            int l = l(timeline, timeline2, this.b);
            this.b = l;
            if (l == -1) {
                return false;
            }
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = this.d;
            return mediaPeriodId == null || timeline2.getIndexOfPeriod(mediaPeriodId.periodUid) != -1;
        }
    }

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    public DefaultPlaybackSessionManager(com.google.common.base.Supplier<java.lang.String> supplier) {
        this.d = supplier;
        this.a = new com.google.android.exoplayer2.Timeline.Window();
        this.b = new com.google.android.exoplayer2.Timeline.Period();
        this.c = new java.util.HashMap<>();
        this.f = com.google.android.exoplayer2.Timeline.EMPTY;
    }

    public static java.lang.String d() {
        byte[] bArr = new byte[12];
        h.nextBytes(bArr);
        return android.util.Base64.encodeToString(bArr, 10);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized boolean belongsToSession(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str) {
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor = this.c.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.k(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.i(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    public final com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor e(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor = null;
        long j = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor2 : this.c.values()) {
            sessionDescriptor2.k(i, mediaPeriodId);
            if (sessionDescriptor2.i(i, mediaPeriodId)) {
                long j2 = sessionDescriptor2.c;
                if (j2 == -1 || j2 < j) {
                    sessionDescriptor = sessionDescriptor2;
                    j = j2;
                } else if (j2 == j && ((com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor) com.google.android.exoplayer2.util.Util.castNonNull(sessionDescriptor)).d != null && sessionDescriptor2.d != null) {
                    sessionDescriptor = sessionDescriptor2;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        java.lang.String str = this.d.get();
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor3 = new com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor(str, i, mediaPeriodId);
        this.c.put(str, sessionDescriptor3);
        return sessionDescriptor3;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void finishAllSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener listener;
        this.g = null;
        java.util.Iterator<com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor> it = this.c.values().iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor next = it.next();
            it.remove();
            if (next.e && (listener = this.e) != null) {
                listener.onSessionFinished(eventTime, next.a, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized java.lang.String getSessionForMediaPeriodId(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return e(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.b).windowIndex, mediaPeriodId).a;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void setListener(com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener listener) {
        this.e = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7 A[Catch: all -> 0x010e, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x001b, B:9:0x0026, B:16:0x0030, B:19:0x0041, B:21:0x004d, B:22:0x0053, B:24:0x0057, B:26:0x005d, B:28:0x0076, B:29:0x00d1, B:31:0x00d7, B:32:0x00ed, B:34:0x00f9, B:36:0x00ff), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor;
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime2;
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor2;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.e);
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor3 = this.c.get(this.g);
        if (eventTime.mediaPeriodId != null && sessionDescriptor3 != null) {
            boolean z = false;
            if (sessionDescriptor3.c != -1 ? eventTime.mediaPeriodId.windowSequenceNumber < sessionDescriptor3.c : sessionDescriptor3.b != eventTime.windowIndex) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor e = e(eventTime.windowIndex, eventTime.mediaPeriodId);
        if (this.g == null) {
            this.g = e.a;
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null && mediaPeriodId.isAd()) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId3 = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber, mediaPeriodId2.adGroupIndex);
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor e2 = e(eventTime.windowIndex, mediaPeriodId3);
            if (!e2.e) {
                e2.e = true;
                eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.b);
                sessionDescriptor = e;
                this.e.onSessionCreated(new com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime(eventTime.realtimeMs, eventTime.timeline, eventTime.windowIndex, mediaPeriodId3, java.lang.Math.max(0L, com.google.android.exoplayer2.C.usToMs(this.b.getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex)) + this.b.getPositionInWindowMs()), eventTime.currentTimeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs), e2.a);
                if (sessionDescriptor.e) {
                    sessionDescriptor2 = sessionDescriptor;
                    sessionDescriptor2.e = true;
                    eventTime2 = eventTime;
                    this.e.onSessionCreated(eventTime2, sessionDescriptor2.a);
                } else {
                    eventTime2 = eventTime;
                    sessionDescriptor2 = sessionDescriptor;
                }
                if (sessionDescriptor2.a.equals(this.g) && !sessionDescriptor2.f) {
                    sessionDescriptor2.f = true;
                    this.e.onSessionActive(eventTime2, sessionDescriptor2.a);
                }
            }
        }
        sessionDescriptor = e;
        if (sessionDescriptor.e) {
        }
        if (sessionDescriptor2.a.equals(this.g)) {
            sessionDescriptor2.f = true;
            this.e.onSessionActive(eventTime2, sessionDescriptor2.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x00cd, TryCatch #0 {, blocks: (B:3:0x0001, B:9:0x0011, B:10:0x001b, B:12:0x0021, B:15:0x002d, B:18:0x0036, B:21:0x0044, B:25:0x004f, B:26:0x0052, B:33:0x005c, B:35:0x007b, B:38:0x0083, B:40:0x008f, B:42:0x0095, B:44:0x00a1, B:46:0x00ad), top: B:2:0x0001 }] */
    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateSessionsWithDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        boolean z;
        java.util.Iterator<com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor> it;
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor e;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.e);
        if (i != 0 && i != 3) {
            z = false;
            it = this.c.values().iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor next = it.next();
                if (next.j(eventTime)) {
                    it.remove();
                    if (next.e) {
                        boolean equals = next.a.equals(this.g);
                        boolean z2 = z && equals && next.f;
                        if (equals) {
                            this.g = null;
                        }
                        this.e.onSessionFinished(eventTime, next.a, z2);
                    }
                }
            }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor = this.c.get(this.g);
            e = e(eventTime.windowIndex, eventTime.mediaPeriodId);
            this.g = e.a;
            updateSessions(eventTime);
            mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId != null && mediaPeriodId.isAd() && (sessionDescriptor == null || sessionDescriptor.c != eventTime.mediaPeriodId.windowSequenceNumber || sessionDescriptor.d == null || sessionDescriptor.d.adGroupIndex != eventTime.mediaPeriodId.adGroupIndex || sessionDescriptor.d.adIndexInAdGroup != eventTime.mediaPeriodId.adIndexInAdGroup)) {
                com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
                this.e.onAdPlaybackStarted(eventTime, e(eventTime.windowIndex, new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber)).a, e.a);
            }
        }
        z = true;
        it = this.c.values().iterator();
        while (it.hasNext()) {
        }
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor sessionDescriptor2 = this.c.get(this.g);
        e = e(eventTime.windowIndex, eventTime.mediaPeriodId);
        this.g = e.a;
        updateSessions(eventTime);
        mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId != null) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId22 = eventTime.mediaPeriodId;
            this.e.onAdPlaybackStarted(eventTime, e(eventTime.windowIndex, new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(mediaPeriodId22.periodUid, mediaPeriodId22.windowSequenceNumber)).a, e.a);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public synchronized void updateSessionsWithTimelineChange(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.e);
        com.google.android.exoplayer2.Timeline timeline = this.f;
        this.f = eventTime.timeline;
        java.util.Iterator<com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor> it = this.c.values().iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor next = it.next();
            if (!next.m(timeline, this.f)) {
                it.remove();
                if (next.e) {
                    if (next.a.equals(this.g)) {
                        this.g = null;
                    }
                    this.e.onSessionFinished(eventTime, next.a, false);
                }
            }
        }
        updateSessionsWithDiscontinuity(eventTime, 4);
    }
}
