package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class io2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl n;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplash t;

    public /* synthetic */ io2(com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl, com.moji.mjad.splash.data.AdSplash adSplash) {
        this.n = splashSDKDownloadControl;
        this.t = adSplash;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.o(this.n, this.t);
    }
}
