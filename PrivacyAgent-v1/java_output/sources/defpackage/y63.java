package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class y63 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeBetaInSettingCenter n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ java.io.File u;

    public /* synthetic */ y63(com.moji.appupdate.UpgradeBetaInSettingCenter upgradeBetaInSettingCenter, boolean z, java.io.File file) {
        this.n = upgradeBetaInSettingCenter;
        this.t = z;
        this.u = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeBetaInSettingCenter.d(this.n, this.t, this.u, dialogInterface, i);
    }
}
