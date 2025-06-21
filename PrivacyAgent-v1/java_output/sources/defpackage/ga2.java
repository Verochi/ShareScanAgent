package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ga2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.ShortPopContainerView n;
    public final /* synthetic */ com.amap.api.maps.model.Marker t;

    public /* synthetic */ ga2(com.moji.shorttime.ui.view.ShortPopContainerView shortPopContainerView, com.amap.api.maps.model.Marker marker) {
        this.n = shortPopContainerView;
        this.t = marker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.map.RasterMarkerAdapter.a(this.n, this.t, view);
    }
}
