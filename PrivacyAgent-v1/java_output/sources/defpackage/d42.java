package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class d42 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.PopCollapseAnimView n;

    public /* synthetic */ d42(com.moji.shorttime.ui.view.PopCollapseAnimView popCollapseAnimView) {
        this.n = popCollapseAnimView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.PopCollapseAnimView.b(this.n, valueAnimator);
    }
}
