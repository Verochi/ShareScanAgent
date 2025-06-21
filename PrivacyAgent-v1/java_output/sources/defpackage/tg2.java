package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class tg2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.ShortGuideView n;

    public /* synthetic */ tg2(com.moji.mjweather.weather.view.ShortGuideView shortGuideView) {
        this.n = shortGuideView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.ShortGuideView.b(this.n, valueAnimator);
    }
}
