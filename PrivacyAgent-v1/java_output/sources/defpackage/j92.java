package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class j92 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar n;
    public final /* synthetic */ com.moji.shorttime.ui.timeline.style_pagination.TurnPageType t;

    public /* synthetic */ j92(com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar rainSnowTimelinePlayerBar, com.moji.shorttime.ui.timeline.style_pagination.TurnPageType turnPageType) {
        this.n = rainSnowTimelinePlayerBar;
        this.t = turnPageType;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar.e(this.n, this.t, valueAnimator);
    }
}
