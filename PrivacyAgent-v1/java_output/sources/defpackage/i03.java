package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class i03 implements java.lang.Runnable {
    public final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ i03(com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout tanxWebFrameLayout, boolean z) {
        this.n = tanxWebFrameLayout;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$showErrorUi$0(this.t);
    }
}
