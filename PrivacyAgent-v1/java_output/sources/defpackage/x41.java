package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class x41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline n;

    public /* synthetic */ x41(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline mJPaginationTimeline) {
        this.n = mJPaginationTimeline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline.d(this.n, valueAnimator);
    }
}
