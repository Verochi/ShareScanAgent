package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class mv implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity n;
    public final /* synthetic */ com.moji.http.member.benefits.entity.DangerousDrivignHomeResult.VIPConfig t;

    public /* synthetic */ mv(com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity dangerousDrivingForecastActivity, com.moji.http.member.benefits.entity.DangerousDrivignHomeResult.VIPConfig vIPConfig) {
        this.n = dangerousDrivingForecastActivity;
        this.t = vIPConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity.y(this.n, this.t, view);
    }
}
