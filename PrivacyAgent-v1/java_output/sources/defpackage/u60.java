package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class u60 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.drm.DrmSessionEventListener t;
    public final /* synthetic */ java.lang.Exception u;

    public /* synthetic */ u60(com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener, java.lang.Exception exc) {
        this.n = eventDispatcher;
        this.t = drmSessionEventListener;
        this.u = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.k(this.t, this.u);
    }
}
