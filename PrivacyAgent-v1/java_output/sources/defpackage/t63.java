package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class t63 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeAlphaCenter n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ java.io.File u;
    public final /* synthetic */ android.app.Activity v;

    public /* synthetic */ t63(com.moji.appupdate.UpgradeAlphaCenter upgradeAlphaCenter, boolean z, java.io.File file, android.app.Activity activity) {
        this.n = upgradeAlphaCenter;
        this.t = z;
        this.u = file;
        this.v = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeAlphaCenter.d(this.n, this.t, this.u, this.v, dialogInterface, i);
    }
}
