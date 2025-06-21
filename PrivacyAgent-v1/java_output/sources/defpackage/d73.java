package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class d73 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeReleaseInSettingCenter n;

    public /* synthetic */ d73(com.moji.appupdate.UpgradeReleaseInSettingCenter upgradeReleaseInSettingCenter) {
        this.n = upgradeReleaseInSettingCenter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeReleaseInSettingCenter.e(this.n, dialogInterface, i);
    }
}
