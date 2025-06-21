package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class r82 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.map.RainMarkerAdapter n;
    public final /* synthetic */ com.amap.api.maps.model.Marker t;

    public /* synthetic */ r82(com.moji.shorttime.ui.map.RainMarkerAdapter rainMarkerAdapter, com.amap.api.maps.model.Marker marker) {
        this.n = rainMarkerAdapter;
        this.t = marker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.map.RainMarkerAdapter.a(this.n, this.t, view);
    }
}
