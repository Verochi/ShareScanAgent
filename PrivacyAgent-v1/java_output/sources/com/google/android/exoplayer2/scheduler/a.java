package com.google.android.exoplayer2.scheduler;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.scheduler.RequirementsWatcher.NetworkCallback n;

    public /* synthetic */ a(com.google.android.exoplayer2.scheduler.RequirementsWatcher.NetworkCallback networkCallback) {
        this.n = networkCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.d();
    }
}
