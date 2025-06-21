package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class vg2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.ShortLeafTouchPopBackground n;

    public /* synthetic */ vg2(com.moji.shorttime.ui.view.ShortLeafTouchPopBackground shortLeafTouchPopBackground) {
        this.n = shortLeafTouchPopBackground;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.ShortLeafTouchPopBackground.a(this.n, valueAnimator);
    }
}
