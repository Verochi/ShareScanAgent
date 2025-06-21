package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ia1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainTopBannerAnimator n;
    public final /* synthetic */ int t;
    public final /* synthetic */ android.view.ViewGroup.LayoutParams u;

    public /* synthetic */ ia1(com.moji.mjweather.weather.view.MainTopBannerAnimator mainTopBannerAnimator, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        this.n = mainTopBannerAnimator;
        this.t = i;
        this.u = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainTopBannerAnimator.b(this.n, this.t, this.u, valueAnimator);
    }
}
