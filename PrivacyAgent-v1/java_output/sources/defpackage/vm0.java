package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class vm0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity n;

    public /* synthetic */ vm0(com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity historicalTyphoonActivity) {
        this.n = historicalTyphoonActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity.f(this.n, (com.moji.http.show.entity.TyphoonDetail) obj);
    }
}
