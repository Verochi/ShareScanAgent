package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class qy2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment n;
    public final /* synthetic */ int t;

    public /* synthetic */ qy2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, int i) {
        this.n = tabWeatherV9Fragment;
        this.t = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.TabWeatherV9Fragment.r(this.n, this.t, valueAnimator);
    }
}
