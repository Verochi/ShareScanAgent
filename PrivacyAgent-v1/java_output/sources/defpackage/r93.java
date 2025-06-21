package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class r93 implements java.lang.Runnable {
    public final /* synthetic */ com.alimm.tanx.core.view.player.cache.VideoGetSizeManager n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ com.alimm.tanx.core.ad.ITanxAd u;

    public /* synthetic */ r93(com.alimm.tanx.core.view.player.cache.VideoGetSizeManager videoGetSizeManager, java.lang.String str, com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        this.n = videoGetSizeManager;
        this.t = str;
        this.u = iTanxAd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$getVideoSize$14(this.t, this.u);
    }
}
