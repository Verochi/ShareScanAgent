package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class o61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.weather.MJWeatherRenderer n;
    public final /* synthetic */ com.moji.weatherprovider.data.Avatar t;

    public /* synthetic */ o61(com.moji.weathersence.weather.MJWeatherRenderer mJWeatherRenderer, com.moji.weatherprovider.data.Avatar avatar) {
        this.n = mJWeatherRenderer;
        this.t = avatar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.weather.MJWeatherRenderer.a(this.n, this.t);
    }
}
