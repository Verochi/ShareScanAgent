package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class hc2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.share.view.RiseNumberTextView n;

    public /* synthetic */ hc2(com.moji.share.view.RiseNumberTextView riseNumberTextView) {
        this.n = riseNumberTextView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.share.view.RiseNumberTextView.b(this.n, valueAnimator);
    }
}
