package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class e8 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.auth.AlipayAuthV2 n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ e8(com.moji.auth.AlipayAuthV2 alipayAuthV2, java.lang.String str) {
        this.n = alipayAuthV2;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.auth.AlipayAuthV2.a(this.n, this.t);
    }
}
