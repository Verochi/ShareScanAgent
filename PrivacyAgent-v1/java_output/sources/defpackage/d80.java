package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class d80 implements androidx.activity.result.ActivityResultCallback {
    public final /* synthetic */ com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction a;

    public /* synthetic */ d80(com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction earthquakeMapFunction) {
        this.a = earthquakeMapFunction;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(java.lang.Object obj) {
        com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction.k(this.a, (androidx.activity.result.ActivityResult) obj);
    }
}
