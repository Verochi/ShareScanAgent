package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class b82 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48HTimelinePlayerBar n;
    public final /* synthetic */ android.graphics.drawable.Drawable t;
    public final /* synthetic */ android.graphics.Rect u;
    public final /* synthetic */ int v;
    public final /* synthetic */ int w;

    public /* synthetic */ b82(com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48HTimelinePlayerBar rain48HTimelinePlayerBar, android.graphics.drawable.Drawable drawable, android.graphics.Rect rect, int i, int i2) {
        this.n = rain48HTimelinePlayerBar;
        this.t = drawable;
        this.u = rect;
        this.v = i;
        this.w = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48HTimelinePlayerBar.m(this.n, this.t, this.u, this.v, this.w, valueAnimator);
    }
}
