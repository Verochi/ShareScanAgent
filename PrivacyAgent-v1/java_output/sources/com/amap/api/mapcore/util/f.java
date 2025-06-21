package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
final class f implements com.amap.api.maps.LocationSource.OnLocationChangedListener {
    android.location.Location a;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;

    public f(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(android.location.Location location) {
        this.a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.showMyLocationOverlay(location);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
