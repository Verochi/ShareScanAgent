package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class mb1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.mapleleaves.MapleLeavesMapFunction n;

    public /* synthetic */ mb1(com.moji.shorttime.ui.function.mapleleaves.MapleLeavesMapFunction mapleLeavesMapFunction) {
        this.n = mapleLeavesMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.mapleleaves.MapleLeavesMapFunction.m(this.n, (com.moji.shorttime.ui.RadarProgressBarStateWrapper) obj);
    }
}
