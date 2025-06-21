package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class n20 implements com.amap.api.maps.AMap.OnMarkerClickListener {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity n;

    public /* synthetic */ n20(com.moji.rainclould.DisasterActivity disasterActivity) {
        this.n = disasterActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public final boolean onMarkerClick(com.amap.api.maps.model.Marker marker) {
        return com.moji.rainclould.DisasterActivity.j(this.n, marker);
    }
}
