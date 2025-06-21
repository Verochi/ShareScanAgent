package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ll1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.minute.MinuteBannerView n;

    public /* synthetic */ ll1(com.moji.mjweather.weather.beta.minute.MinuteBannerView minuteBannerView) {
        this.n = minuteBannerView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.beta.minute.MinuteBannerView.a(this.n, valueAnimator);
    }
}
