package defpackage;

/* loaded from: classes26.dex */
public final /* synthetic */ class l60 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.card.OperationCardViewModel n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ com.moji.index.dress.DressActivity2 u;

    public /* synthetic */ l60(com.moji.card.OperationCardViewModel operationCardViewModel, com.moji.common.area.AreaInfo areaInfo, com.moji.index.dress.DressActivity2 dressActivity2) {
        this.n = operationCardViewModel;
        this.t = areaInfo;
        this.u = dressActivity2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.index.dress.DressActivity2.e(this.n, this.t, this.u, (com.moji.card.event.OpCardChangeEvent) obj);
    }
}
