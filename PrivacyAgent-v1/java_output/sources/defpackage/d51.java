package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class d51 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar n;
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.TurnPageType t;

    public /* synthetic */ d51(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar mJPaginationTimelinePlayerBar, com.moji.shorttime.ui.timeline.style_pagination.TurnPageType turnPageType) {
        this.n = mJPaginationTimelinePlayerBar;
        this.t = turnPageType;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar.g(this.n, this.t, valueAnimator);
    }
}
