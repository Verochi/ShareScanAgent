package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class g53 implements com.amap.api.maps.AMap.OnMapClickListener {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.TyphoonActivity a;

    public /* synthetic */ g53(com.moji.mjweather.typhoon.newversion.TyphoonActivity typhoonActivity) {
        this.a = typhoonActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public final void onMapClick(com.amap.api.maps.model.LatLng latLng) {
        com.moji.mjweather.typhoon.newversion.TyphoonActivity.b(this.a, latLng);
    }
}
