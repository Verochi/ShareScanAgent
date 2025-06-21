package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class c73 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeReleaseInSettingCenter n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ java.io.File u;

    public /* synthetic */ c73(com.moji.appupdate.UpgradeReleaseInSettingCenter upgradeReleaseInSettingCenter, boolean z, java.io.File file) {
        this.n = upgradeReleaseInSettingCenter;
        this.t = z;
        this.u = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeReleaseInSettingCenter.d(this.n, this.t, this.u, dialogInterface, i);
    }
}
