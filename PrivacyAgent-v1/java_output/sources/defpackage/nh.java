package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class nh implements android.view.View.OnClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseQuickAdapter t;

    public /* synthetic */ nh(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseQuickAdapter baseQuickAdapter) {
        this.n = baseViewHolder;
        this.t = baseQuickAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.chad.library.adapter.base.BaseQuickAdapter.g(this.n, this.t, view);
    }
}
