package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class o82 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48hRadarMapFunction n;

    public /* synthetic */ o82(com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48hRadarMapFunction rain48hRadarMapFunction) {
        this.n = rain48hRadarMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48hRadarMapFunction.o(this.n, (com.moji.shorttime.data.model.LightningMarker) obj);
    }
}
