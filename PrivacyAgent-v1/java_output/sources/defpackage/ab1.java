package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ab1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter n;
    public final /* synthetic */ int t;

    public /* synthetic */ ab1(com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter mainWeatherCorrectViewPresenter, int i) {
        this.n = mainWeatherCorrectViewPresenter;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter.showSelectedAnimation.1.1.a(this.n, this.t);
    }
}
