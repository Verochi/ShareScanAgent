package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class n53 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonLayoutView n;

    public /* synthetic */ n53(com.moji.shorttime.ui.view.TyphoonLayoutView typhoonLayoutView) {
        this.n = typhoonLayoutView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.TyphoonLayoutView.a(this.n, valueAnimator);
    }
}
