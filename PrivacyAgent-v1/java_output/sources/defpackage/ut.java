package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class ut implements kotlin.jvm.functions.Function1 {
    public final /* synthetic */ com.moji.credit.CreditSignActivity n;
    public final /* synthetic */ org.json.JSONObject t;

    public /* synthetic */ ut(com.moji.credit.CreditSignActivity creditSignActivity, org.json.JSONObject jSONObject) {
        this.n = creditSignActivity;
        this.t = jSONObject;
    }

    @Override // kotlin.jvm.functions.Function1
    public final java.lang.Object invoke(java.lang.Object obj) {
        return com.moji.credit.CreditSignActivity.b(this.n, this.t, (java.lang.Integer) obj);
    }
}
