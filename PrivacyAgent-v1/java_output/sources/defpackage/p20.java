package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class p20 implements com.amap.api.maps.AMap.OnInfoWindowClickListener {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity n;

    public /* synthetic */ p20(com.moji.rainclould.DisasterActivity disasterActivity) {
        this.n = disasterActivity;
    }

    @Override // com.amap.api.maps.AMap.OnInfoWindowClickListener
    public final void onInfoWindowClick(com.amap.api.maps.model.Marker marker) {
        com.moji.rainclould.DisasterActivity.f(this.n, marker);
    }
}
