package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class i implements java.lang.Runnable {
    public final /* synthetic */ java.util.concurrent.CopyOnWriteArrayList n;
    public final /* synthetic */ com.google.android.exoplayer2.BasePlayer.ListenerInvocation t;

    public /* synthetic */ i(java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList, com.google.android.exoplayer2.BasePlayer.ListenerInvocation listenerInvocation) {
        this.n = copyOnWriteArrayList;
        this.t = listenerInvocation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.exoplayer2.ExoPlayerImpl.t(this.n, this.t);
    }
}
