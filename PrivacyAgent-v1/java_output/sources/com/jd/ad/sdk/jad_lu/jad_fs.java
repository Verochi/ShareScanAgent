package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_fs implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
    public final /* synthetic */ java.lang.String jad_an;
    public final /* synthetic */ com.jd.ad.sdk.lottie.LottieAnimationView jad_bo;

    public jad_fs(com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView, java.lang.String str) {
        this.jad_bo = lottieAnimationView;
        this.jad_an = str;
    }

    @Override // java.util.concurrent.Callable
    public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = this.jad_bo;
        if (!lottieAnimationView.jad_na) {
            return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(lottieAnimationView.getContext(), this.jad_an, (java.lang.String) null);
        }
        android.content.Context context = lottieAnimationView.getContext();
        java.lang.String str = this.jad_an;
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
        return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(context, str, "asset_" + str);
    }
}
