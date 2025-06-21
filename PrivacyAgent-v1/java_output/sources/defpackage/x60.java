package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class x60 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.drm.DrmSessionEventListener t;

    public /* synthetic */ x60(com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
        this.n = eventDispatcher;
        this.t = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.j(this.t);
    }
}
