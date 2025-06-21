package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class yp1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ com.moji.mjweathercorrect.newcorrect.WeatherSecondaryOptionView u;

    public /* synthetic */ yp1(com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment newCorrectPickWeatherFragment, boolean z, com.moji.mjweathercorrect.newcorrect.WeatherSecondaryOptionView weatherSecondaryOptionView) {
        this.n = newCorrectPickWeatherFragment;
        this.t = z;
        this.u = weatherSecondaryOptionView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment.b(this.n, this.t, this.u, valueAnimator);
    }
}
