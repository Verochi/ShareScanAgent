package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class t60 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.drm.DrmSessionEventListener t;

    public /* synthetic */ t60(com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
        this.n = eventDispatcher;
        this.t = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.l(this.t);
    }
}
