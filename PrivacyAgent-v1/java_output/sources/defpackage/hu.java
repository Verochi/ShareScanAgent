package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class hu implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.amap.api.maps.model.Polyline t;
    public final /* synthetic */ int u;
    public final /* synthetic */ com.moji.shorttime.ui.function.typhoon.CurrentTyphoonController v;
    public final /* synthetic */ com.amap.api.maps.model.LatLng w;

    public /* synthetic */ hu(int i, com.amap.api.maps.model.Polyline polyline, int i2, com.moji.shorttime.ui.function.typhoon.CurrentTyphoonController currentTyphoonController, com.amap.api.maps.model.LatLng latLng) {
        this.n = i;
        this.t = polyline;
        this.u = i2;
        this.v = currentTyphoonController;
        this.w = latLng;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.typhoon.CurrentTyphoonController.a(this.n, this.t, this.u, this.v, this.w, valueAnimator);
    }
}
