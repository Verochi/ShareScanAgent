package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class cl2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.skeletonad.SkeletonAdBgBridgeImpl n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ com.moji.weathersence.skeletonad.OnSkeletonAdBgClickListener u;

    public /* synthetic */ cl2(com.moji.weathersence.skeletonad.SkeletonAdBgBridgeImpl skeletonAdBgBridgeImpl, com.moji.common.area.AreaInfo areaInfo, com.moji.weathersence.skeletonad.OnSkeletonAdBgClickListener onSkeletonAdBgClickListener) {
        this.n = skeletonAdBgBridgeImpl;
        this.t = areaInfo;
        this.u = onSkeletonAdBgClickListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.skeletonad.SkeletonAdBgBridgeImpl.b(this.n, this.t, this.u);
    }
}
