package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public interface DashSegmentIndex {
    public static final int INDEX_UNBOUNDED = -1;

    long getDurationUs(long j, long j2);

    long getFirstSegmentNum();

    int getSegmentCount(long j);

    long getSegmentNum(long j, long j2);

    com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j);

    long getTimeUs(long j);

    boolean isExplicit();
}
