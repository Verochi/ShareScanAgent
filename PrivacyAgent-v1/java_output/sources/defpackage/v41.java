package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class v41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline n;

    public /* synthetic */ v41(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline mJPaginationTimeline) {
        this.n = mJPaginationTimeline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline.c(this.n, valueAnimator);
    }
}
