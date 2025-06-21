package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class io1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.amap.api.maps.model.Polyline t;
    public final /* synthetic */ int u;
    public final /* synthetic */ java.util.List v;
    public final /* synthetic */ com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController w;
    public final /* synthetic */ com.amap.api.maps.model.LatLng x;
    public final /* synthetic */ java.lang.String y;

    public /* synthetic */ io1(int i, com.amap.api.maps.model.Polyline polyline, int i2, java.util.List list, com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController multiTyphoonForecastController, com.amap.api.maps.model.LatLng latLng, java.lang.String str) {
        this.n = i;
        this.t = polyline;
        this.u = i2;
        this.v = list;
        this.w = multiTyphoonForecastController;
        this.x = latLng;
        this.y = str;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController.b(this.n, this.t, this.u, this.v, this.w, this.x, this.y, valueAnimator);
    }
}
