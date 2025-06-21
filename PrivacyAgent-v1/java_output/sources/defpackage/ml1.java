package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ml1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.minute.MinuteColumnView n;
    public final /* synthetic */ android.animation.ArgbEvaluator t;

    public /* synthetic */ ml1(com.moji.mjweather.weather.beta.minute.MinuteColumnView minuteColumnView, android.animation.ArgbEvaluator argbEvaluator) {
        this.n = minuteColumnView;
        this.t = argbEvaluator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.beta.minute.MinuteColumnView.b(this.n, this.t, valueAnimator);
    }
}
