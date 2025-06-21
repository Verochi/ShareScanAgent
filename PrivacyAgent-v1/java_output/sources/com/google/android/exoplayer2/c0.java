package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class c0 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.StreamVolumeManager n;

    public /* synthetic */ c0(com.google.android.exoplayer2.StreamVolumeManager streamVolumeManager) {
        this.n = streamVolumeManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.exoplayer2.StreamVolumeManager.b(this.n);
    }
}
