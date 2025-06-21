package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class g92 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction n;

    public /* synthetic */ g92(com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction rainSnowRadarMapFunction) {
        this.n = rainSnowRadarMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction.m(this.n, (java.util.Map) obj);
    }
}
