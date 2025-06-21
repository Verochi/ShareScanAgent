package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class j53 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonBottomDialogView n;

    public /* synthetic */ j53(com.moji.shorttime.ui.view.TyphoonBottomDialogView typhoonBottomDialogView) {
        this.n = typhoonBottomDialogView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.TyphoonBottomDialogView.a(this.n, valueAnimator);
    }
}
