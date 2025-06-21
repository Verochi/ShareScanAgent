package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xm0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.view.ShortPopContainerView n;
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity t;
    public final /* synthetic */ com.amap.api.maps.model.Marker u;

    public /* synthetic */ xm0(com.moji.mjweather.typhoon.newversion.view.ShortPopContainerView shortPopContainerView, com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity historicalTyphoonActivity, com.amap.api.maps.model.Marker marker) {
        this.n = shortPopContainerView;
        this.t = historicalTyphoonActivity;
        this.u = marker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity.k(this.n, this.t, this.u, view);
    }
}
