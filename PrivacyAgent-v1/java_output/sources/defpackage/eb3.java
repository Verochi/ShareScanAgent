package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class eb3 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher n;
    public final /* synthetic */ int t;
    public final /* synthetic */ long u;

    public /* synthetic */ eb3(com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher, int i, long j) {
        this.n = eventDispatcher;
        this.t = i;
        this.u = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.k(this.t, this.u);
    }
}
