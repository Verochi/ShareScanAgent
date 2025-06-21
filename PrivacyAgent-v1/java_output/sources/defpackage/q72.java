package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class q72 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.RadarMapIndicator n;

    public /* synthetic */ q72(com.moji.shorttime.ui.view.RadarMapIndicator radarMapIndicator) {
        this.n = radarMapIndicator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.RadarMapIndicator.a(this.n, valueAnimator);
    }
}
