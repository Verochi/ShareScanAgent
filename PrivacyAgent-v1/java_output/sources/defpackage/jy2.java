package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class jy2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment n;

    public /* synthetic */ jy2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment) {
        this.n = tabWeatherBetaFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.TabWeatherBetaFragment.d(this.n, (java.util.HashMap) obj);
    }
}
