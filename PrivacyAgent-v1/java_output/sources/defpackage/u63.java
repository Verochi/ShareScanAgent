package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class u63 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.appupdate.UpgradeAlphaCenter a;
    public final /* synthetic */ java.io.File b;

    public /* synthetic */ u63(com.moji.appupdate.UpgradeAlphaCenter upgradeAlphaCenter, java.io.File file) {
        this.a = upgradeAlphaCenter;
        this.b = file;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.appupdate.UpgradeAlphaCenter.e(this.a, this.b, mJDialog, eTypeAction);
    }
}
