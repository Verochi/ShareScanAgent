package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class rv1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.card.view.product.OpCardProductItem n;
    public final /* synthetic */ com.moji.http.flycard.resp.CardInfo t;

    public /* synthetic */ rv1(com.moji.card.view.product.OpCardProductItem opCardProductItem, com.moji.http.flycard.resp.CardInfo cardInfo) {
        this.n = opCardProductItem;
        this.t = cardInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.card.view.product.OpCardProductItem.a(this.n, this.t);
    }
}
