package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class v01 implements com.airbnb.lottie.LottieListener {
    public final /* synthetic */ com.moji.mjweather.LottieAnimationLoadLinster a;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef b;

    public /* synthetic */ v01(com.moji.mjweather.LottieAnimationLoadLinster lottieAnimationLoadLinster, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = lottieAnimationLoadLinster;
        this.b = objectRef;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(java.lang.Object obj) {
        com.moji.mjweather.LottieAnimationUtils.c(this.a, this.b, (java.lang.Throwable) obj);
    }
}
