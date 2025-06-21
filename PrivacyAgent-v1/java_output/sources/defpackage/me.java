package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class me implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher n;
    public final /* synthetic */ int t;
    public final /* synthetic */ long u;
    public final /* synthetic */ long v;

    public /* synthetic */ me(com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher, int i, long j, long j2) {
        this.n = eventDispatcher;
        this.t = i;
        this.u = j;
        this.v = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.p(this.t, this.u, this.v);
    }
}
