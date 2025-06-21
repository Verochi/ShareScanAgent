package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class sh0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.ForecaseDays40WithDetailView n;

    public /* synthetic */ sh0(com.moji.mjweather.weather.view.ForecaseDays40WithDetailView forecaseDays40WithDetailView) {
        this.n = forecaseDays40WithDetailView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.ForecaseDays40WithDetailView.a(this.n, valueAnimator);
    }
}
