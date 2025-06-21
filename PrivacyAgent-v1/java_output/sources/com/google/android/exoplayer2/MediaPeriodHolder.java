package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class MediaPeriodHolder {
    public final com.google.android.exoplayer2.source.MediaPeriod a;
    public final java.lang.Object b;
    public final com.google.android.exoplayer2.source.SampleStream[] c;
    public boolean d;
    public boolean e;
    public com.google.android.exoplayer2.MediaPeriodInfo f;
    public boolean g;
    public final boolean[] h;
    public final com.google.android.exoplayer2.RendererCapabilities[] i;
    public final com.google.android.exoplayer2.trackselection.TrackSelector j;
    public final com.google.android.exoplayer2.MediaSourceList k;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder l;
    public com.google.android.exoplayer2.source.TrackGroupArray m;
    public com.google.android.exoplayer2.trackselection.TrackSelectorResult n;
    public long o;

    public MediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, long j, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.MediaSourceList mediaSourceList, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        this.i = rendererCapabilitiesArr;
        this.o = j;
        this.j = trackSelector;
        this.k = mediaSourceList;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.a;
        this.b = mediaPeriodId.periodUid;
        this.f = mediaPeriodInfo;
        this.m = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
        this.n = trackSelectorResult;
        this.c = new com.google.android.exoplayer2.source.SampleStream[rendererCapabilitiesArr.length];
        this.h = new boolean[rendererCapabilitiesArr.length];
        this.a = e(mediaPeriodId, mediaSourceList, allocator, mediaPeriodInfo.b, mediaPeriodInfo.d);
    }

    public static com.google.android.exoplayer2.source.MediaPeriod e(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.MediaSourceList mediaSourceList, com.google.android.exoplayer2.upstream.Allocator allocator, long j, long j2) {
        com.google.android.exoplayer2.source.MediaPeriod h = mediaSourceList.h(mediaPeriodId, allocator, j);
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? h : new com.google.android.exoplayer2.source.ClippingMediaPeriod(h, true, 0L, j2);
    }

    public static void u(long j, com.google.android.exoplayer2.MediaSourceList mediaSourceList, com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        try {
            if (j == -9223372036854775807L || j == Long.MIN_VALUE) {
                mediaSourceList.z(mediaPeriod);
            } else {
                mediaSourceList.z(((com.google.android.exoplayer2.source.ClippingMediaPeriod) mediaPeriod).mediaPeriod);
            }
        } catch (java.lang.RuntimeException e) {
            com.google.android.exoplayer2.util.Log.e("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public long a(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, long j, boolean z) {
        return b(trackSelectorResult, j, z, new boolean[this.i.length]);
    }

    public long b(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || !trackSelectorResult.isEquivalent(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        g(this.c);
        f();
        this.n = trackSelectorResult;
        h();
        com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray = trackSelectorResult.selections;
        long selectTracks = this.a.selectTracks(trackSelectionArray.getAll(), this.h, this.c, zArr, j);
        c(this.c);
        this.e = false;
        int i2 = 0;
        while (true) {
            com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr = this.c;
            if (i2 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelectorResult.isRendererEnabled(i2));
                if (this.i[i2].getTrackType() != 6) {
                    this.e = true;
                }
            } else {
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public final void c(com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr = this.i;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == 6 && this.n.isRendererEnabled(i)) {
                sampleStreamArr[i] = new com.google.android.exoplayer2.source.EmptySampleStream();
            }
            i++;
        }
    }

    public void d(long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(r());
        this.a.continueLoading(y(j));
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult = this.n;
            if (i >= trackSelectorResult.length) {
                return;
            }
            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.n.selections.get(i);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
            i++;
        }
    }

    public final void g(com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr = this.i;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == 6) {
                sampleStreamArr[i] = null;
            }
            i++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult = this.n;
            if (i >= trackSelectorResult.length) {
                return;
            }
            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.n.selections.get(i);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
            i++;
        }
    }

    public long i() {
        if (!this.d) {
            return this.f.b;
        }
        long bufferedPositionUs = this.e ? this.a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f.e : bufferedPositionUs;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.MediaPeriodHolder j() {
        return this.l;
    }

    public long k() {
        if (this.d) {
            return this.a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.o;
    }

    public long m() {
        return this.f.b + this.o;
    }

    public com.google.android.exoplayer2.source.TrackGroupArray n() {
        return this.m;
    }

    public com.google.android.exoplayer2.trackselection.TrackSelectorResult o() {
        return this.n;
    }

    public void p(float f, com.google.android.exoplayer2.Timeline timeline) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.d = true;
        this.m = this.a.getTrackGroups();
        com.google.android.exoplayer2.trackselection.TrackSelectorResult v = v(f, timeline);
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo = this.f;
        long j = mediaPeriodInfo.b;
        long j2 = mediaPeriodInfo.e;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = java.lang.Math.max(0L, j2 - 1);
        }
        long a = a(v, j, false);
        long j3 = this.o;
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo2 = this.f;
        this.o = j3 + (mediaPeriodInfo2.b - a);
        this.f = mediaPeriodInfo2.b(a);
    }

    public boolean q() {
        return this.d && (!this.e || this.a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.l == null;
    }

    public void s(long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(r());
        if (this.d) {
            this.a.reevaluateBuffer(y(j));
        }
    }

    public void t() {
        f();
        u(this.f.d, this.k, this.a);
    }

    public com.google.android.exoplayer2.trackselection.TrackSelectorResult v(float f, com.google.android.exoplayer2.Timeline timeline) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.TrackSelectorResult selectTracks = this.j.selectTracks(this.i, n(), this.f.a, timeline);
        for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : selectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f);
            }
        }
        return selectTracks;
    }

    public void w(@androidx.annotation.Nullable com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder == this.l) {
            return;
        }
        f();
        this.l = mediaPeriodHolder;
        h();
    }

    public void x(long j) {
        this.o = j;
    }

    public long y(long j) {
        return j - l();
    }

    public long z(long j) {
        return j + l();
    }
}
