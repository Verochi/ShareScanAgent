package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final /* synthetic */ class c implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ProgressiveMediaPeriod n;
    public final /* synthetic */ com.google.android.exoplayer2.extractor.SeekMap t;

    public /* synthetic */ c(com.google.android.exoplayer2.source.ProgressiveMediaPeriod progressiveMediaPeriod, com.google.android.exoplayer2.extractor.SeekMap seekMap) {
        this.n = progressiveMediaPeriod;
        this.t = seekMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.w(this.t);
    }
}
