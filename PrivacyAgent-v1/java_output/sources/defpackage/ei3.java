package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ei3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.WeatherPageView n;
    public final /* synthetic */ com.moji.mjweather.weather.viewmodel.WeatherPageModel t;
    public final /* synthetic */ com.moji.weatherprovider.data.Weather u;

    public /* synthetic */ ei3(com.moji.mjweather.weather.WeatherPageView weatherPageView, com.moji.mjweather.weather.viewmodel.WeatherPageModel weatherPageModel, com.moji.weatherprovider.data.Weather weather) {
        this.n = weatherPageView;
        this.t = weatherPageModel;
        this.u = weather;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.WeatherPageView.r(this.n, this.t, this.u);
    }
}
