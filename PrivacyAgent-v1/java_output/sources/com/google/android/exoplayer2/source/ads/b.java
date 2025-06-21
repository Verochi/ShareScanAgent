package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareListener n;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSource.MediaPeriodId t;

    public /* synthetic */ b(com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareListener adPrepareListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        this.n = adPrepareListener;
        this.t = mediaPeriodId;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.c(this.t);
    }
}
