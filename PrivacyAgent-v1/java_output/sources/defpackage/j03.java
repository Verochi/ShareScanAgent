package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class j03 implements java.lang.Runnable {
    public final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ j03(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout tanxWebFrameLayout, boolean z) {
        this.n = tanxWebFrameLayout;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$loading$1(this.t);
    }
}
