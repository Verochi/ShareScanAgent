package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.util.Comparator {
    @Override // java.util.Comparator
    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
        int e;
        e = com.google.android.exoplayer2.util.SlidingPercentile.e((com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj, (com.google.android.exoplayer2.util.SlidingPercentile.Sample) obj2);
        return e;
    }
}
