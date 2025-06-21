package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class m43 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.TwoDaysForecastViewFor10 n;

    public /* synthetic */ m43(com.moji.mjweather.weather.view.TwoDaysForecastViewFor10 twoDaysForecastViewFor10) {
        this.n = twoDaysForecastViewFor10;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.TwoDaysForecastViewFor10.a(this.n, valueAnimator);
    }
}
