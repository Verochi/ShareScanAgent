package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class m51 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar n;
    public final /* synthetic */ android.graphics.drawable.Drawable t;
    public final /* synthetic */ android.graphics.Rect u;
    public final /* synthetic */ int v;
    public final /* synthetic */ int w;

    public /* synthetic */ m51(com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar mJPaginationTimelinePlayerBar, android.graphics.drawable.Drawable drawable, android.graphics.Rect rect, int i, int i2) {
        this.n = mJPaginationTimelinePlayerBar;
        this.t = drawable;
        this.u = rect;
        this.v = i;
        this.w = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.style_pagination.MJPaginationTimelinePlayerBar.e(this.n, this.t, this.u, this.v, this.w, valueAnimator);
    }
}
