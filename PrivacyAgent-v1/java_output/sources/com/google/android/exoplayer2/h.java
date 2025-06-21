package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class h implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImpl n;
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate t;

    public /* synthetic */ h(com.google.android.exoplayer2.ExoPlayerImpl exoPlayerImpl, com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.n = exoPlayerImpl;
        this.t = playbackInfoUpdate;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.u(this.t);
    }
}
