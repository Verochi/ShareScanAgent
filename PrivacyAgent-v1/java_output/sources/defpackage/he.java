package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class he implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ he(com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.n = eventDispatcher;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.o(this.t);
    }
}
