package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class oh implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseQuickAdapter t;

    public /* synthetic */ oh(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseQuickAdapter baseQuickAdapter) {
        this.n = baseViewHolder;
        this.t = baseQuickAdapter;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        boolean h;
        h = com.chad.library.adapter.base.BaseQuickAdapter.h(this.n, this.t, view);
        return h;
    }
}
