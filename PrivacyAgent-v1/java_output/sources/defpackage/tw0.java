package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class tw0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.liveview.home.near.model.LiveCityViewModel n;
    public final /* synthetic */ com.moji.weather.bean.protobuf.MojiWeather.Weather t;

    public /* synthetic */ tw0(com.moji.liveview.home.near.model.LiveCityViewModel liveCityViewModel, com.moji.weather.bean.protobuf.MojiWeather.Weather weather) {
        this.n = liveCityViewModel;
        this.t = weather;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview.home.near.model.LiveCityViewModel.loadRealWeatherData.1.callback.1.a(this.n, this.t);
    }
}
