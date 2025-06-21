package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class x5 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjad.splash.network.AdSplashShakeImagesDownloader a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashShakeInfo c;
    public final /* synthetic */ java.lang.String d;

    public /* synthetic */ x5(com.moji.mjad.splash.network.AdSplashShakeImagesDownloader adSplashShakeImagesDownloader, java.lang.String str, com.moji.mjad.splash.data.AdSplashShakeInfo adSplashShakeInfo, java.lang.String str2) {
        this.a = adSplashShakeImagesDownloader;
        this.b = str;
        this.c = adSplashShakeInfo;
        this.d = str2;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjad.splash.network.AdSplashShakeImagesDownloader.g(this.a, this.b, this.c, this.d, observableEmitter);
    }
}
