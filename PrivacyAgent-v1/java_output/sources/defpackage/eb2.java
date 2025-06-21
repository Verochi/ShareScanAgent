package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class eb2 implements com.amap.api.maps.AMap.OnMarkerClickListener {
    public final /* synthetic */ com.moji.redleaves.fragment.RedLeavesSceneMapFragment n;

    public /* synthetic */ eb2(com.moji.redleaves.fragment.RedLeavesSceneMapFragment redLeavesSceneMapFragment) {
        this.n = redLeavesSceneMapFragment;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public final boolean onMarkerClick(com.amap.api.maps.model.Marker marker) {
        return com.moji.redleaves.fragment.RedLeavesSceneMapFragment.a(this.n, marker);
    }
}
