package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class jo1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ java.lang.String A;
    public final /* synthetic */ java.lang.String B;
    public final /* synthetic */ boolean C;
    public final /* synthetic */ int n;
    public final /* synthetic */ com.amap.api.maps.model.Polyline t;
    public final /* synthetic */ boolean u;
    public final /* synthetic */ int v;
    public final /* synthetic */ java.util.List w;
    public final /* synthetic */ com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController x;
    public final /* synthetic */ com.moji.http.member.entity.MemberCurrentTyphoonResult.CurrentTy.Forecast.ForecastData y;
    public final /* synthetic */ com.amap.api.maps.model.LatLng z;

    public /* synthetic */ jo1(int i, com.amap.api.maps.model.Polyline polyline, boolean z, int i2, java.util.List list, com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController multiTyphoonForecastController, com.moji.http.member.entity.MemberCurrentTyphoonResult.CurrentTy.Forecast.ForecastData forecastData, com.amap.api.maps.model.LatLng latLng, java.lang.String str, java.lang.String str2, boolean z2) {
        this.n = i;
        this.t = polyline;
        this.u = z;
        this.v = i2;
        this.w = list;
        this.x = multiTyphoonForecastController;
        this.y = forecastData;
        this.z = latLng;
        this.A = str;
        this.B = str2;
        this.C = z2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.typhoon.MultiTyphoonForecastController.c(this.n, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, valueAnimator);
    }
}
