package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class bz2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment n;
    public final /* synthetic */ com.moji.mjad.tab.SplashTimeEvent t;

    public /* synthetic */ bz2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, com.moji.mjad.tab.SplashTimeEvent splashTimeEvent) {
        this.n = tabWeatherV9Fragment;
        this.t = splashTimeEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.TabWeatherV9Fragment.u(this.n, this.t);
    }
}
