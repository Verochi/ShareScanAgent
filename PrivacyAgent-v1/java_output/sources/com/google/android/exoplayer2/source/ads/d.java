package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public final /* synthetic */ class d implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener n;
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdPlaybackState t;

    public /* synthetic */ d(com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener, com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
        this.n = componentListener;
        this.t = adPlaybackState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.b(this.t);
    }
}
