package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class jx1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.graphics.Paint n;
    public final /* synthetic */ com.moji.mjweather.weather.view.PageProgressView t;

    public /* synthetic */ jx1(android.graphics.Paint paint, com.moji.mjweather.weather.view.PageProgressView pageProgressView) {
        this.n = paint;
        this.t = pageProgressView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.PageProgressView.a(this.n, this.t, valueAnimator);
    }
}
