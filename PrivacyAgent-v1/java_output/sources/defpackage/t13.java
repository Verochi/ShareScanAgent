package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class t13 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.thunder.thunderstorm.fragment.ThunderSubscribeNoticeDialog n;
    public final /* synthetic */ android.widget.EditText t;
    public final /* synthetic */ com.moji.dialog.MJDialog u;

    public /* synthetic */ t13(com.moji.thunder.thunderstorm.fragment.ThunderSubscribeNoticeDialog thunderSubscribeNoticeDialog, android.widget.EditText editText, com.moji.dialog.MJDialog mJDialog) {
        this.n = thunderSubscribeNoticeDialog;
        this.t = editText;
        this.u = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.thunder.thunderstorm.fragment.ThunderSubscribeNoticeDialog.b(this.n, this.t, this.u, view);
    }
}
