package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class hw1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newmember.order.presenter.OrderPayPresenter n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ hw1(com.moji.newmember.order.presenter.OrderPayPresenter orderPayPresenter, java.lang.String str) {
        this.n = orderPayPresenter;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newmember.order.presenter.OrderPayPresenter.a(this.n, this.t);
    }
}
