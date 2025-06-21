package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class tt implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.credit.CreditMyRewardActivity n;

    public /* synthetic */ tt(com.moji.credit.CreditMyRewardActivity creditMyRewardActivity) {
        this.n = creditMyRewardActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.credit.CreditMyRewardActivity.b(this.n, (com.moji.http.credit.entity.CreditMyRewardDetailResp) obj);
    }
}
