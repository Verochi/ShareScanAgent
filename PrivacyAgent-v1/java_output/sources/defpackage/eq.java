package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class eq implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjcommand.CommandDialog n;
    public final /* synthetic */ com.moji.mjcommand.CommandAlert t;
    public final /* synthetic */ android.app.Dialog u;

    public /* synthetic */ eq(com.moji.mjcommand.CommandDialog commandDialog, com.moji.mjcommand.CommandAlert commandAlert, android.app.Dialog dialog) {
        this.n = commandDialog;
        this.t = commandAlert;
        this.u = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjcommand.CommandDialog.c(this.n, this.t, this.u, view);
    }
}
