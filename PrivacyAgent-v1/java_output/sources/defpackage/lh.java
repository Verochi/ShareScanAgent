package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class lh implements android.view.View.OnClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseProviderMultiAdapter t;

    public /* synthetic */ lh(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter baseProviderMultiAdapter) {
        this.n = baseViewHolder;
        this.t = baseProviderMultiAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.chad.library.adapter.base.BaseProviderMultiAdapter.q(this.n, this.t, view);
    }
}
