package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class im implements com.amap.api.location.AMapLocationListener {
    public com.autonavi.amap.mapcore.Inner_3dMap_locationListener a = null;

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        this.a = inner_3dMap_locationListener;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            com.autonavi.amap.mapcore.Inner_3dMap_location a = com.amap.api.mapcore.util.iz.a(aMapLocation);
            if (com.amap.api.mapcore.util.ji.a(a)) {
                com.amap.api.mapcore.util.iz.a = a;
            }
            com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener = this.a;
            if (inner_3dMap_locationListener != null) {
                inner_3dMap_locationListener.onLocationChanged(a);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationListener", "onLocationChanged");
        }
    }
}
