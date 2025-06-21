package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class jp2 implements com.airbnb.lottie.ImageAssetDelegate {
    public final /* synthetic */ java.lang.String a;

    public /* synthetic */ jp2(java.lang.String str) {
        this.a = str;
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public final android.graphics.Bitmap fetchBitmap(com.airbnb.lottie.LottieImageAsset lottieImageAsset) {
        return com.moji.mjad.splash.lottie.SplashTipsDrawableLoader.Companion.f(this.a, lottieImageAsset);
    }
}
