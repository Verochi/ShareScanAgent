package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class q82 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48hRadarMapFunction n;
    public final /* synthetic */ com.moji.shorttime.ui.timeline.MJMapTimeline t;

    public /* synthetic */ q82(com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48hRadarMapFunction rain48hRadarMapFunction, com.moji.shorttime.ui.timeline.MJMapTimeline mJMapTimeline) {
        this.n = rain48hRadarMapFunction;
        this.t = mJMapTimeline;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48hRadarMapFunction.initRain48HPlayerBar.1.a(this.n, this.t);
    }
}
