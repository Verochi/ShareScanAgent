package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class nn0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.dialog.MJDialog n;

    public /* synthetic */ nn0(com.moji.dialog.MJDialog mJDialog) {
        this.n = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.home.presenter.HomeFamilyGroupPresenter.a(this.n, view);
    }
}
