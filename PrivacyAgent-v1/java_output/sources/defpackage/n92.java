package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class n92 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar n;

    public /* synthetic */ n92(com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar rainSnowTimelinePlayerBar) {
        this.n = rainSnowTimelinePlayerBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar.g(this.n, valueAnimator);
    }
}
