package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class h92 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction n;
    public final /* synthetic */ com.moji.shorttime.ui.timeline.MJMapTimeline t;

    public /* synthetic */ h92(com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction rainSnowRadarMapFunction, com.moji.shorttime.ui.timeline.MJMapTimeline mJMapTimeline) {
        this.n = rainSnowRadarMapFunction;
        this.t = mJMapTimeline;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowRadarMapFunction.initRainSnowPlayerBar.1.a(this.n, this.t);
    }
}
