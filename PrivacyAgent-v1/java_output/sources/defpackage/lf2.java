package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class lf2 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ java.lang.Runnable a;

    public /* synthetic */ lf2(java.lang.Runnable runnable) {
        this.a = runnable;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.setting.fragment.SettingPermissionSwitchControlFragment.d(this.a, mJDialog, eTypeAction);
    }
}
