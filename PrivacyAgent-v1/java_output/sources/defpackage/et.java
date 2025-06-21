package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class et implements java.lang.Runnable {
    public final /* synthetic */ com.moji.credit.fragment.CreditHomeCardNewFragment n;
    public final /* synthetic */ com.moji.http.credit.entity.CreditHomeResp t;

    public /* synthetic */ et(com.moji.credit.fragment.CreditHomeCardNewFragment creditHomeCardNewFragment, com.moji.http.credit.entity.CreditHomeResp creditHomeResp) {
        this.n = creditHomeCardNewFragment;
        this.t = creditHomeResp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.credit.fragment.CreditHomeCardNewFragment.c(this.n, this.t);
    }
}
