package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fp0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.hour24_s5.Hour24ViewS5 n;

    public /* synthetic */ fp0(com.moji.mjweather.weather.beta.hour24_s5.Hour24ViewS5 hour24ViewS5) {
        this.n = hour24ViewS5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.beta.hour24_s5.Hour24ViewS5.d(this.n, valueAnimator);
    }
}
