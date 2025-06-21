package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class wn2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.toolmatrix.solarterms.SolarTermsActivity n;

    public /* synthetic */ wn2(com.moji.toolmatrix.solarterms.SolarTermsActivity solarTermsActivity) {
        this.n = solarTermsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.toolmatrix.solarterms.SolarTermsActivity.b(this.n, (com.moji.http.toolmatrix.entity.SolarTermsResult) obj);
    }
}
