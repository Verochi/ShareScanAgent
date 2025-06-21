package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class oe implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher n;
    public final /* synthetic */ int t;

    public /* synthetic */ oe(com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher, int i) {
        this.n = eventDispatcher;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.i(this.t);
    }
}
