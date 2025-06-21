package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class n5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.material.network.AdRequestMaterialCallback n;
    public final /* synthetic */ java.lang.Object t;

    public /* synthetic */ n5(com.moji.mjad.material.network.AdRequestMaterialCallback adRequestMaterialCallback, java.lang.Object obj) {
        this.n = adRequestMaterialCallback;
        this.t = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.material.network.AdRequestMaterialCallback.b(this.n, this.t);
    }
}
