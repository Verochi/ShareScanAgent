package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class tn0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.guide.GuideDialog n;
    public final /* synthetic */ com.moji.mjweather.guide.HomeGuideManager t;

    public /* synthetic */ tn0(com.moji.mjweather.guide.GuideDialog guideDialog, com.moji.mjweather.guide.HomeGuideManager homeGuideManager) {
        this.n = guideDialog;
        this.t = homeGuideManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.guide.HomeGuideManager.showGuide.1.1.a(this.n, this.t);
    }
}
