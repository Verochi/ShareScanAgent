package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class e72 implements com.amap.api.maps.AMap.OnInfoWindowClickListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.card.RFlowersMapFragment n;

    public /* synthetic */ e72(moji.com.mjweatherservicebase.card.RFlowersMapFragment rFlowersMapFragment) {
        this.n = rFlowersMapFragment;
    }

    @Override // com.amap.api.maps.AMap.OnInfoWindowClickListener
    public final void onInfoWindowClick(com.amap.api.maps.model.Marker marker) {
        moji.com.mjweatherservicebase.card.RFlowersMapFragment.g(this.n, marker);
    }
}
