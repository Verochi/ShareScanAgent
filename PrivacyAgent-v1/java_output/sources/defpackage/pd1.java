package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class pd1 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener t;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaLoadData u;

    public /* synthetic */ pd1(com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        this.n = eventDispatcher;
        this.t = mediaSourceEventListener;
        this.u = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.h(this.t, this.u);
    }
}
