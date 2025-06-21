package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class sh3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.page.structure.Module n;
    public final /* synthetic */ com.moji.mjweather.weather.viewmodel.WeatherPageModel t;
    public final /* synthetic */ com.moji.mjweather.weather.adapter.ViewControlAdapter u;

    public /* synthetic */ sh3(com.moji.page.structure.Module module, com.moji.mjweather.weather.viewmodel.WeatherPageModel weatherPageModel, com.moji.mjweather.weather.adapter.ViewControlAdapter viewControlAdapter) {
        this.n = module;
        this.t = weatherPageModel;
        this.u = viewControlAdapter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.viewmodel.WeatherPageModel.d(this.n, this.t, this.u, (com.moji.weatherprovider.data.Weather) obj);
    }
}
