package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class sg implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.viewholder.BaseViewHolder n;
    public final /* synthetic */ com.chad.library.adapter.base.BaseBinderAdapter t;
    public final /* synthetic */ com.chad.library.adapter.base.binder.BaseItemBinder u;

    public /* synthetic */ sg(com.chad.library.adapter.base.viewholder.BaseViewHolder baseViewHolder, com.chad.library.adapter.base.BaseBinderAdapter baseBinderAdapter, com.chad.library.adapter.base.binder.BaseItemBinder baseItemBinder) {
        this.n = baseViewHolder;
        this.t = baseBinderAdapter;
        this.u = baseItemBinder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        boolean o;
        o = com.chad.library.adapter.base.BaseBinderAdapter.o(this.n, this.t, this.u, view);
        return o;
    }
}
