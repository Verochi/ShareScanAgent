package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class d0 implements java.lang.Runnable {
    public final /* synthetic */ java.util.List n;
    public final /* synthetic */ com.moji.mjad.base.network.AdRequestCallback t;
    public final /* synthetic */ com.moji.mjad.enumdata.ERROR_CODE u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ d0(java.util.List list, com.moji.mjad.base.network.AdRequestCallback adRequestCallback, com.moji.mjad.enumdata.ERROR_CODE error_code, java.lang.String str) {
        this.n = list;
        this.t = adRequestCallback;
        this.u = error_code;
        this.v = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.network.AbsAdIndexRequest.b(this.n, this.t, this.u, this.v);
    }
}
