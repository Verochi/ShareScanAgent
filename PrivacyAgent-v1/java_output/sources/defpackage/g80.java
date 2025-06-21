package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class g80 implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction n;

    public /* synthetic */ g80(com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction earthquakeMapFunction) {
        this.n = earthquakeMapFunction;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.shorttime.ui.function.earthquake.EarthquakeMapFunction.q(this.n, compoundButton, z);
    }
}
