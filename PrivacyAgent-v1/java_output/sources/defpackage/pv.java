package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class pv implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity n;

    public /* synthetic */ pv(com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity dangerousDrivingForecastActivity) {
        this.n = dangerousDrivingForecastActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity.p(this.n, (com.moji.http.member.benefits.entity.DangerousDrivignHomeResult) obj);
    }
}
