package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class n61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.weather.MJWeatherRenderer n;

    public /* synthetic */ n61(com.moji.weathersence.weather.MJWeatherRenderer mJWeatherRenderer) {
        this.n = mJWeatherRenderer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.weather.MJWeatherRenderer.b(this.n);
    }
}
