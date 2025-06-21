package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class f72 implements com.amap.api.maps.AMap.OnMapClickListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.card.RFlowersMapFragment a;

    public /* synthetic */ f72(moji.com.mjweatherservicebase.card.RFlowersMapFragment rFlowersMapFragment) {
        this.a = rFlowersMapFragment;
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public final void onMapClick(com.amap.api.maps.model.LatLng latLng) {
        moji.com.mjweatherservicebase.card.RFlowersMapFragment.h(this.a, latLng);
    }
}
