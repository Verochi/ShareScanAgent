package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class d01 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.me.presenter.LoginPresenter a;
    public final /* synthetic */ com.moji.http.ugc.bean.account.UserInfoEntity b;
    public final /* synthetic */ int c;

    public /* synthetic */ d01(com.moji.mjweather.me.presenter.LoginPresenter loginPresenter, com.moji.http.ugc.bean.account.UserInfoEntity userInfoEntity, int i) {
        this.a = loginPresenter;
        this.b = userInfoEntity;
        this.c = i;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.me.presenter.LoginPresenter.e(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}
