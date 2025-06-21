package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class tz0 implements com.moji.location.MJOnReGeoCodeSearchListener {
    public final /* synthetic */ com.moji.rainclould.model.LocationModel n;
    public final /* synthetic */ com.amap.api.maps.model.LatLng t;

    public /* synthetic */ tz0(com.moji.rainclould.model.LocationModel locationModel, com.amap.api.maps.model.LatLng latLng) {
        this.n = locationModel;
        this.t = latLng;
    }

    public final void onReGeoCodeSearched(com.moji.location.geo.MJReGeoCodeResult mJReGeoCodeResult, int i) {
        com.moji.rainclould.model.LocationModel.a(this.n, this.t, mJReGeoCodeResult, i);
    }
}
