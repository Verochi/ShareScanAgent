package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.drm.DefaultDrmSession n;

    public /* synthetic */ b(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
        this.n = defaultDrmSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.release(null);
    }
}
