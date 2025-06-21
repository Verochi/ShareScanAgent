package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class n80 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.view.EarthquakeMarkerAnimView n;
    public final /* synthetic */ com.amap.api.maps.model.LatLng t;

    public /* synthetic */ n80(com.moji.shorttime.ui.view.EarthquakeMarkerAnimView earthquakeMarkerAnimView, com.amap.api.maps.model.LatLng latLng) {
        this.n = earthquakeMarkerAnimView;
        this.t = latLng;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.view.EarthquakeMarkerAnimView.b(this.n, this.t);
    }
}
