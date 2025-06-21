package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class b23 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newmember.order.presenter.TicketPresenter n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.IntRef t;
    public final /* synthetic */ com.moji.http.member.entity.PricesResult.MemberPrice u;
    public final /* synthetic */ int v;

    public /* synthetic */ b23(com.moji.newmember.order.presenter.TicketPresenter ticketPresenter, kotlin.jvm.internal.Ref.IntRef intRef, com.moji.http.member.entity.PricesResult.MemberPrice memberPrice, int i) {
        this.n = ticketPresenter;
        this.t = intRef;
        this.u = memberPrice;
        this.v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newmember.order.presenter.TicketPresenter.b(this.n, this.t, this.u, this.v);
    }
}
