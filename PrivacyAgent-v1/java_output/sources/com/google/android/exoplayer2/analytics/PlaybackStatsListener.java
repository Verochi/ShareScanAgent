package com.google.android.exoplayer2.analytics;

/* loaded from: classes22.dex */
public final class PlaybackStatsListener implements com.google.android.exoplayer2.analytics.AnalyticsListener, com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener {
    public final com.google.android.exoplayer2.analytics.PlaybackSessionManager a;
    public final java.util.Map<java.lang.String, com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker> b;
    public final java.util.Map<java.lang.String, com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime> c;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.analytics.PlaybackStatsListener.Callback d;
    public final boolean e;
    public final com.google.android.exoplayer2.Timeline.Period f;
    public com.google.android.exoplayer2.analytics.PlaybackStats g;

    @androidx.annotation.Nullable
    public java.lang.String h;

    @androidx.annotation.Nullable
    public java.lang.String i;
    public boolean j;
    public int k;
    public boolean l;
    public float m;
    public boolean n;

    public interface Callback {
        void onPlaybackStatsReady(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.analytics.PlaybackStats playbackStats);
    }

    public static final class PlaybackStatsTracker {
        public long A;
        public long B;
        public long C;
        public long D;
        public long E;
        public int F;
        public int G;
        public int H;
        public long I;
        public boolean J;
        public boolean K;
        public boolean L;
        public boolean M;
        public boolean N;
        public int O;
        public boolean P;
        public boolean Q;
        public boolean R;
        public long S;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.Format T;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.Format U;
        public long V;
        public long W;
        public float X;
        public final boolean a;
        public final long[] b = new long[16];
        public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState> c;
        public final java.util.List<long[]> d;
        public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat> e;
        public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat> f;
        public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException> g;
        public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException> h;
        public final boolean i;
        public long j;
        public boolean k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public long r;

        /* renamed from: s, reason: collision with root package name */
        public int f341s;
        public long t;
        public long u;
        public long v;
        public long w;
        public long x;
        public long y;
        public long z;

        public PlaybackStatsTracker(boolean z, com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
            this.a = z;
            this.c = z ? new java.util.ArrayList<>() : java.util.Collections.emptyList();
            this.d = z ? new java.util.ArrayList<>() : java.util.Collections.emptyList();
            this.e = z ? new java.util.ArrayList<>() : java.util.Collections.emptyList();
            this.f = z ? new java.util.ArrayList<>() : java.util.Collections.emptyList();
            this.g = z ? new java.util.ArrayList<>() : java.util.Collections.emptyList();
            this.h = z ? new java.util.ArrayList<>() : java.util.Collections.emptyList();
            boolean z2 = false;
            this.H = 0;
            this.I = eventTime.realtimeMs;
            this.O = 1;
            this.j = -9223372036854775807L;
            this.r = -9223372036854775807L;
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                z2 = true;
            }
            this.i = z2;
            this.u = -1L;
            this.t = -1L;
            this.f341s = -1;
            this.X = 1.0f;
        }

        public static boolean c(int i, int i2) {
            return ((i != 1 && i != 2 && i != 14) || i2 == 1 || i2 == 2 || i2 == 14 || i2 == 3 || i2 == 4 || i2 == 9 || i2 == 11) ? false : true;
        }

        public static boolean d(int i) {
            return i == 4 || i == 7;
        }

        public static boolean e(int i) {
            return i == 3 || i == 4 || i == 9;
        }

        public static boolean f(int i) {
            return i == 6 || i == 7 || i == 10;
        }

        public void A(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, boolean z) {
            this.O = i;
            if (i != 1) {
                this.Q = false;
            }
            if (i != 2) {
                this.J = false;
            }
            if (i == 1 || i == 4) {
                this.L = false;
            }
            l(eventTime, z);
        }

        public void B(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
            if (z && this.O == 1) {
                this.J = false;
            }
            this.L = false;
            l(eventTime, true);
        }

        public void C(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
            this.J = true;
            l(eventTime, z);
        }

        public void D(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
            boolean z = false;
            boolean z2 = false;
            for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : trackSelectionArray.getAll()) {
                if (trackSelection != null && trackSelection.length() > 0) {
                    int trackType = com.google.android.exoplayer2.util.MimeTypes.getTrackType(trackSelection.getFormat(0).sampleMimeType);
                    if (trackType == 2) {
                        z = true;
                    } else if (trackType == 1) {
                        z2 = true;
                    }
                }
            }
            if (!z) {
                m(eventTime, null);
            }
            if (z2) {
                return;
            }
            i(eventTime, null);
        }

        public void E(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, int i2) {
            com.google.android.exoplayer2.Format format = this.T;
            if (format == null || format.height != -1) {
                return;
            }
            m(eventTime, format.buildUpon().setWidth(i).setHeight(i2).build());
        }

        public final int F() {
            if (this.M) {
                return this.H == 11 ? 11 : 15;
            }
            if (this.J && this.K) {
                return 5;
            }
            if (this.Q) {
                return 13;
            }
            if (!this.K) {
                return this.R ? 1 : 0;
            }
            if (this.L) {
                return 14;
            }
            int i = this.O;
            if (i == 4) {
                return 11;
            }
            if (i != 2) {
                if (i == 3) {
                    if (this.N) {
                        return this.P ? 9 : 3;
                    }
                    return 4;
                }
                if (i != 1 || this.H == 0) {
                    return this.H;
                }
                return 12;
            }
            int i2 = this.H;
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 14) {
                return 2;
            }
            if (this.N) {
                return this.P ? 10 : 6;
            }
            return 7;
        }

        public com.google.android.exoplayer2.analytics.PlaybackStats a(boolean z) {
            long[] jArr;
            java.util.List<long[]> list;
            long[] jArr2 = this.b;
            java.util.List<long[]> list2 = this.d;
            if (z) {
                jArr = jArr2;
                list = list2;
            } else {
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                long[] copyOf = java.util.Arrays.copyOf(this.b, 16);
                long max = java.lang.Math.max(0L, elapsedRealtime - this.I);
                int i = this.H;
                copyOf[i] = copyOf[i] + max;
                j(elapsedRealtime);
                h(elapsedRealtime);
                g(elapsedRealtime);
                java.util.ArrayList arrayList = new java.util.ArrayList(this.d);
                if (this.a && this.H == 3) {
                    arrayList.add(b(elapsedRealtime));
                }
                jArr = copyOf;
                list = arrayList;
            }
            int i2 = (this.m || !this.k) ? 1 : 0;
            long j = i2 != 0 ? -9223372036854775807L : jArr[2];
            int i3 = jArr[1] > 0 ? 1 : 0;
            java.util.List arrayList2 = z ? this.e : new java.util.ArrayList(this.e);
            java.util.List arrayList3 = z ? this.f : new java.util.ArrayList(this.f);
            java.util.List arrayList4 = z ? this.c : new java.util.ArrayList(this.c);
            long j2 = this.j;
            boolean z2 = this.K;
            int i4 = !this.k ? 1 : 0;
            boolean z3 = this.l;
            int i5 = i2 ^ 1;
            int i6 = this.n;
            int i7 = this.o;
            int i8 = this.p;
            int i9 = this.q;
            long j3 = this.r;
            boolean z4 = this.i;
            long[] jArr3 = jArr;
            long j4 = this.v;
            long j5 = this.w;
            long j6 = this.x;
            long j7 = this.y;
            long j8 = this.z;
            long j9 = this.A;
            int i10 = this.f341s;
            int i11 = i10 == -1 ? 0 : 1;
            long j10 = this.t;
            int i12 = j10 == -1 ? 0 : 1;
            long j11 = this.u;
            int i13 = j11 == -1 ? 0 : 1;
            long j12 = this.B;
            long j13 = this.C;
            long j14 = this.D;
            long j15 = this.E;
            int i14 = this.F;
            return new com.google.android.exoplayer2.analytics.PlaybackStats(1, jArr3, arrayList4, list, j2, z2 ? 1 : 0, i4, z3 ? 1 : 0, i3, j, i5, i6, i7, i8, i9, j3, z4 ? 1 : 0, arrayList2, arrayList3, j4, j5, j6, j7, j8, j9, i11, i12, i10, j10, i13, j11, j12, j13, j14, j15, i14 > 0 ? 1 : 0, i14, this.G, this.g, this.h);
        }

        public final long[] b(long j) {
            java.util.List<long[]> list = this.d;
            return new long[]{j, list.get(list.size() - 1)[1] + ((long) ((j - r0[0]) * this.X))};
        }

        public final void g(long j) {
            com.google.android.exoplayer2.Format format;
            int i;
            if (this.H == 3 && (format = this.U) != null && (i = format.bitrate) != -1) {
                long j2 = (long) ((j - this.W) * this.X);
                this.z += j2;
                this.A += j2 * i;
            }
            this.W = j;
        }

        public final void h(long j) {
            com.google.android.exoplayer2.Format format;
            if (this.H == 3 && (format = this.T) != null) {
                long j2 = (long) ((j - this.V) * this.X);
                int i = format.height;
                if (i != -1) {
                    this.v += j2;
                    this.w += i * j2;
                }
                int i2 = format.bitrate;
                if (i2 != -1) {
                    this.x += j2;
                    this.y += j2 * i2;
                }
            }
            this.V = j;
        }

        public final void i(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format) {
            int i;
            if (com.google.android.exoplayer2.util.Util.areEqual(this.U, format)) {
                return;
            }
            g(eventTime.realtimeMs);
            if (format != null && this.u == -1 && (i = format.bitrate) != -1) {
                this.u = i;
            }
            this.U = format;
            if (this.a) {
                this.f.add(new com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat(eventTime, format));
            }
        }

        public final void j(long j) {
            if (f(this.H)) {
                long j2 = j - this.S;
                long j3 = this.r;
                if (j3 == -9223372036854775807L || j2 > j3) {
                    this.r = j2;
                }
            }
        }

        public final void k(long j, long j2) {
            if (this.a) {
                if (this.H != 3) {
                    if (j2 == -9223372036854775807L) {
                        return;
                    }
                    if (!this.d.isEmpty()) {
                        java.util.List<long[]> list = this.d;
                        long j3 = list.get(list.size() - 1)[1];
                        if (j3 != j2) {
                            this.d.add(new long[]{j, j3});
                        }
                    }
                }
                this.d.add(j2 == -9223372036854775807L ? b(j) : new long[]{j, j2});
            }
        }

        public final void l(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
            int F = F();
            if (F == this.H) {
                return;
            }
            com.google.android.exoplayer2.util.Assertions.checkArgument(eventTime.realtimeMs >= this.I);
            long j = eventTime.realtimeMs;
            long j2 = j - this.I;
            long[] jArr = this.b;
            int i = this.H;
            jArr[i] = jArr[i] + j2;
            if (this.j == -9223372036854775807L) {
                this.j = j;
            }
            this.m |= c(i, F);
            this.k |= e(F);
            this.l |= F == 11;
            if (!d(this.H) && d(F)) {
                this.n++;
            }
            if (F == 5) {
                this.p++;
            }
            if (!f(this.H) && f(F)) {
                this.q++;
                this.S = eventTime.realtimeMs;
            }
            if (f(this.H) && this.H != 7 && F == 7) {
                this.o++;
            }
            k(eventTime.realtimeMs, z ? eventTime.eventPlaybackPositionMs : -9223372036854775807L);
            j(eventTime.realtimeMs);
            h(eventTime.realtimeMs);
            g(eventTime.realtimeMs);
            this.H = F;
            this.I = eventTime.realtimeMs;
            if (this.a) {
                this.c.add(new com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState(eventTime, F));
            }
        }

        public final void m(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format) {
            int i;
            int i2;
            if (com.google.android.exoplayer2.util.Util.areEqual(this.T, format)) {
                return;
            }
            h(eventTime.realtimeMs);
            if (format != null) {
                if (this.f341s == -1 && (i2 = format.height) != -1) {
                    this.f341s = i2;
                }
                if (this.t == -1 && (i = format.bitrate) != -1) {
                    this.t = i;
                }
            }
            this.T = format;
            if (this.a) {
                this.e.add(new com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat(eventTime, format));
            }
        }

        public void n() {
            this.E++;
        }

        public void o(long j, long j2) {
            this.B += j;
            this.C += j2;
        }

        public void p(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            int i = mediaLoadData.trackType;
            if (i == 2 || i == 0) {
                m(eventTime, mediaLoadData.trackFormat);
            } else if (i == 1) {
                i(eventTime, mediaLoadData.trackFormat);
            }
        }

        public void q(int i) {
            this.D += i;
        }

        public void r(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
            this.F++;
            if (this.a) {
                this.g.add(new com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException(eventTime, exc));
            }
            this.Q = true;
            this.L = false;
            this.J = false;
            l(eventTime, true);
        }

        public void s(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
            this.M = true;
            l(eventTime, false);
        }

        public void t(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
            this.K = true;
            l(eventTime, true);
        }

        public void u(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
            this.L = true;
            this.J = false;
            l(eventTime, true);
        }

        public void v(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z, boolean z2) {
            this.P = z;
            l(eventTime, z2);
        }

        public void w(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
            this.R = true;
            l(eventTime, true);
        }

        public void x(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
            this.G++;
            if (this.a) {
                this.h.add(new com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException(eventTime, exc));
            }
        }

        public void y(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z, boolean z2) {
            this.N = z;
            l(eventTime, z2);
        }

        public void z(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, float f) {
            k(eventTime.realtimeMs, eventTime.eventPlaybackPositionMs);
            h(eventTime.realtimeMs);
            g(eventTime.realtimeMs);
            this.X = f;
        }
    }

    public PlaybackStatsListener(boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.analytics.PlaybackStatsListener.Callback callback) {
        this.d = callback;
        this.e = z;
        com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager defaultPlaybackSessionManager = new com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager();
        this.a = defaultPlaybackSessionManager;
        this.b = new java.util.HashMap();
        this.c = new java.util.HashMap();
        this.g = com.google.android.exoplayer2.analytics.PlaybackStats.EMPTY;
        this.j = false;
        this.k = 1;
        this.m = 1.0f;
        this.f = new com.google.android.exoplayer2.Timeline.Period();
        defaultPlaybackSessionManager.setListener(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r2.k == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        boolean z = eventTime.timeline.isEmpty();
        if (z) {
            return;
        }
        this.a.updateSessions(eventTime);
    }

    public void finishAllSessions() {
        com.google.android.exoplayer2.analytics.PlaybackSessionManager playbackSessionManager = this.a;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.google.android.exoplayer2.Timeline timeline = com.google.android.exoplayer2.Timeline.EMPTY;
        playbackSessionManager.finishAllSessions(new com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime(elapsedRealtime, timeline, 0, null, 0L, timeline, 0, null, 0L, 0L));
    }

    public com.google.android.exoplayer2.analytics.PlaybackStats getCombinedPlaybackStats() {
        int i = 1;
        com.google.android.exoplayer2.analytics.PlaybackStats[] playbackStatsArr = new com.google.android.exoplayer2.analytics.PlaybackStats[this.b.size() + 1];
        playbackStatsArr[0] = this.g;
        java.util.Iterator<com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker> it = this.b.values().iterator();
        while (it.hasNext()) {
            playbackStatsArr[i] = it.next().a(false);
            i++;
        }
        return com.google.android.exoplayer2.analytics.PlaybackStats.merge(playbackStatsArr);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.analytics.PlaybackStats getPlaybackStats() {
        com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker playbackStatsTracker;
        java.lang.String str = this.i;
        if (str != null) {
            playbackStatsTracker = this.b.get(str);
        } else {
            java.lang.String str2 = this.h;
            playbackStatsTracker = str2 != null ? this.b.get(str2) : null;
        }
        if (playbackStatsTracker == null) {
            return null;
        }
        return playbackStatsTracker.a(false);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onAdPlaybackStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.util.Assertions.checkState(((com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(eventTime.mediaPeriodId)).isAd());
        long adGroupTimeUs = eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.f).getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex);
        long positionInWindowUs = adGroupTimeUs != Long.MIN_VALUE ? this.f.getPositionInWindowUs() + adGroupTimeUs : Long.MIN_VALUE;
        long j = eventTime.realtimeMs;
        com.google.android.exoplayer2.Timeline timeline = eventTime.timeline;
        int i = eventTime.windowIndex;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        ((com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b.get(str))).u(new com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime(j, timeline, i, new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(mediaPeriodId.periodUid, mediaPeriodId.windowSequenceNumber, mediaPeriodId.adGroupIndex), com.google.android.exoplayer2.C.usToMs(positionInWindowUs), eventTime.timeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioAttributesChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        defpackage.f9.a(this, eventTime, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, long j) {
        defpackage.f9.b(this, eventTime, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.c(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.d(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.Format format) {
        defpackage.f9.e(this, eventTime, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioPositionAdvancing(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, long j) {
        defpackage.f9.f(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioSessionId(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        defpackage.f9.g(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).n();
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).o(i, j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.j(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.k(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, java.lang.String str, long j) {
        defpackage.f9.l(this, eventTime, i, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, com.google.android.exoplayer2.Format format) {
        defpackage.f9.m(this, eventTime, i, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).p(eventTime, mediaLoadData);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysLoaded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.o(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRemoved(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.p(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRestored(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.q(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionAcquired(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.r(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).x(eventTime, exc);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionReleased(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.t(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, long j) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).q(i);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        defpackage.f9.v(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsPlayingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        defpackage.f9.w(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCanceled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.f9.x(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCompleted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.f9.y(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).x(eventTime, iOException);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).w(eventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        defpackage.f9.B(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.MediaItem mediaItem, int i) {
        defpackage.f9.C(this, eventTime, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMetadata(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.metadata.Metadata metadata) {
        defpackage.f9.D(this, eventTime, metadata);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z, int i) {
        this.j = z;
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            this.b.get(str).y(eventTime, z, this.a.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.m = playbackParameters.speed;
        a(eventTime);
        java.util.Iterator<com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().z(eventTime, this.m);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        this.k = i;
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            this.b.get(str).A(eventTime, this.k, this.a.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        this.l = i != 0;
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            this.b.get(str).v(eventTime, this.l, this.a.belongsToSession(eventTime, str));
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).r(eventTime, exoPlaybackException);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z, int i) {
        defpackage.f9.J(this, eventTime, z, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        if (!(eventTime.timeline.isEmpty() && this.k == 1)) {
            this.a.updateSessionsWithDiscontinuity(eventTime, i);
        }
        if (i == 1) {
            this.n = false;
        }
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).B(eventTime, i == 1);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, android.view.Surface surface) {
        defpackage.f9.L(this, eventTime, surface);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRepeatModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        defpackage.f9.M(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekProcessed(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.N(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            this.b.get(str).C(eventTime, this.a.belongsToSession(eventTime, str));
        }
        this.n = true;
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionActive(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str) {
        ((com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b.get(str))).t(eventTime);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
        if (mediaPeriodId == null || !mediaPeriodId.isAd()) {
            this.h = str;
        } else {
            this.i = str;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionCreated(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str) {
        com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker playbackStatsTracker = new com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker(this.e, eventTime);
        if (this.n) {
            playbackStatsTracker.C(eventTime, true);
        }
        playbackStatsTracker.A(eventTime, this.k, true);
        playbackStatsTracker.y(eventTime, this.j, true);
        playbackStatsTracker.v(eventTime, this.l, true);
        playbackStatsTracker.z(eventTime, this.m);
        this.b.put(str, playbackStatsTracker);
        this.c.put(str, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.PlaybackSessionManager.Listener
    public void onSessionFinished(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, boolean z) {
        if (str.equals(this.i)) {
            this.i = null;
        } else if (str.equals(this.h)) {
            this.h = null;
        }
        com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker playbackStatsTracker = (com.google.android.exoplayer2.analytics.PlaybackStatsListener.PlaybackStatsTracker) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b.remove(str));
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime2 = (com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c.remove(str));
        if (z) {
            playbackStatsTracker.A(eventTime, 4, false);
        }
        playbackStatsTracker.s(eventTime);
        com.google.android.exoplayer2.analytics.PlaybackStats a = playbackStatsTracker.a(true);
        this.g = com.google.android.exoplayer2.analytics.PlaybackStats.merge(this.g, a);
        com.google.android.exoplayer2.analytics.PlaybackStatsListener.Callback callback = this.d;
        if (callback != null) {
            callback.onPlaybackStatsReady(eventTime2, a);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onShuffleModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        defpackage.f9.P(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSkipSilenceEnabledChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        defpackage.f9.Q(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSurfaceSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, int i2) {
        defpackage.f9.R(this, eventTime, i, i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        this.a.updateSessionsWithTimelineChange(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).B(eventTime, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).D(eventTime, trackSelectionArray);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onUpstreamDiscarded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.f9.U(this, eventTime, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, long j) {
        defpackage.f9.V(this, eventTime, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.W(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.X(this, eventTime, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoFrameProcessingOffset(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, long j, int i) {
        defpackage.f9.Y(this, eventTime, j, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.Format format) {
        defpackage.f9.Z(this, eventTime, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        a(eventTime);
        for (java.lang.String str : this.b.keySet()) {
            if (this.a.belongsToSession(eventTime, str)) {
                this.b.get(str).E(eventTime, i, i2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVolumeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, float f) {
        defpackage.f9.b0(this, eventTime, f);
    }
}
