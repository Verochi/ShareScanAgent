package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class iu2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float n;
    public final /* synthetic */ com.moji.sun.SunriseView t;

    public /* synthetic */ iu2(float f, com.moji.sun.SunriseView sunriseView) {
        this.n = f;
        this.t = sunriseView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.sun.SunriseView.a(this.n, this.t, valueAnimator);
    }
}
