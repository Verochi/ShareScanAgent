package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class o20 implements com.amap.api.maps.AMap.OnMapClickListener {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity a;

    public /* synthetic */ o20(com.moji.rainclould.DisasterActivity disasterActivity) {
        this.a = disasterActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public final void onMapClick(com.amap.api.maps.model.LatLng latLng) {
        com.moji.rainclould.DisasterActivity.l(this.a, latLng);
    }
}
