package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class m5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.material.network.AdRequestMaterialCallback n;
    public final /* synthetic */ com.moji.mjad.enumdata.ERROR_CODE t;

    public /* synthetic */ m5(com.moji.mjad.material.network.AdRequestMaterialCallback adRequestMaterialCallback, com.moji.mjad.enumdata.ERROR_CODE error_code) {
        this.n = adRequestMaterialCallback;
        this.t = error_code;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.material.network.AdRequestMaterialCallback.c(this.n, this.t);
    }
}
