package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class ClippingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Void> {
    public final com.google.android.exoplayer2.source.MediaSource B;
    public final long C;
    public final long D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.ClippingMediaPeriod> H;
    public final com.google.android.exoplayer2.Timeline.Window I;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline J;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException K;
    public long L;
    public long M;

    public static final class ClippingTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
        public final long a;
        public final long b;
        public final long c;
        public final boolean d;

        public ClippingTimeline(com.google.android.exoplayer2.Timeline timeline, long j, long j2) throws com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException {
            super(timeline);
            boolean z = false;
            if (timeline.getPeriodCount() != 1) {
                throw new com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException(0);
            }
            com.google.android.exoplayer2.Timeline.Window window = timeline.getWindow(0, new com.google.android.exoplayer2.Timeline.Window());
            long max = java.lang.Math.max(0L, j);
            if (!window.isPlaceholder && max != 0 && !window.isSeekable) {
                throw new com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException(1);
            }
            long max2 = j2 == Long.MIN_VALUE ? window.durationUs : java.lang.Math.max(0L, j2);
            long j3 = window.durationUs;
            if (j3 != -9223372036854775807L) {
                max2 = max2 > j3 ? j3 : max2;
                if (max > max2) {
                    throw new com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException(2);
                }
            }
            this.a = max;
            this.b = max2;
            this.c = max2 == -9223372036854775807L ? -9223372036854775807L : max2 - max;
            if (window.isDynamic && (max2 == -9223372036854775807L || (j3 != -9223372036854775807L && max2 == j3))) {
                z = true;
            }
            this.d = z;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
            this.timeline.getPeriod(0, period, z);
            long positionInWindowUs = period.getPositionInWindowUs() - this.a;
            long j = this.c;
            return period.set(period.id, period.uid, 0, j == -9223372036854775807L ? -9223372036854775807L : j - positionInWindowUs, positionInWindowUs);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
            this.timeline.getWindow(0, window, 0L);
            long j2 = window.positionInFirstPeriodUs;
            long j3 = this.a;
            window.positionInFirstPeriodUs = j2 + j3;
            window.durationUs = this.c;
            window.isDynamic = this.d;
            long j4 = window.defaultPositionUs;
            if (j4 != -9223372036854775807L) {
                long max = java.lang.Math.max(j4, j3);
                window.defaultPositionUs = max;
                long j5 = this.b;
                if (j5 != -9223372036854775807L) {
                    max = java.lang.Math.min(max, j5);
                }
                window.defaultPositionUs = max - this.a;
            }
            long usToMs = com.google.android.exoplayer2.C.usToMs(this.a);
            long j6 = window.presentationStartTimeMs;
            if (j6 != -9223372036854775807L) {
                window.presentationStartTimeMs = j6 + usToMs;
            }
            long j7 = window.windowStartTimeMs;
            if (j7 != -9223372036854775807L) {
                window.windowStartTimeMs = j7 + usToMs;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends java.io.IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public IllegalClippingException(int i) {
            super(r0.length() != 0 ? "Illegal clipping: ".concat(r0) : new java.lang.String("Illegal clipping: "));
            java.lang.String valueOf = java.lang.String.valueOf(getReasonDescription(i));
            this.reason = i;
        }

        private static java.lang.String getReasonDescription(int i) {
            return i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j) {
        this(mediaSource, 0L, j, true, false, true);
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j, long j2) {
        this(mediaSource, j, j2, true, false, false);
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j, long j2, boolean z, boolean z2, boolean z3) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0);
        this.B = (com.google.android.exoplayer2.source.MediaSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSource);
        this.C = j;
        this.D = j2;
        this.E = z;
        this.F = z2;
        this.G = z3;
        this.H = new java.util.ArrayList<>();
        this.I = new com.google.android.exoplayer2.Timeline.Window();
    }

    public final void c(com.google.android.exoplayer2.Timeline timeline) {
        long j;
        long j2;
        timeline.getWindow(0, this.I);
        long positionInFirstPeriodUs = this.I.getPositionInFirstPeriodUs();
        if (this.J == null || this.H.isEmpty() || this.F) {
            long j3 = this.C;
            long j4 = this.D;
            if (this.G) {
                long defaultPositionUs = this.I.getDefaultPositionUs();
                j3 += defaultPositionUs;
                j4 += defaultPositionUs;
            }
            this.L = positionInFirstPeriodUs + j3;
            this.M = this.D != Long.MIN_VALUE ? positionInFirstPeriodUs + j4 : Long.MIN_VALUE;
            int size = this.H.size();
            for (int i = 0; i < size; i++) {
                this.H.get(i).updateClipping(this.L, this.M);
            }
            j = j3;
            j2 = j4;
        } else {
            long j5 = this.L - positionInFirstPeriodUs;
            j2 = this.D != Long.MIN_VALUE ? this.M - positionInFirstPeriodUs : Long.MIN_VALUE;
            j = j5;
        }
        try {
            com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline clippingTimeline = new com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline(timeline, j, j2);
            this.J = clippingTimeline;
            refreshSourceInfo(clippingTimeline);
        } catch (com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException e) {
            this.K = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        com.google.android.exoplayer2.source.ClippingMediaPeriod clippingMediaPeriod = new com.google.android.exoplayer2.source.ClippingMediaPeriod(this.B.createPeriod(mediaPeriodId, allocator, j), this.E, this.L, this.M);
        this.H.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.B.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public long getMediaTimeForChildMediaTime(java.lang.Void r7, long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long usToMs = com.google.android.exoplayer2.C.usToMs(this.C);
        long max = java.lang.Math.max(0L, j - usToMs);
        long j2 = this.D;
        return j2 != Long.MIN_VALUE ? java.lang.Math.min(com.google.android.exoplayer2.C.usToMs(j2) - usToMs, max) : max;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.B.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException illegalClippingException = this.K;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(java.lang.Void r1, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        if (this.K != null) {
            return;
        }
        c(timeline);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.B);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.H.remove(mediaPeriod));
        this.B.releasePeriod(((com.google.android.exoplayer2.source.ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (!this.H.isEmpty() || this.F) {
            return;
        }
        c(((com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.J)).timeline);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.K = null;
        this.J = null;
    }
}
