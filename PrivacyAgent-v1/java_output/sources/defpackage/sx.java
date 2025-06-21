package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class sx implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mj40dayforecast.view.Days40CurveView n;

    public /* synthetic */ sx(com.moji.mj40dayforecast.view.Days40CurveView days40CurveView) {
        this.n = days40CurveView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mj40dayforecast.view.Days40CurveView.a(this.n, valueAnimator);
    }
}
