package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class za1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ moji.com.mjweather.databinding.MainWeatherConditionCorrectBinding n;
    public final /* synthetic */ int t;

    public /* synthetic */ za1(moji.com.mjweather.databinding.MainWeatherConditionCorrectBinding mainWeatherConditionCorrectBinding, int i) {
        this.n = mainWeatherConditionCorrectBinding;
        this.t = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter.a(this.n, this.t, valueAnimator);
    }
}
