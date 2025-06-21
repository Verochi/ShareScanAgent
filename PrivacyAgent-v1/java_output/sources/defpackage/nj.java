package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class nj implements java.lang.Runnable {
    public final /* synthetic */ com.chad.library.adapter.base.diff.BrvahAsyncDiffer n;
    public final /* synthetic */ int t;
    public final /* synthetic */ java.util.List u;
    public final /* synthetic */ androidx.recyclerview.widget.DiffUtil.DiffResult v;
    public final /* synthetic */ java.lang.Runnable w;

    public /* synthetic */ nj(com.chad.library.adapter.base.diff.BrvahAsyncDiffer brvahAsyncDiffer, int i, java.util.List list, androidx.recyclerview.widget.DiffUtil.DiffResult diffResult, java.lang.Runnable runnable) {
        this.n = brvahAsyncDiffer;
        this.t = i;
        this.u = list;
        this.v = diffResult;
        this.w = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.chad.library.adapter.base.diff.BrvahAsyncDiffer.f(this.n, this.t, this.u, this.v, this.w);
    }
}
