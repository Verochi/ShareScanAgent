package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class kp2 implements com.airbnb.lottie.LottieListener {
    public final /* synthetic */ com.airbnb.lottie.LottieAnimationView a;
    public final /* synthetic */ com.moji.mjad.splash.lottie.LottieAnimationLoadListener b;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef c;

    public /* synthetic */ kp2(com.airbnb.lottie.LottieAnimationView lottieAnimationView, com.moji.mjad.splash.lottie.LottieAnimationLoadListener lottieAnimationLoadListener, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = lottieAnimationView;
        this.b = lottieAnimationLoadListener;
        this.c = objectRef;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(java.lang.Object obj) {
        com.moji.mjad.splash.lottie.SplashTipsDrawableLoader.Companion.b(this.a, this.b, this.c, (com.airbnb.lottie.LottieComposition) obj);
    }
}
