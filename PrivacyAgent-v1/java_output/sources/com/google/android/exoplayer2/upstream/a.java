package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener n;
    public final /* synthetic */ int t;
    public final /* synthetic */ long u;
    public final /* synthetic */ long v;

    public /* synthetic */ a(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i, long j, long j2) {
        this.n = handlerAndListener;
        this.t = i;
        this.u = j;
        this.v = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.b(this.n, this.t, this.u, this.v);
    }
}
