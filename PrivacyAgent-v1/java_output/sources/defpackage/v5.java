package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class v5 implements io.reactivex.functions.Function {
    public final /* synthetic */ com.moji.mjad.splash.network.AdSplashShakeImagesDownloader n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashShakeInfo u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ v5(com.moji.mjad.splash.network.AdSplashShakeImagesDownloader adSplashShakeImagesDownloader, java.lang.String str, com.moji.mjad.splash.data.AdSplashShakeInfo adSplashShakeInfo, java.lang.String str2) {
        this.n = adSplashShakeImagesDownloader;
        this.t = str;
        this.u = adSplashShakeInfo;
        this.v = str2;
    }

    @Override // io.reactivex.functions.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        return com.moji.mjad.splash.network.AdSplashShakeImagesDownloader.a(this.n, this.t, this.u, this.v, (java.lang.String) obj);
    }
}
