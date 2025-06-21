package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class cm0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.guide.GuideDialog n;

    public /* synthetic */ cm0(com.moji.mjweather.guide.GuideDialog guideDialog) {
        this.n = guideDialog;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.guide.GuideDialog.a(this.n, valueAnimator);
    }
}
