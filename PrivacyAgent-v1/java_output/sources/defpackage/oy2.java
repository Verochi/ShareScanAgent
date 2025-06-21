package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class oy2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment n;

    public /* synthetic */ oy2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment) {
        this.n = tabWeatherV9Fragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.TabWeatherV9Fragment.p(this.n, (java.util.HashMap) obj);
    }
}
