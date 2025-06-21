package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class sm0 implements com.amap.api.maps.AMap.OnMarkerClickListener {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity n;

    public /* synthetic */ sm0(com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity historicalTyphoonActivity) {
        this.n = historicalTyphoonActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public final boolean onMarkerClick(com.amap.api.maps.model.Marker marker) {
        return com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity.g(this.n, marker);
    }
}
