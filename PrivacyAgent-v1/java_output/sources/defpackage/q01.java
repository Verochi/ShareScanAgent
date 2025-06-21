package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class q01 implements com.airbnb.lottie.LottieListener {
    public final /* synthetic */ com.moji.lottie.LottieAnimationUtils.LottieAnimationLoadLinster a;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef b;

    public /* synthetic */ q01(com.moji.lottie.LottieAnimationUtils.LottieAnimationLoadLinster lottieAnimationLoadLinster, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = lottieAnimationLoadLinster;
        this.b = objectRef;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(java.lang.Object obj) {
        com.moji.lottie.LottieAnimationUtils.f(this.a, this.b, (java.lang.Throwable) obj);
    }
}
