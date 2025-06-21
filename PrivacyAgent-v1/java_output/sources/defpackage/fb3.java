package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class fb3 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;
    public final /* synthetic */ int v;
    public final /* synthetic */ float w;

    public /* synthetic */ fb3(com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher, int i, int i2, int i3, float f) {
        this.n = eventDispatcher;
        this.t = i;
        this.u = i2;
        this.v = i3;
        this.w = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.p(this.t, this.u, this.v, this.w);
    }
}
