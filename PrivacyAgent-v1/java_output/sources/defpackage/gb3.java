package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class gb3 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher n;
    public final /* synthetic */ android.view.Surface t;

    public /* synthetic */ gb3(com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher, android.view.Surface surface) {
        this.n = eventDispatcher;
        this.t = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.n(this.t);
    }
}
