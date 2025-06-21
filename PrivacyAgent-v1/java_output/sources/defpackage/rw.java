package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class rw implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mj180dayforecast.Days180MainActivity n;
    public final /* synthetic */ com.moji.http.weatherpain.entity.WeatherPainResult.VIPConfig t;

    public /* synthetic */ rw(com.moji.mj180dayforecast.Days180MainActivity days180MainActivity, com.moji.http.weatherpain.entity.WeatherPainResult.VIPConfig vIPConfig) {
        this.n = days180MainActivity;
        this.t = vIPConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mj180dayforecast.Days180MainActivity.g(this.n, this.t, view);
    }
}
