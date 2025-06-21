package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class a0 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.MediaPeriodQueue n;
    public final /* synthetic */ com.google.common.collect.ImmutableList.Builder t;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSource.MediaPeriodId u;

    public /* synthetic */ a0(com.google.android.exoplayer2.MediaPeriodQueue mediaPeriodQueue, com.google.common.collect.ImmutableList.Builder builder, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        this.n = mediaPeriodQueue;
        this.t = builder;
        this.u = mediaPeriodId;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.v(this.t, this.u);
    }
}
