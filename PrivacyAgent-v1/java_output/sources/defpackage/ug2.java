package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ug2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.ShortLeafPopBackground n;

    public /* synthetic */ ug2(com.moji.shorttime.ui.view.ShortLeafPopBackground shortLeafPopBackground) {
        this.n = shortLeafPopBackground;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.ShortLeafPopBackground.a(this.n, valueAnimator);
    }
}
