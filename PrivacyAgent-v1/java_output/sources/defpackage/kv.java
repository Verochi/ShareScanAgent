package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class kv implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity n;

    public /* synthetic */ kv(com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity dangerousDrivingForecastActivity) {
        this.n = dangerousDrivingForecastActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity.h(this.n, valueAnimator);
    }
}
