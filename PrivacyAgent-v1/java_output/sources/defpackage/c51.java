package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class c51 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar n;

    public /* synthetic */ c51(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar mJPaginationTimelinePlayerBar) {
        this.n = mJPaginationTimelinePlayerBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar.h(this.n, valueAnimator);
    }
}
