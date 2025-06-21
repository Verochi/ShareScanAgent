package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ya1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.View n;

    public /* synthetic */ ya1(android.view.View view) {
        this.n = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter.e(this.n, valueAnimator);
    }
}
