package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class qd1 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener t;
    public final /* synthetic */ com.google.android.exoplayer2.source.LoadEventInfo u;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaLoadData v;
    public final /* synthetic */ java.io.IOException w;
    public final /* synthetic */ boolean x;

    public /* synthetic */ qd1(com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
        this.n = eventDispatcher;
        this.t = mediaSourceEventListener;
        this.u = loadEventInfo;
        this.v = mediaLoadData;
        this.w = iOException;
        this.x = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.k(this.t, this.u, this.v, this.w, this.x);
    }
}
