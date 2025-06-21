package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class l81 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainDiamondAnimator n;

    public /* synthetic */ l81(com.moji.mjweather.weather.view.MainDiamondAnimator mainDiamondAnimator) {
        this.n = mainDiamondAnimator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainDiamondAnimator.a(this.n, valueAnimator);
    }
}
