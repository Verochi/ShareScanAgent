package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class qx implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CurveFragment n;

    public /* synthetic */ qx(com.moji.mj40dayforecast.fragment.Days40CurveFragment days40CurveFragment) {
        this.n = days40CurveFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj40dayforecast.fragment.Days40CurveFragment.b(this.n, (com.moji.mj40dayforecast.data.ForecastOptimize) obj);
    }
}
