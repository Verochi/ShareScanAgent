package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class dl2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.skeletonad.SkeletonAdBgBridgeImpl n;
    public final /* synthetic */ com.moji.weathersence.skeletonad.SkeletonAdBgResourceWrapper t;
    public final /* synthetic */ com.moji.weathersence.skeletonad.SkeletonAdBgCallBack u;
    public final /* synthetic */ long v;
    public final /* synthetic */ java.lang.String w;

    public /* synthetic */ dl2(com.moji.weathersence.skeletonad.SkeletonAdBgBridgeImpl skeletonAdBgBridgeImpl, com.moji.weathersence.skeletonad.SkeletonAdBgResourceWrapper skeletonAdBgResourceWrapper, com.moji.weathersence.skeletonad.SkeletonAdBgCallBack skeletonAdBgCallBack, long j, java.lang.String str) {
        this.n = skeletonAdBgBridgeImpl;
        this.t = skeletonAdBgResourceWrapper;
        this.u = skeletonAdBgCallBack;
        this.v = j;
        this.w = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.skeletonad.SkeletonAdBgBridgeImpl.a(this.n, this.t, this.u, this.v, this.w);
    }
}
