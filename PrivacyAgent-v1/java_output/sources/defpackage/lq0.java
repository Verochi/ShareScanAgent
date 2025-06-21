package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class lq0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.IRadarMapChildFunction n;

    public /* synthetic */ lq0(com.moji.shorttime.ui.function.IRadarMapChildFunction iRadarMapChildFunction) {
        this.n = iRadarMapChildFunction;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.IRadarMapChildFunction.a(this.n, valueAnimator);
    }
}
