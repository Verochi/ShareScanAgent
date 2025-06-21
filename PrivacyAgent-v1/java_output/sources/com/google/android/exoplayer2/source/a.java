package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ProgressiveMediaPeriod n;

    public /* synthetic */ a(com.google.android.exoplayer2.source.ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.n = progressiveMediaPeriod;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.x();
    }
}
