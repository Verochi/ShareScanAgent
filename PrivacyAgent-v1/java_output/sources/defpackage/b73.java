package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b73 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeReleaseInHomeCenter n;

    public /* synthetic */ b73(com.moji.appupdate.UpgradeReleaseInHomeCenter upgradeReleaseInHomeCenter) {
        this.n = upgradeReleaseInHomeCenter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeReleaseInHomeCenter.e(this.n, dialogInterface, i);
    }
}
