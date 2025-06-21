package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class yo2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjad.splash.bid.SplashSDKDownloadControl n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.LongRef t;
    public final /* synthetic */ java.util.List u;

    public /* synthetic */ yo2(com.moji.mjad.splash.bid.SplashSDKDownloadControl splashSDKDownloadControl, kotlin.jvm.internal.Ref.LongRef longRef, java.util.List list) {
        this.n = splashSDKDownloadControl;
        this.t = longRef;
        this.u = list;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjad.splash.bid.SplashSDKDownloadControl.t(this.n, this.t, this.u, (java.lang.Long) obj);
    }
}
