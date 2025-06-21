package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class zs implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.credit.CreditHomeActivity n;

    public /* synthetic */ zs(com.moji.credit.CreditHomeActivity creditHomeActivity) {
        this.n = creditHomeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.credit.CreditHomeActivity.f(this.n, (java.util.ArrayList) obj);
    }
}
