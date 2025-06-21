package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class m92 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar n;
    public final /* synthetic */ android.graphics.drawable.Drawable t;
    public final /* synthetic */ android.graphics.Rect u;
    public final /* synthetic */ int v;
    public final /* synthetic */ int w;

    public /* synthetic */ m92(com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar rainSnowTimelinePlayerBar, android.graphics.drawable.Drawable drawable, android.graphics.Rect rect, int i, int i2) {
        this.n = rainSnowTimelinePlayerBar;
        this.t = drawable;
        this.u = rect;
        this.v = i;
        this.w = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.radar_generic.rain_snow.RainSnowTimelinePlayerBar.c(this.n, this.t, this.u, this.v, this.w, valueAnimator);
    }
}
