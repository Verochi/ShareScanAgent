package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class r01 implements com.airbnb.lottie.ImageAssetDelegate {
    public final /* synthetic */ java.lang.String a;

    public /* synthetic */ r01(java.lang.String str) {
        this.a = str;
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public final android.graphics.Bitmap fetchBitmap(com.airbnb.lottie.LottieImageAsset lottieImageAsset) {
        return com.moji.mjweather.LottieAnimationUtils.b(this.a, lottieImageAsset);
    }
}
