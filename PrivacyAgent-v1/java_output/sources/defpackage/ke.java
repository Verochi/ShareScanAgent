package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ke implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.Format t;

    public /* synthetic */ ke(com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.Format format) {
        this.n = eventDispatcher;
        this.t = format;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.m(this.t);
    }
}
