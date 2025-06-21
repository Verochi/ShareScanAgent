package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver n;
    public final /* synthetic */ com.google.android.exoplayer2.upstream.DefaultBandwidthMeter t;

    public /* synthetic */ b(com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver connectivityActionReceiver, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter defaultBandwidthMeter) {
        this.n = connectivityActionReceiver;
        this.t = defaultBandwidthMeter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.c(this.t);
    }
}
