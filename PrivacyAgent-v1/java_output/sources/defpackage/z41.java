package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class z41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelineIndicator n;

    public /* synthetic */ z41(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelineIndicator mJPaginationTimelineIndicator) {
        this.n = mJPaginationTimelineIndicator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelineIndicator.a(this.n, valueAnimator);
    }
}
