package defpackage;

/* renamed from: if, reason: invalid class name */
/* loaded from: classes17.dex */
public final /* synthetic */ class Cif implements com.moji.dialog.control.MJDialogDefaultControl.OnDismissCallback {
    public final /* synthetic */ com.moji.weatherprovider.update.AutoUpdateDialogManager a;

    public /* synthetic */ Cif(com.moji.weatherprovider.update.AutoUpdateDialogManager autoUpdateDialogManager) {
        this.a = autoUpdateDialogManager;
    }

    public final void onDismiss(com.moji.dialog.MJDialog mJDialog) {
        com.moji.weatherprovider.update.AutoUpdateDialogManager.b(this.a, mJDialog);
    }
}
