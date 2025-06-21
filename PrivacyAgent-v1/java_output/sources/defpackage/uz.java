package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class uz implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.DefaultTimeBar n;

    public /* synthetic */ uz(com.google.android.exoplayer2.ui.DefaultTimeBar defaultTimeBar) {
        this.n = defaultTimeBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        this.n.h(valueAnimator);
    }
}
