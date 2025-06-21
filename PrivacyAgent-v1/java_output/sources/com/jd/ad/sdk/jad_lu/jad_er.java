package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_er implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
    public final /* synthetic */ int jad_an;
    public final /* synthetic */ com.jd.ad.sdk.lottie.LottieAnimationView jad_bo;

    public jad_er(com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView, int i) {
        this.jad_bo = lottieAnimationView;
        this.jad_an = i;
    }

    @Override // java.util.concurrent.Callable
    public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = this.jad_bo;
        if (!lottieAnimationView.jad_na) {
            return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(lottieAnimationView.getContext(), this.jad_an, (java.lang.String) null);
        }
        android.content.Context context = lottieAnimationView.getContext();
        int i = this.jad_an;
        return com.jd.ad.sdk.jad_lu.jad_hu.jad_an(context, i, com.jd.ad.sdk.jad_lu.jad_hu.jad_an(context, i));
    }
}
