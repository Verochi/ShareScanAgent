package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class rg implements android.view.View.OnClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseBinderAdapter t;
    public final /* synthetic */ com.chad.library.adapter.base.binder.BaseItemBinder u;

    public /* synthetic */ rg(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseBinderAdapter baseBinderAdapter, com.chad.library.adapter.base.binder.BaseItemBinder baseItemBinder) {
        this.n = baseViewHolder;
        this.t = baseBinderAdapter;
        this.u = baseItemBinder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.chad.library.adapter.base.BaseBinderAdapter.p(this.n, this.t, this.u, view);
    }
}
