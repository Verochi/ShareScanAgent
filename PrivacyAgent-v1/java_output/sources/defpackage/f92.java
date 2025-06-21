package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class f92 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction n;

    public /* synthetic */ f92(com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction rainSnowRadarMapFunction) {
        this.n = rainSnowRadarMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction.k(this.n, (com.moji.shorttime.ui.RadarProgressBarStateWrapper) obj);
    }
}
