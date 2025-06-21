package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class kh implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseProviderMultiAdapter t;
    public final /* synthetic */ com.chad.library.adapter.base.provider.BaseItemProvider u;

    public /* synthetic */ kh(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter baseProviderMultiAdapter, com.chad.library.adapter.base.provider.BaseItemProvider baseItemProvider) {
        this.n = baseViewHolder;
        this.t = baseProviderMultiAdapter;
        this.u = baseItemProvider;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        boolean p;
        p = com.chad.library.adapter.base.BaseProviderMultiAdapter.p(this.n, this.t, this.u, view);
        return p;
    }
}
