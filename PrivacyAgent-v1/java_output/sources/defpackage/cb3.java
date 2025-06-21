package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class cb3 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher n;
    public final /* synthetic */ long t;
    public final /* synthetic */ int u;

    public /* synthetic */ cb3(com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher, long j, int i) {
        this.n = eventDispatcher;
        this.t = j;
        this.u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.o(this.t, this.u);
    }
}
