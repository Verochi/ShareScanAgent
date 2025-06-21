package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class d72 implements com.amap.api.maps.AMap.OnMarkerClickListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.card.RFlowersMapFragment n;

    public /* synthetic */ d72(moji.com.mjweatherservicebase.card.RFlowersMapFragment rFlowersMapFragment) {
        this.n = rFlowersMapFragment;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public final boolean onMarkerClick(com.amap.api.maps.model.Marker marker) {
        boolean f;
        f = moji.com.mjweatherservicebase.card.RFlowersMapFragment.f(this.n, marker);
        return f;
    }
}
