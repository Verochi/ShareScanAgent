package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class e80 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction t;

    public /* synthetic */ e80(java.util.ArrayList arrayList, com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction earthquakeMapFunction) {
        this.n = arrayList;
        this.t = earthquakeMapFunction;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction.l(this.n, this.t, view);
    }
}
