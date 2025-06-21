package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class iw1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newmember.order.presenter.OrderPayPresenter n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ int u;

    public /* synthetic */ iw1(com.moji.newmember.order.presenter.OrderPayPresenter orderPayPresenter, java.lang.String str, int i) {
        this.n = orderPayPresenter;
        this.t = str;
        this.u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newmember.order.presenter.OrderPayPresenter.b(this.n, this.t, this.u);
    }
}
