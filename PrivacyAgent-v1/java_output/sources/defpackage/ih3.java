package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ih3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.viewmodel.WeatherPageModel n;
    public final /* synthetic */ com.moji.mjweather.weather.adapter.ViewControlAdapter t;

    public /* synthetic */ ih3(com.moji.mjweather.weather.viewmodel.WeatherPageModel weatherPageModel, com.moji.mjweather.weather.adapter.ViewControlAdapter viewControlAdapter) {
        this.n = weatherPageModel;
        this.t = viewControlAdapter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.viewmodel.WeatherPageModel.h(this.n, this.t, (com.moji.weatherprovider.data.Weather) obj);
    }
}
