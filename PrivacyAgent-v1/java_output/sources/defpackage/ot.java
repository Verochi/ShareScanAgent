package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class ot implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.credit.entity.CreditHomeHotGoodsResp n;

    public /* synthetic */ ot(com.moji.http.credit.entity.CreditHomeHotGoodsResp creditHomeHotGoodsResp) {
        this.n = creditHomeHotGoodsResp;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.credit.control.CreditHomeMJShellZonesControl.a(this.n, view);
    }
}
