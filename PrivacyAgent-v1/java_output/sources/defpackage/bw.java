package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class bw implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.day2.Day2ForecastViewS5 n;

    public /* synthetic */ bw(com.moji.mjweather.weather.beta.day2.Day2ForecastViewS5 day2ForecastViewS5) {
        this.n = day2ForecastViewS5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.beta.day2.Day2ForecastViewS5.a(this.n, valueAnimator);
    }
}
