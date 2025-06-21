package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class ro2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl n;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashThird t;

    public /* synthetic */ ro2(com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl, com.moji.mjad.splash.data.AdSplashThird adSplashThird) {
        this.n = splashSDKDownloadControl;
        this.t = adSplashThird;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.a(this.n, this.t);
    }
}
