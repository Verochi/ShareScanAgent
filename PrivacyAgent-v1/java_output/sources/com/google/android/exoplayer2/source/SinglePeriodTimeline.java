package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class SinglePeriodTimeline extends com.google.android.exoplayer2.Timeline {
    public static final java.lang.Object m = new java.lang.Object();
    public static final com.google.android.exoplayer2.MediaItem n = new com.google.android.exoplayer2.MediaItem.Builder().setMediaId("com.google.android.exoplayer2.source.SinglePeriodTimeline").setUri(android.net.Uri.EMPTY).build();
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    @androidx.annotation.Nullable
    public final java.lang.Object k;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.MediaItem l;

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @androidx.annotation.Nullable java.lang.Object obj, com.google.android.exoplayer2.MediaItem mediaItem) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = obj;
        this.l = (com.google.android.exoplayer2.MediaItem) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem);
    }

    @java.lang.Deprecated
    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        this(j, j2, j3, j4, j5, j6, j7, z, z2, z3, obj, n.buildUpon().setTag(obj2).build());
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @androidx.annotation.Nullable java.lang.Object obj, com.google.android.exoplayer2.MediaItem mediaItem) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, z3, obj, mediaItem);
    }

    @java.lang.Deprecated
    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, @androidx.annotation.Nullable java.lang.Object obj, com.google.android.exoplayer2.MediaItem mediaItem) {
        this(j, j, 0L, 0L, z, z2, z3, obj, mediaItem);
    }

    @java.lang.Deprecated
    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, @androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        this(j, j, 0L, 0L, z, z2, z3, obj, obj2);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(java.lang.Object obj) {
        return m.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, 1);
        return period.set(null, z ? m : null, 0, this.d, -this.f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public java.lang.Object getUidOfPeriod(int i) {
        com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, 1);
        return m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (r1 > r3) goto L8;
     */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
        long j2;
        com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, 1);
        long j3 = this.g;
        boolean z = this.i;
        if (z && j != 0) {
            long j4 = this.e;
            if (j4 != -9223372036854775807L) {
                j3 += j;
            }
            j2 = -9223372036854775807L;
            return window.set(com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID, this.l, this.k, this.a, this.b, this.c, this.h, z, this.j, j2, this.e, 0, 0, this.f);
        }
        j2 = j3;
        return window.set(com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID, this.l, this.k, this.a, this.b, this.c, this.h, z, this.j, j2, this.e, 0, 0, this.f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }
}
