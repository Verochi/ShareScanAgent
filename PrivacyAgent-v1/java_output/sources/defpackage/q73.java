package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class q73 implements com.moji.dialog.control.MJDialogDefaultControl.OnDismissCallback {
    public final /* synthetic */ com.moji.mjweather.lifecyclelistener.UserWriteOffCheck a;

    public /* synthetic */ q73(com.moji.mjweather.lifecyclelistener.UserWriteOffCheck userWriteOffCheck) {
        this.a = userWriteOffCheck;
    }

    public final void onDismiss(com.moji.dialog.MJDialog mJDialog) {
        com.moji.mjweather.lifecyclelistener.UserWriteOffCheck.b(this.a, mJDialog);
    }
}
