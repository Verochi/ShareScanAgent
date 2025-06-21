package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class t8 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.ShortLeafPopContainerView n;
    public final /* synthetic */ com.amap.api.maps.model.Marker t;

    public /* synthetic */ t8(com.moji.shorttime.ui.view.ShortLeafPopContainerView shortLeafPopContainerView, com.amap.api.maps.model.Marker marker) {
        this.n = shortLeafPopContainerView;
        this.t = marker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.map.AllergyRasterMarkerAdapter.b(this.n, this.t, view);
    }
}
