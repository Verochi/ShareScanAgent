package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class s41 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.mjweather.me.dialog.MJOneKeyLoginPrivacyDialog.MJOneKeyLoginPrivacyDialogListener n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef t;

    public /* synthetic */ s41(com.moji.mjweather.me.dialog.MJOneKeyLoginPrivacyDialog.MJOneKeyLoginPrivacyDialogListener mJOneKeyLoginPrivacyDialogListener, kotlin.jvm.internal.Ref.BooleanRef booleanRef) {
        this.n = mJOneKeyLoginPrivacyDialogListener;
        this.t = booleanRef;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.mjweather.me.dialog.MJOneKeyLoginPrivacyDialog.c(this.n, this.t, dialogInterface);
    }
}
