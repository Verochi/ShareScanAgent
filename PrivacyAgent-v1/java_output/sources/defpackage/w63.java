package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class w63 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.moji.appupdate.UpgradeBetaInHomeCenter n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ java.io.File u;

    public /* synthetic */ w63(com.moji.appupdate.UpgradeBetaInHomeCenter upgradeBetaInHomeCenter, boolean z, java.io.File file) {
        this.n = upgradeBetaInHomeCenter;
        this.t = z;
        this.u = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        com.moji.appupdate.UpgradeBetaInHomeCenter.e(this.n, this.t, this.u, dialogInterface, i);
    }
}
