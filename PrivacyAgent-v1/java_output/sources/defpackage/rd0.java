package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class rd0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.card.OperationCardViewModel n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ com.moji.mjfishing.FishingMainActivity u;

    public /* synthetic */ rd0(com.moji.card.OperationCardViewModel operationCardViewModel, com.moji.common.area.AreaInfo areaInfo, com.moji.mjfishing.FishingMainActivity fishingMainActivity) {
        this.n = operationCardViewModel;
        this.t = areaInfo;
        this.u = fishingMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.FishingMainActivity.i(this.n, this.t, this.u, (com.moji.card.event.OpCardChangeEvent) obj);
    }
}
