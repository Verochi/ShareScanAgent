package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class zm0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ zm0(com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity historicalTyphoonActivity, int i, int i2) {
        this.n = historicalTyphoonActivity;
        this.t = i;
        this.u = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity.d(this.n, this.t, this.u, valueAnimator);
    }
}
