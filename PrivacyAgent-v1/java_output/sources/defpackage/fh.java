package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class fh implements java.lang.Runnable {
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView.LayoutManager n;
    public final /* synthetic */ com.chad.library.adapter.base.module.BaseLoadMoreModule t;

    public /* synthetic */ fh(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, com.chad.library.adapter.base.module.BaseLoadMoreModule baseLoadMoreModule) {
        this.n = layoutManager;
        this.t = baseLoadMoreModule;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.chad.library.adapter.base.module.BaseLoadMoreModule.f(this.n, this.t);
    }
}
