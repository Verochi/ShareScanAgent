package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public final /* synthetic */ class c implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareListener n;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSource.MediaPeriodId t;
    public final /* synthetic */ java.io.IOException u;

    public /* synthetic */ c(com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareListener adPrepareListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.io.IOException iOException) {
        this.n = adPrepareListener;
        this.t = mediaPeriodId;
        this.u = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.d(this.t, this.u);
    }
}
