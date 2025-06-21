package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class g03 implements java.lang.Runnable {
    public final /* synthetic */ com.alimm.tanx.core.bridge.TanxJsBridge n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ g03(com.alimm.tanx.core.bridge.TanxJsBridge tanxJsBridge, java.lang.String str) {
        this.n = tanxJsBridge;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$dispatch$4(this.t);
    }
}
