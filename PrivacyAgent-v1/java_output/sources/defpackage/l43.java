package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class l43 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.view.TwoDaysForecastView n;

    public /* synthetic */ l43(com.moji.mjweather.weather.view.TwoDaysForecastView twoDaysForecastView) {
        this.n = twoDaysForecastView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.view.TwoDaysForecastView.a(this.n, (kotlin.Unit) obj);
    }
}
