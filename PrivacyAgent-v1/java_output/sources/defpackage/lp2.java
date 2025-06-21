package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class lp2 implements com.airbnb.lottie.LottieListener {
    public final /* synthetic */ com.moji.mjad.splash.lottie.LottieAnimationLoadListener a;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef b;

    public /* synthetic */ lp2(com.moji.mjad.splash.lottie.LottieAnimationLoadListener lottieAnimationLoadListener, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = lottieAnimationLoadListener;
        this.b = objectRef;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(java.lang.Object obj) {
        com.moji.mjad.splash.lottie.SplashTipsDrawableLoader.Companion.d(this.a, this.b, (java.lang.Throwable) obj);
    }
}
