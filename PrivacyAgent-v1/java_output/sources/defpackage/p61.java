package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class p61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.weather.MJWeatherRenderer n;
    public final /* synthetic */ int t;
    public final /* synthetic */ boolean u;
    public final /* synthetic */ boolean v;

    public /* synthetic */ p61(com.moji.weathersence.weather.MJWeatherRenderer mJWeatherRenderer, int i, boolean z, boolean z2) {
        this.n = mJWeatherRenderer;
        this.t = i;
        this.u = z;
        this.v = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.weather.MJWeatherRenderer.c(this.n, this.t, this.u, this.v);
    }
}
