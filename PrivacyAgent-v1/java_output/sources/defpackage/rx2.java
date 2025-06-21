package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class rx2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ rx2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment, int i, int i2) {
        this.n = tabWeatherBetaFragment;
        this.t = i;
        this.u = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.TabWeatherBetaFragment.h(this.n, this.t, this.u);
    }
}
