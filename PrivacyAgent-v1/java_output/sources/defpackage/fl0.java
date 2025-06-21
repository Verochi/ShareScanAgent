package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class fl0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.credit.GiftDetailsActivity n;
    public final /* synthetic */ com.moji.http.credit.entity.GiftListResp.Gift t;

    public /* synthetic */ fl0(com.moji.credit.GiftDetailsActivity giftDetailsActivity, com.moji.http.credit.entity.GiftListResp.Gift gift) {
        this.n = giftDetailsActivity;
        this.t = gift;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.credit.GiftDetailsActivity.b(this.n, this.t, view);
    }
}
