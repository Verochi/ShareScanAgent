package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class k53 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonBottomDialogView n;

    public /* synthetic */ k53(com.moji.shorttime.ui.view.TyphoonBottomDialogView typhoonBottomDialogView) {
        this.n = typhoonBottomDialogView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.TyphoonBottomDialogView.setTyphoonSubVisibleWithAnmi.1.a(this.n, valueAnimator);
    }
}
