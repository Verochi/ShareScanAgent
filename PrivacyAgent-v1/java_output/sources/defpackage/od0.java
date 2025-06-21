package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class od0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjfishing.model.FishingHomeModel n;
    public final /* synthetic */ java.util.List t;

    public /* synthetic */ od0(com.moji.mjfishing.model.FishingHomeModel fishingHomeModel, java.util.List list) {
        this.n = fishingHomeModel;
        this.t = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjfishing.model.FishingHomeModel.getAdDynamicData.1.b(this.n, this.t);
    }
}
