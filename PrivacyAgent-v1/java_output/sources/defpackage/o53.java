package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class o53 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonLayoutView n;

    public /* synthetic */ o53(com.moji.shorttime.ui.view.TyphoonLayoutView typhoonLayoutView) {
        this.n = typhoonLayoutView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.TyphoonLayoutView.c(this.n, valueAnimator);
    }
}
