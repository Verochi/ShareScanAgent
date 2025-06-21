package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class mj implements java.lang.Runnable {
    public final /* synthetic */ com.chad.library.adapter.base.diff.BrvahAsyncDiffer n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ java.util.List u;
    public final /* synthetic */ int v;
    public final /* synthetic */ java.lang.Runnable w;

    public /* synthetic */ mj(com.chad.library.adapter.base.diff.BrvahAsyncDiffer brvahAsyncDiffer, java.util.List list, java.util.List list2, int i, java.lang.Runnable runnable) {
        this.n = brvahAsyncDiffer;
        this.t = list;
        this.u = list2;
        this.v = i;
        this.w = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.chad.library.adapter.base.diff.BrvahAsyncDiffer.e(this.n, this.t, this.u, this.v, this.w);
    }
}
