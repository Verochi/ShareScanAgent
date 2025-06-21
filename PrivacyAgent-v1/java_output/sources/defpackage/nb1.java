package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class nb1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.mapleleaves.MapleLeavesMapFunction n;

    public /* synthetic */ nb1(com.moji.shorttime.ui.function.mapleleaves.MapleLeavesMapFunction mapleLeavesMapFunction) {
        this.n = mapleLeavesMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.mapleleaves.MapleLeavesMapFunction.k(this.n, (com.moji.entity.Result) obj);
    }
}
