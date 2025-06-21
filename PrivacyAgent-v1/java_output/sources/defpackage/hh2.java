package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class hh2 implements com.amap.api.maps.AMap.OnMarkerClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeFragmentV2 n;

    public /* synthetic */ hh2(com.moji.shorttime.ui.ShortTimeFragmentV2 shortTimeFragmentV2) {
        this.n = shortTimeFragmentV2;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public final boolean onMarkerClick(com.amap.api.maps.model.Marker marker) {
        return com.moji.shorttime.ui.ShortTimeFragmentV2.f(this.n, marker);
    }
}
