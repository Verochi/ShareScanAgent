package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class n72 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.RadarGenericMapFunction n;

    public /* synthetic */ n72(com.moji.shorttime.ui.function.radar_generic.RadarGenericMapFunction radarGenericMapFunction) {
        this.n = radarGenericMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.radar_generic.RadarGenericMapFunction.k(this.n, (com.moji.shorttime.ui.RadarProgressBarStateWrapper) obj);
    }
}
