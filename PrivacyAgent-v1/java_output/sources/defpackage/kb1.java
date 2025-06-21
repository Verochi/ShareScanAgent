package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class kb1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.earlywarning.view.MapViewContainer n;

    public /* synthetic */ kb1(com.moji.earlywarning.view.MapViewContainer mapViewContainer) {
        this.n = mapViewContainer;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.earlywarning.view.MapViewContainer.b(this.n, valueAnimator);
    }
}
