package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class jh implements android.view.View.OnClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseProviderMultiAdapter t;
    public final /* synthetic */ com.chad.library.adapter.base.provider.BaseItemProvider u;

    public /* synthetic */ jh(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter baseProviderMultiAdapter, com.chad.library.adapter.base.provider.BaseItemProvider baseItemProvider) {
        this.n = baseViewHolder;
        this.t = baseProviderMultiAdapter;
        this.u = baseItemProvider;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.chad.library.adapter.base.BaseProviderMultiAdapter.o(this.n, this.t, this.u, view);
    }
}
