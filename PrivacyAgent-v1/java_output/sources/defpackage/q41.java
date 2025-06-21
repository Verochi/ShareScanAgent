package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class q41 implements android.view.View.OnClickListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;
    public final /* synthetic */ com.moji.mjweather.me.dialog.MJOneKeyLoginPrivacyDialog.MJOneKeyLoginPrivacyDialogListener u;

    public /* synthetic */ q41(kotlin.jvm.internal.Ref.BooleanRef booleanRef, com.moji.dialog.MJDialog mJDialog, com.moji.mjweather.me.dialog.MJOneKeyLoginPrivacyDialog.MJOneKeyLoginPrivacyDialogListener mJOneKeyLoginPrivacyDialogListener) {
        this.n = booleanRef;
        this.t = mJDialog;
        this.u = mJOneKeyLoginPrivacyDialogListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.me.dialog.MJOneKeyLoginPrivacyDialog.b(this.n, this.t, this.u, view);
    }
}
