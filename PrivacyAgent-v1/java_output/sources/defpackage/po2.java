package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class po2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ po2(com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl, boolean z) {
        this.n = splashSDKDownloadControl;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.p(this.n, this.t);
    }
}
