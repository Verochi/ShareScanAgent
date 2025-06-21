package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class qe3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView n;

    public /* synthetic */ qe3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView) {
        this.n = weatherAndShortView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.view.WeatherAndShortView.f(this.n, obj);
    }
}
