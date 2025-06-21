package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class wg2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.ShortPopBackground n;

    public /* synthetic */ wg2(com.moji.shorttime.ui.view.ShortPopBackground shortPopBackground) {
        this.n = shortPopBackground;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.ShortPopBackground.a(this.n, valueAnimator);
    }
}
