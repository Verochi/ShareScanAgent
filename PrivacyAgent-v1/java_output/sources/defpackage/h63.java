package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class h63 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.typhoon.TyphoonRadarMapFunction n;

    public /* synthetic */ h63(com.moji.shorttime.ui.function.typhoon.TyphoonRadarMapFunction typhoonRadarMapFunction) {
        this.n = typhoonRadarMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.typhoon.TyphoonRadarMapFunction.j(this.n, (com.moji.entity.Result) obj);
    }
}
