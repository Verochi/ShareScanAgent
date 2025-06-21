package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class me3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ com.moji.weatherprovider.data.Detail u;

    public /* synthetic */ me3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView, com.moji.common.area.AreaInfo areaInfo, com.moji.weatherprovider.data.Detail detail) {
        this.n = weatherAndShortView;
        this.t = areaInfo;
        this.u = detail;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.WeatherAndShortView.k(this.n, this.t, this.u);
    }
}
