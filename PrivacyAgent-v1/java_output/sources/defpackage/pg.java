package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class pg implements android.view.View.OnClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseBinderAdapter t;

    public /* synthetic */ pg(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseBinderAdapter baseBinderAdapter) {
        this.n = baseViewHolder;
        this.t = baseBinderAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.chad.library.adapter.base.BaseBinderAdapter.q(this.n, this.t, view);
    }
}
