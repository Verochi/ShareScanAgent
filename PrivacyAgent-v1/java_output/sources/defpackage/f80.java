package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class f80 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction t;

    public /* synthetic */ f80(java.util.ArrayList arrayList, com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction earthquakeMapFunction) {
        this.n = arrayList;
        this.t = earthquakeMapFunction;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction.j(this.n, this.t, view);
    }
}
