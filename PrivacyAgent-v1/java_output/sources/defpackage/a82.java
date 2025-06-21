package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class a82 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48HTimelinePlayerBar n;
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.TurnPageType t;

    public /* synthetic */ a82(com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48HTimelinePlayerBar rain48HTimelinePlayerBar, com.moji.shorttime.ui.timeline.style_pagination.TurnPageType turnPageType) {
        this.n = rain48HTimelinePlayerBar;
        this.t = turnPageType;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.radar_generic.rain4h.Rain48HTimelinePlayerBar.i(this.n, this.t, valueAnimator);
    }
}
