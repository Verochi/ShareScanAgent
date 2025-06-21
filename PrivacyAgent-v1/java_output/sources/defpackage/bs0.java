package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class bs0 implements android.view.View.OnClickListener {
    public final /* synthetic */ android.widget.EditText n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;
    public final /* synthetic */ com.moji.influenza.view.InfluenzaSubscribeNoticeDialog u;

    public /* synthetic */ bs0(android.widget.EditText editText, com.moji.dialog.MJDialog mJDialog, com.moji.influenza.view.InfluenzaSubscribeNoticeDialog influenzaSubscribeNoticeDialog) {
        this.n = editText;
        this.t = mJDialog;
        this.u = influenzaSubscribeNoticeDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.influenza.view.InfluenzaSubscribeNoticeDialog.a(this.n, this.t, this.u, view);
    }
}
