package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ie implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher n;
    public final /* synthetic */ long t;

    public /* synthetic */ ie(com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher, long j) {
        this.n = eventDispatcher;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.n(this.t);
    }
}
