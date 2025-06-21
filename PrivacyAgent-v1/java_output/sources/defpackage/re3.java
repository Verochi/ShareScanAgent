package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class re3 implements com.moji.mjweather.weather.util.ObservableInt.ValueChangeListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView a;

    public /* synthetic */ re3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView) {
        this.a = weatherAndShortView;
    }

    public final void onValueChane(int i) {
        com.moji.mjweather.weather.view.WeatherAndShortView.h(this.a, i);
    }
}
