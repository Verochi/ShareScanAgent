package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class mh implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseProviderMultiAdapter t;

    public /* synthetic */ mh(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseProviderMultiAdapter baseProviderMultiAdapter) {
        this.n = baseViewHolder;
        this.t = baseProviderMultiAdapter;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        boolean r;
        r = com.chad.library.adapter.base.BaseProviderMultiAdapter.r(this.n, this.t, view);
        return r;
    }
}
