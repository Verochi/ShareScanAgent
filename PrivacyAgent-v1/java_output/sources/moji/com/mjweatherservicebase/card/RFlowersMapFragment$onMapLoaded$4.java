package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"moji/com/mjweatherservicebase/card/RFlowersMapFragment$onMapLoaded$4", "Lcom/amap/api/maps/AMap$InfoWindowAdapter;", "getInfoContents", "Landroid/view/View;", com.alibaba.sdk.android.oss.common.RequestParameters.MARKER, "Lcom/amap/api/maps/model/Marker;", "getInfoWindow", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class RFlowersMapFragment$onMapLoaded$4 implements com.amap.api.maps.AMap.InfoWindowAdapter {
    public final /* synthetic */ moji.com.mjweatherservicebase.card.RFlowersMapFragment n;

    public RFlowersMapFragment$onMapLoaded$4(moji.com.mjweatherservicebase.card.RFlowersMapFragment rFlowersMapFragment) {
        this.n = rFlowersMapFragment;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    @org.jetbrains.annotations.Nullable
    public android.view.View getInfoContents(@org.jetbrains.annotations.Nullable com.amap.api.maps.model.Marker marker) {
        return null;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    @org.jetbrains.annotations.Nullable
    public android.view.View getInfoWindow(@org.jetbrains.annotations.Nullable com.amap.api.maps.model.Marker marker) {
        android.view.View inflate = android.view.LayoutInflater.from(this.n.getContext()).inflate(moji.com.mjweatherservicebase.R.layout.rflowers_spot_map_info, (android.view.ViewGroup) null);
        android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(moji.com.mjweatherservicebase.R.id.ski_info_text);
        java.lang.Object object = marker != null ? marker.getObject() : null;
        if (!(object instanceof com.moji.common.bean.spot.SpotMaps.spot_maps.spot_map)) {
            return new android.view.View(this.n.getContext());
        }
        java.lang.String spotName = ((com.moji.common.bean.spot.SpotMaps.spot_maps.spot_map) object).getSpotName();
        if (android.text.TextUtils.isEmpty(spotName)) {
            inflate.setVisibility(8);
        } else {
            textView.setText(spotName);
        }
        return inflate;
    }
}
