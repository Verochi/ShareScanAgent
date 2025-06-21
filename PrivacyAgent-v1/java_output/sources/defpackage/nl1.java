package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nl1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.minute.MinuteColumnView n;

    public /* synthetic */ nl1(com.moji.mjweather.weather.beta.minute.MinuteColumnView minuteColumnView) {
        this.n = minuteColumnView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.beta.minute.MinuteColumnView.c(this.n, valueAnimator);
    }
}
