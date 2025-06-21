package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xa1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.View n;

    public /* synthetic */ xa1(android.view.View view) {
        this.n = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weathercorrect.MainWeatherCorrectViewPresenter.b(this.n, valueAnimator);
    }
}
