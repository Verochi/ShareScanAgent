package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class qg implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseBinderAdapter t;

    public /* synthetic */ qg(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseBinderAdapter baseBinderAdapter) {
        this.n = baseViewHolder;
        this.t = baseBinderAdapter;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        boolean r;
        r = com.chad.library.adapter.base.BaseBinderAdapter.r(this.n, this.t, view);
        return r;
    }
}
