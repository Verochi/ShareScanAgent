package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class sa1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter n;
    public final /* synthetic */ int t;

    public /* synthetic */ sa1(com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter mainWeatherCorrectViewPresenter, int i) {
        this.n = mainWeatherCorrectViewPresenter;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter.d(this.n, this.t);
    }
}
