package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class th0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.ForecaseDays40WithDetailView n;

    public /* synthetic */ th0(com.moji.mjweather.weather.view.ForecaseDays40WithDetailView forecaseDays40WithDetailView) {
        this.n = forecaseDays40WithDetailView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.ForecaseDays40WithDetailView.g(this.n, valueAnimator);
    }
}
