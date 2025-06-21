package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class sn0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.guide.HomeGuideManager n;
    public final /* synthetic */ com.moji.mjweather.guide.GuideDialog t;

    public /* synthetic */ sn0(com.moji.mjweather.guide.HomeGuideManager homeGuideManager, com.moji.mjweather.guide.GuideDialog guideDialog) {
        this.n = homeGuideManager;
        this.t = guideDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.guide.HomeGuideManager.showGuide.1.1.b(this.n, this.t);
    }
}
