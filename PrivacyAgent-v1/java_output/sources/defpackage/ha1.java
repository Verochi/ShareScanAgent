package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ha1 implements com.airbnb.lottie.ImageAssetDelegate {
    public final /* synthetic */ java.lang.String a;

    public /* synthetic */ ha1(java.lang.String str) {
        this.a = str;
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public final android.graphics.Bitmap fetchBitmap(com.airbnb.lottie.LottieImageAsset lottieImageAsset) {
        return com.moji.mjweather.main.MainTabConfig.a(this.a, lottieImageAsset);
    }
}
