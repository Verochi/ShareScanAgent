package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class s01 implements com.airbnb.lottie.ImageAssetDelegate {
    public final /* synthetic */ java.lang.String a;

    public /* synthetic */ s01(java.lang.String str) {
        this.a = str;
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public final android.graphics.Bitmap fetchBitmap(com.airbnb.lottie.LottieImageAsset lottieImageAsset) {
        return com.moji.lottie.LottieAnimationUtils.c(this.a, lottieImageAsset);
    }
}
