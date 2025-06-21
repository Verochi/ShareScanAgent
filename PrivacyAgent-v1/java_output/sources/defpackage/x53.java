package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class x53 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.map.TyphoonMarkerAdapter n;
    public final /* synthetic */ com.amap.api.maps.model.Marker t;

    public /* synthetic */ x53(com.moji.shorttime.ui.map.TyphoonMarkerAdapter typhoonMarkerAdapter, com.amap.api.maps.model.Marker marker) {
        this.n = typhoonMarkerAdapter;
        this.t = marker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.map.TyphoonMarkerAdapter.c(this.n, this.t, view);
    }
}
