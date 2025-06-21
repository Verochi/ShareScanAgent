package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class mo2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ kotlin.jvm.internal.Ref.LongRef n;
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl t;

    public /* synthetic */ mo2(kotlin.jvm.internal.Ref.LongRef longRef, com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl) {
        this.n = longRef;
        this.t = splashSDKDownloadControl;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.f(this.n, this.t, (java.lang.Long) obj);
    }
}
