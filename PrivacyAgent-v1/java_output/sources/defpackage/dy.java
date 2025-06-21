package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class dy implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40TrendFragment n;

    public /* synthetic */ dy(com.moji.mj40dayforecast.fragment.Days40TrendFragment days40TrendFragment) {
        this.n = days40TrendFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj40dayforecast.fragment.Days40TrendFragment.b(this.n, (com.moji.mj40dayforecast.data.ForecastOptimize) obj);
    }
}
