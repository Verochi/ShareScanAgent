package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class r63 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.dialog.MJDialog n;

    public /* synthetic */ r63(com.moji.dialog.MJDialog mJDialog) {
        this.n = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.order.presenter.UnionMemberOrderPresenter.e(this.n, view);
    }
}
