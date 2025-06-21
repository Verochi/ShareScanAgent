package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class em0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.ViewGroup.LayoutParams n;
    public final /* synthetic */ com.moji.mjweather.guide.GuideDialog t;
    public final /* synthetic */ int u;
    public final /* synthetic */ int v;
    public final /* synthetic */ int w;

    public /* synthetic */ em0(android.view.ViewGroup.LayoutParams layoutParams, com.moji.mjweather.guide.GuideDialog guideDialog, int i, int i2, int i3) {
        this.n = layoutParams;
        this.t = guideDialog;
        this.u = i;
        this.v = i2;
        this.w = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.guide.GuideDialog.c(this.n, this.t, this.u, this.v, this.w, valueAnimator);
    }
}
