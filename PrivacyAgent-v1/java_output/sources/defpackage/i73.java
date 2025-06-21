package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class i73 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.user.homepage.fragment.UserCenterDynamicFragment a;
    public final /* synthetic */ com.moji.http.snsforum.entity.PictureDynamic b;

    public /* synthetic */ i73(com.moji.user.homepage.fragment.UserCenterDynamicFragment userCenterDynamicFragment, com.moji.http.snsforum.entity.PictureDynamic pictureDynamic) {
        this.a = userCenterDynamicFragment;
        this.b = pictureDynamic;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.user.homepage.fragment.UserCenterDynamicFragment.a(this.a, this.b, mJDialog, eTypeAction);
    }
}
