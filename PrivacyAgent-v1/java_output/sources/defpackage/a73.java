package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class a73 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeReleaseInHomeCenter n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ java.io.File u;

    public /* synthetic */ a73(com.moji.appupdate.UpgradeReleaseInHomeCenter upgradeReleaseInHomeCenter, boolean z, java.io.File file) {
        this.n = upgradeReleaseInHomeCenter;
        this.t = z;
        this.u = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeReleaseInHomeCenter.d(this.n, this.t, this.u, dialogInterface, i);
    }
}
