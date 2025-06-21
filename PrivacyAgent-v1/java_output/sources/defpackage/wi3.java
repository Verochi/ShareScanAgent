package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class wi3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.weatherpain.WeatherPainActivity n;
    public final /* synthetic */ com.moji.http.weatherpain.entity.WeatherPainResult.VIPConfig t;

    public /* synthetic */ wi3(com.moji.weatherpain.WeatherPainActivity weatherPainActivity, com.moji.http.weatherpain.entity.WeatherPainResult.VIPConfig vIPConfig) {
        this.n = weatherPainActivity;
        this.t = vIPConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.weatherpain.WeatherPainActivity.l(this.n, this.t, view);
    }
}
