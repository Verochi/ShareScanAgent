package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class na1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainTopBannerAnimatorV10 n;
    public final /* synthetic */ int t;

    public /* synthetic */ na1(com.moji.mjweather.weather.view.MainTopBannerAnimatorV10 mainTopBannerAnimatorV10, int i) {
        this.n = mainTopBannerAnimatorV10;
        this.t = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainTopBannerAnimatorV10.a(this.n, this.t, valueAnimator);
    }
}
