package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class x implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImplInternal n;
    public final /* synthetic */ com.google.android.exoplayer2.PlayerMessage t;

    public /* synthetic */ x(com.google.android.exoplayer2.ExoPlayerImplInternal exoPlayerImplInternal, com.google.android.exoplayer2.PlayerMessage playerMessage) {
        this.n = exoPlayerImplInternal;
        this.t = playerMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.J(this.t);
    }
}
