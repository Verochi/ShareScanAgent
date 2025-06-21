package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class MediaPeriodInfo {
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public MediaPeriodInfo(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3) {
        this.a = mediaPeriodId;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
        this.h = z3;
    }

    public com.google.android.exoplayer2.MediaPeriodInfo a(long j) {
        return j == this.c ? this : new com.google.android.exoplayer2.MediaPeriodInfo(this.a, this.b, j, this.d, this.e, this.f, this.g, this.h);
    }

    public com.google.android.exoplayer2.MediaPeriodInfo b(long j) {
        return j == this.b ? this : new com.google.android.exoplayer2.MediaPeriodInfo(this.a, j, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo = (com.google.android.exoplayer2.MediaPeriodInfo) obj;
        return this.b == mediaPeriodInfo.b && this.c == mediaPeriodInfo.c && this.d == mediaPeriodInfo.d && this.e == mediaPeriodInfo.e && this.f == mediaPeriodInfo.f && this.g == mediaPeriodInfo.g && this.h == mediaPeriodInfo.h && com.google.android.exoplayer2.util.Util.areEqual(this.a, mediaPeriodInfo.a);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.a.hashCode()) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0);
    }
}
