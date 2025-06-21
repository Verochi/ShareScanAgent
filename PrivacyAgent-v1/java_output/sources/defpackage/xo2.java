package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class xo2 implements java.lang.Runnable {
    public final /* synthetic */ androidx.fragment.app.FragmentActivity n;
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl t;

    public /* synthetic */ xo2(androidx.fragment.app.FragmentActivity fragmentActivity, com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl) {
        this.n = fragmentActivity;
        this.t = splashSDKDownloadControl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.k(this.n, this.t);
    }
}
