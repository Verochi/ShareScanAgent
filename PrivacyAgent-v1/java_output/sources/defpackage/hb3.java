package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class hb3 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ long u;
    public final /* synthetic */ long v;

    public /* synthetic */ hb3(com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher, java.lang.String str, long j, long j2) {
        this.n = eventDispatcher;
        this.t = str;
        this.u = j;
        this.v = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.i(this.t, this.u, this.v);
    }
}
