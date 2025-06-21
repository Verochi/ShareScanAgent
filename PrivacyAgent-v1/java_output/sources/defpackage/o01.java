package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class o01 implements com.airbnb.lottie.LottieListener {
    public final /* synthetic */ com.airbnb.lottie.LottieAnimationView a;
    public final /* synthetic */ com.moji.lottie.LottieAnimationUtils.LottieAnimationLoadLinster b;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef c;

    public /* synthetic */ o01(com.airbnb.lottie.LottieAnimationView lottieAnimationView, com.moji.lottie.LottieAnimationUtils.LottieAnimationLoadLinster lottieAnimationLoadLinster, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = lottieAnimationView;
        this.b = lottieAnimationLoadLinster;
        this.c = objectRef;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(java.lang.Object obj) {
        com.moji.lottie.LottieAnimationUtils.e(this.a, this.b, this.c, (com.airbnb.lottie.LottieComposition) obj);
    }
}
