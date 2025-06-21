package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hh3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.adapter.ViewControlAdapter n;

    public /* synthetic */ hh3(com.moji.mjweather.weather.adapter.ViewControlAdapter viewControlAdapter) {
        this.n = viewControlAdapter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.viewmodel.WeatherPageModel.b(this.n, (com.moji.weatherprovider.data.Weather) obj);
    }
}
