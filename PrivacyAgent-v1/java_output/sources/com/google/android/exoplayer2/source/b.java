package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ProgressiveMediaPeriod n;

    public /* synthetic */ b(com.google.android.exoplayer2.source.ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.n = progressiveMediaPeriod;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.v();
    }
}
