package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class te3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView n;

    public /* synthetic */ te3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView) {
        this.n = weatherAndShortView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.view.WeatherAndShortView.m(this.n, (com.moji.mjweather.weathercorrect.MainWeatherCorrectViewModel.ShowAdResult) obj);
    }
}
