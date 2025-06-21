package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class az2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ az2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, int i, int i2) {
        this.n = tabWeatherV9Fragment;
        this.t = i;
        this.u = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.TabWeatherV9Fragment.J(this.n, this.t, this.u);
    }
}
