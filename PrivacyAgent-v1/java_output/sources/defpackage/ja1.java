package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ja1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainTopBannerAnimator n;

    public /* synthetic */ ja1(com.moji.mjweather.weather.view.MainTopBannerAnimator mainTopBannerAnimator) {
        this.n = mainTopBannerAnimator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainTopBannerAnimator.a(this.n, valueAnimator);
    }
}
