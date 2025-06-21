package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class fb implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.view.AppUpdateDialog.Builder n;
    public final /* synthetic */ com.moji.appupdate.view.AppUpdateDialog t;

    public /* synthetic */ fb(com.moji.appupdate.view.AppUpdateDialog.Builder builder, com.moji.appupdate.view.AppUpdateDialog appUpdateDialog) {
        this.n = builder;
        this.t = appUpdateDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.appupdate.view.AppUpdateDialog.Builder.d(this.n, this.t, view);
    }
}
