package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ba1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainShortView n;

    public /* synthetic */ ba1(com.moji.mjweather.weather.view.MainShortView mainShortView) {
        this.n = mainShortView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainShortView.a(this.n, valueAnimator);
    }
}
