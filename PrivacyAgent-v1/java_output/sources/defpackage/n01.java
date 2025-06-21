package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class n01 implements com.airbnb.lottie.LottieListener {
    public final /* synthetic */ com.airbnb.lottie.LottieAnimationView a;
    public final /* synthetic */ com.moji.mjweather.LottieAnimationLoadLinster b;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef c;

    public /* synthetic */ n01(com.airbnb.lottie.LottieAnimationView lottieAnimationView, com.moji.mjweather.LottieAnimationLoadLinster lottieAnimationLoadLinster, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = lottieAnimationView;
        this.b = lottieAnimationLoadLinster;
        this.c = objectRef;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(java.lang.Object obj) {
        com.moji.mjweather.LottieAnimationUtils.a(this.a, this.b, this.c, (com.airbnb.lottie.LottieComposition) obj);
    }
}
