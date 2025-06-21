package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class fy implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mj40dayforecast.view.Days40TrendView n;

    public /* synthetic */ fy(com.moji.mj40dayforecast.view.Days40TrendView days40TrendView) {
        this.n = days40TrendView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mj40dayforecast.view.Days40TrendView.a(this.n, valueAnimator);
    }
}
