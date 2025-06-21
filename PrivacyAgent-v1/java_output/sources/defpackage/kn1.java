package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class kn1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float n;
    public final /* synthetic */ com.moji.sun.MoonPhaseView t;

    public /* synthetic */ kn1(float f, com.moji.sun.MoonPhaseView moonPhaseView) {
        this.n = f;
        this.t = moonPhaseView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.sun.MoonPhaseView.a(this.n, this.t, valueAnimator);
    }
}
