package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class td1 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSourceEventListener t;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaSource.MediaPeriodId u;
    public final /* synthetic */ com.google.android.exoplayer2.source.MediaLoadData v;

    public /* synthetic */ td1(com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        this.n = eventDispatcher;
        this.t = mediaSourceEventListener;
        this.u = mediaPeriodId;
        this.v = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.m(this.t, this.u, this.v);
    }
}
