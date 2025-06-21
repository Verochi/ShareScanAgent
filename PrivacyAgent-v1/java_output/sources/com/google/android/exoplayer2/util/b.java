package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements java.util.Comparator {
    @Override // java.util.Comparator
    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
        int f;
        f = com.google.android.exoplayer2.util.SlidingPercentile.f((com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj, (com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj2);
        return f;
    }
}
