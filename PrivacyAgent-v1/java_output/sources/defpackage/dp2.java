package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class dp2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl n;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashThird t;

    public /* synthetic */ dp2(com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl, com.moji.mjad.splash.data.AdSplashThird adSplashThird) {
        this.n = splashSDKDownloadControl;
        this.t = adSplashThird;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.loadThirdXiaomiScreenAd.2.onServiceConnected.1.a(this.n, this.t);
    }
}
