package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class rm0 implements com.amap.api.maps.AMap.OnMapLoadedListener {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity n;

    public /* synthetic */ rm0(com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity historicalTyphoonActivity) {
        this.n = historicalTyphoonActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMapLoadedListener
    public final void onMapLoaded() {
        com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity.j(this.n);
    }
}
