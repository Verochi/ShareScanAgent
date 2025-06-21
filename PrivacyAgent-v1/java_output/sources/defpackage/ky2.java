package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class ky2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment n;

    public /* synthetic */ ky2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment) {
        this.n = tabWeatherBetaFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.TabWeatherBetaFragment.l(this.n, (java.util.HashMap) obj);
    }
}
