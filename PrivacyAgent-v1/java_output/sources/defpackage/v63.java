package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class v63 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ android.app.Activity a;

    public /* synthetic */ v63(android.app.Activity activity) {
        this.a = activity;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.appupdate.UpgradeAlphaCenter.f(this.a, mJDialog, eTypeAction);
    }
}
