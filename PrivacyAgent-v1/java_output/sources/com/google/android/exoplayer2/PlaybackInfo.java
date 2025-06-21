package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class PlaybackInfo {
    public static final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId q = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(new java.lang.Object());
    public final com.google.android.exoplayer2.Timeline a;
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId b;
    public final long c;
    public final int d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ExoPlaybackException e;
    public final boolean f;
    public final com.google.android.exoplayer2.source.TrackGroupArray g;
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult h;
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId i;
    public final boolean j;
    public final int k;
    public final com.google.android.exoplayer2.PlaybackParameters l;
    public final boolean m;
    public volatile long n;
    public volatile long o;
    public volatile long p;

    public PlaybackInfo(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException, boolean z, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i2, com.google.android.exoplayer2.PlaybackParameters playbackParameters, long j2, long j3, long j4, boolean z3) {
        this.a = timeline;
        this.b = mediaPeriodId;
        this.c = j;
        this.d = i;
        this.e = exoPlaybackException;
        this.f = z;
        this.g = trackGroupArray;
        this.h = trackSelectorResult;
        this.i = mediaPeriodId2;
        this.j = z2;
        this.k = i2;
        this.l = playbackParameters;
        this.n = j2;
        this.o = j3;
        this.p = j4;
        this.m = z3;
    }

    public static com.google.android.exoplayer2.PlaybackInfo j(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        com.google.android.exoplayer2.Timeline timeline = com.google.android.exoplayer2.Timeline.EMPTY;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = q;
        return new com.google.android.exoplayer2.PlaybackInfo(timeline, mediaPeriodId, -9223372036854775807L, 1, null, false, com.google.android.exoplayer2.source.TrackGroupArray.EMPTY, trackSelectorResult, mediaPeriodId, false, 0, com.google.android.exoplayer2.PlaybackParameters.DEFAULT, 0L, 0L, 0L, false);
    }

    public static com.google.android.exoplayer2.source.MediaSource.MediaPeriodId k() {
        return q;
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo a(boolean z) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, this.d, this.e, z, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo b(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, mediaPeriodId, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo c(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, mediaPeriodId, j2, this.d, this.e, this.f, trackGroupArray, trackSelectorResult, this.i, this.j, this.k, this.l, this.n, j3, j, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo d(boolean z) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, z);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo e(boolean z, int i) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, z, i, this.l, this.n, this.o, this.p, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo f(@androidx.annotation.Nullable com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, this.d, exoPlaybackException, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo g(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, playbackParameters, this.n, this.o, this.p, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo h(int i) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.a, this.b, this.c, i, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.PlaybackInfo i(com.google.android.exoplayer2.Timeline timeline) {
        return new com.google.android.exoplayer2.PlaybackInfo(timeline, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o, this.p, this.m);
    }
}
