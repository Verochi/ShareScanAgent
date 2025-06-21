package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class w41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline n;

    public /* synthetic */ w41(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline mJPaginationTimeline) {
        this.n = mJPaginationTimeline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimeline.b(this.n, valueAnimator);
    }
}
