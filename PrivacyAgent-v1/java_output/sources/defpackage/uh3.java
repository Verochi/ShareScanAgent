package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class uh3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.viewmodel.WeatherPageModel n;
    public final /* synthetic */ com.moji.mjweather.weather.adapter.ViewControlAdapter t;

    public /* synthetic */ uh3(com.moji.mjweather.weather.viewmodel.WeatherPageModel weatherPageModel, com.moji.mjweather.weather.adapter.ViewControlAdapter viewControlAdapter) {
        this.n = weatherPageModel;
        this.t = viewControlAdapter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.viewmodel.WeatherPageModel.j(this.n, this.t, (com.moji.weatherprovider.data.Weather) obj);
    }
}
