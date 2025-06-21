package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class xv implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.dash.DashMediaSource n;

    public /* synthetic */ xv(com.google.android.exoplayer2.source.dash.DashMediaSource dashMediaSource) {
        this.n = dashMediaSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.h();
    }
}
