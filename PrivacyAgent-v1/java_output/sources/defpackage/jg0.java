package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class jg0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjfloatball.view.FloatBallView n;

    public /* synthetic */ jg0(com.moji.mjfloatball.view.FloatBallView floatBallView) {
        this.n = floatBallView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjfloatball.view.FloatBallView.b(this.n, valueAnimator);
    }
}
