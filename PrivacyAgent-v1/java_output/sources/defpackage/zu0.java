package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class zu0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjkinsfolk.ui.KinsfolkHomeXCHAdapter.ProductItemViewHolder n;
    public final /* synthetic */ com.moji.mjkinsfolk.ui.KinsfolkHomeXCHAdapter t;

    public /* synthetic */ zu0(com.moji.mjkinsfolk.ui.KinsfolkHomeXCHAdapter.ProductItemViewHolder productItemViewHolder, com.moji.mjkinsfolk.ui.KinsfolkHomeXCHAdapter kinsfolkHomeXCHAdapter) {
        this.n = productItemViewHolder;
        this.t = kinsfolkHomeXCHAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjkinsfolk.ui.KinsfolkHomeXCHAdapter.ProductItemViewHolder.a(this.n, this.t, view);
    }
}
