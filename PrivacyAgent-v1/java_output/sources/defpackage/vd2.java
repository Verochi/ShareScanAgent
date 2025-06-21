package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class vd2 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.Object n;
    public final /* synthetic */ int t;
    public final /* synthetic */ java.lang.Long u;
    public final /* synthetic */ int v;
    public final /* synthetic */ java.lang.String w;

    public /* synthetic */ vd2(java.lang.Object obj, int i, java.lang.Long l, int i2, java.lang.String str) {
        this.n = obj;
        this.t = i;
        this.u = l;
        this.v = i2;
        this.w = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.monitor.util.SdkSnapshotReportUtils.Companion.a(this.n, this.t, this.u, this.v, this.w);
    }
}
