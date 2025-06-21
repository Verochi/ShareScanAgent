package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class db implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.view.AppUpdateDialog.Builder n;
    public final /* synthetic */ com.moji.appupdate.view.AppUpdateDialog t;

    public /* synthetic */ db(com.moji.appupdate.view.AppUpdateDialog.Builder builder, com.moji.appupdate.view.AppUpdateDialog appUpdateDialog) {
        this.n = builder;
        this.t = appUpdateDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.appupdate.view.AppUpdateDialog.Builder.b(this.n, this.t, view);
    }
}
