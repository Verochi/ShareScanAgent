package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xh3 implements com.moji.mvpframe.delegate.ILoadingCallback {
    public final /* synthetic */ com.moji.mjweather.weather.WeatherPagePresenter a;
    public final /* synthetic */ com.moji.mjweather.TabWeatherFragment b;

    public /* synthetic */ xh3(com.moji.mjweather.weather.WeatherPagePresenter weatherPagePresenter, com.moji.mjweather.TabWeatherFragment tabWeatherFragment) {
        this.a = weatherPagePresenter;
        this.b = tabWeatherFragment;
    }

    public final void onDialogDismiss() {
        com.moji.mjweather.weather.WeatherPagePresenter.c(this.a, this.b);
    }
}
