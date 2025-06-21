package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdsMediaSource n;
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener t;

    public /* synthetic */ a(com.google.android.exoplayer2.source.ads.AdsMediaSource adsMediaSource, com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener) {
        this.n = adsMediaSource;
        this.t = componentListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.k(this.t);
    }
}
