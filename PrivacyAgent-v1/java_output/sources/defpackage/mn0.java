package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class mn0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.home.presenter.HomeFamilyGroupPresenter n;
    public final /* synthetic */ com.moji.http.member.entity.FamilyGroupListResult.Group t;
    public final /* synthetic */ com.moji.dialog.MJDialog u;

    public /* synthetic */ mn0(com.moji.newmember.home.presenter.HomeFamilyGroupPresenter homeFamilyGroupPresenter, com.moji.http.member.entity.FamilyGroupListResult.Group group, com.moji.dialog.MJDialog mJDialog) {
        this.n = homeFamilyGroupPresenter;
        this.t = group;
        this.u = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.home.presenter.HomeFamilyGroupPresenter.b(this.n, this.t, this.u, view);
    }
}
