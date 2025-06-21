package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class bp2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashThird n;
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl t;

    public /* synthetic */ bp2(com.moji.mjad.splash.data.AdSplashThird adSplashThird, com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl) {
        this.n = adSplashThird;
        this.t = splashSDKDownloadControl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.m(this.n, this.t);
    }
}
