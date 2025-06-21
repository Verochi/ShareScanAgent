package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class eh implements java.lang.Runnable {
    public final /* synthetic */ com.chad.library.adapter.base.module.BaseLoadMoreModule n;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView.LayoutManager t;

    public /* synthetic */ eh(com.chad.library.adapter.base.module.BaseLoadMoreModule baseLoadMoreModule, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        this.n = baseLoadMoreModule;
        this.t = layoutManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.chad.library.adapter.base.module.BaseLoadMoreModule.e(this.n, this.t);
    }
}
