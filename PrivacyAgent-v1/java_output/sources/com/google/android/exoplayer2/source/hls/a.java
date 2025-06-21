package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper n;

    public /* synthetic */ a(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.n = hlsSampleStreamWrapper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.y();
    }
}
