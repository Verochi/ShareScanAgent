package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ph implements android.view.View.OnClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseQuickAdapter t;

    public /* synthetic */ ph(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseQuickAdapter baseQuickAdapter) {
        this.n = baseViewHolder;
        this.t = baseQuickAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.chad.library.adapter.base.BaseQuickAdapter.e(this.n, this.t, view);
    }
}
