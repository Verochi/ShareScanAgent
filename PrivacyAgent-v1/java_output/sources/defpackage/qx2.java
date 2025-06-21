package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class qx2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment n;
    public final /* synthetic */ com.moji.mjad.tab.SplashTimeEvent t;

    public /* synthetic */ qx2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment, com.moji.mjad.tab.SplashTimeEvent splashTimeEvent) {
        this.n = tabWeatherBetaFragment;
        this.t = splashTimeEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.TabWeatherBetaFragment.x(this.n, this.t);
    }
}
