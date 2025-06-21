package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class t41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationHistogram n;

    public /* synthetic */ t41(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationHistogram mJPaginationHistogram) {
        this.n = mJPaginationHistogram;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationHistogram.a(this.n, valueAnimator);
    }
}
