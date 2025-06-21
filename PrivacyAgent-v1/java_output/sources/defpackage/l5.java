package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class l5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.material.network.AdRequestMaterialCallback n;
    public final /* synthetic */ long t;
    public final /* synthetic */ long u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ l5(com.moji.mjad.material.network.AdRequestMaterialCallback adRequestMaterialCallback, long j, long j2, java.lang.String str) {
        this.n = adRequestMaterialCallback;
        this.t = j;
        this.u = j2;
        this.v = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.material.network.AdRequestMaterialCallback.a(this.n, this.t, this.u, this.v);
    }
}
