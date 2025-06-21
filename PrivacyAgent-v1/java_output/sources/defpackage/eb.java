package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class eb implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.view.AppUpdateDialog.Builder n;
    public final /* synthetic */ com.moji.appupdate.view.AppUpdateDialog t;

    public /* synthetic */ eb(com.moji.appupdate.view.AppUpdateDialog.Builder builder, com.moji.appupdate.view.AppUpdateDialog appUpdateDialog) {
        this.n = builder;
        this.t = appUpdateDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.appupdate.view.AppUpdateDialog.Builder.a(this.n, this.t, view);
    }
}
