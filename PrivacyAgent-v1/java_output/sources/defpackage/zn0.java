package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class zn0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjkinsfolk.presenter.HomeHeaderPresenter n;
    public final /* synthetic */ com.moji.mjkinsfolk.presenter.HomeHeaderPresenter.HeaderViewHolder t;

    public /* synthetic */ zn0(com.moji.mjkinsfolk.presenter.HomeHeaderPresenter homeHeaderPresenter, com.moji.mjkinsfolk.presenter.HomeHeaderPresenter.HeaderViewHolder headerViewHolder) {
        this.n = homeHeaderPresenter;
        this.t = headerViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjkinsfolk.presenter.HomeHeaderPresenter.HeaderViewHolder.a(this.n, this.t, view);
    }
}
