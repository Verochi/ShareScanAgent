package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class ix implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CalenderFragment n;

    public /* synthetic */ ix(com.moji.mj40dayforecast.fragment.Days40CalenderFragment days40CalenderFragment) {
        this.n = days40CalenderFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj40dayforecast.fragment.Days40CalenderFragment.e(this.n, (com.moji.mj40dayforecast.data.ForecastOptimize) obj);
    }
}
