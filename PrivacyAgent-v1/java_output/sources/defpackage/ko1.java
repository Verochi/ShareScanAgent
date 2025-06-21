package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ko1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.IntRef n;
    public final /* synthetic */ com.amap.api.maps.model.Polyline t;

    public /* synthetic */ ko1(kotlin.jvm.internal.Ref.IntRef intRef, com.amap.api.maps.model.Polyline polyline) {
        this.n = intRef;
        this.t = polyline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController.a(this.n, this.t, valueAnimator);
    }
}
