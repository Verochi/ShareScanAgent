package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class r73 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.lifecyclelistener.UserWriteOffCheck a;
    public final /* synthetic */ android.app.Activity b;

    public /* synthetic */ r73(com.moji.mjweather.lifecyclelistener.UserWriteOffCheck userWriteOffCheck, android.app.Activity activity) {
        this.a = userWriteOffCheck;
        this.b = activity;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.lifecyclelistener.UserWriteOffCheck.a(this.a, this.b, mJDialog, eTypeAction);
    }
}
