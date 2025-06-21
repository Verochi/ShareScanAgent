package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ih2 implements com.amap.api.maps.AMap.OnMapClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeFragmentV2 a;

    public /* synthetic */ ih2(com.moji.shorttime.ui.ShortTimeFragmentV2 shortTimeFragmentV2) {
        this.a = shortTimeFragmentV2;
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public final void onMapClick(com.amap.api.maps.model.LatLng latLng) {
        com.moji.shorttime.ui.ShortTimeFragmentV2.b(this.a, latLng);
    }
}
