package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class qv implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity n;

    public /* synthetic */ qv(com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity dangerousDrivingForecastActivity) {
        this.n = dangerousDrivingForecastActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity.x(this.n, (com.moji.http.member.benefits.entity.DangerousDrivingForecastResult) obj);
    }
}
