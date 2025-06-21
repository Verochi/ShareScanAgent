package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class rd1 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener t;
    public final /* synthetic */ com.google.android.exoplayer2.source.LoadEventInfo u;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaLoadData v;

    public /* synthetic */ rd1(com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        this.n = eventDispatcher;
        this.t = mediaSourceEventListener;
        this.u = loadEventInfo;
        this.v = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.j(this.t, this.u, this.v);
    }
}
