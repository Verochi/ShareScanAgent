package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class zg3 implements com.moji.dynamic.DynamicLoadListener {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ com.airbnb.lottie.LottieAnimationView b;
    public final /* synthetic */ int c;

    public /* synthetic */ zg3(java.lang.String str, com.airbnb.lottie.LottieAnimationView lottieAnimationView, int i) {
        this.a = str;
        this.b = lottieAnimationView;
        this.c = i;
    }

    public final void onTypeReady(com.moji.dynamic.DynamicLoadType dynamicLoadType) {
        com.moji.base.WeatherLottieDrawable.a(this.a, this.b, this.c, dynamicLoadType);
    }
}
