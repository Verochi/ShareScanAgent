package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class h80 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction n;

    public /* synthetic */ h80(com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction earthquakeMapFunction) {
        this.n = earthquakeMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction.s(this.n, (com.moji.entity.Result) obj);
    }
}
