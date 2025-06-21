package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class oe3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ com.moji.weatherprovider.data.Detail u;
    public final /* synthetic */ boolean v;
    public final /* synthetic */ boolean w;

    public /* synthetic */ oe3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView, com.moji.common.area.AreaInfo areaInfo, com.moji.weatherprovider.data.Detail detail, boolean z, boolean z2) {
        this.n = weatherAndShortView;
        this.t = areaInfo;
        this.u = detail;
        this.v = z;
        this.w = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.WeatherAndShortView.e(this.n, this.t, this.u, this.v, this.w);
    }
}
