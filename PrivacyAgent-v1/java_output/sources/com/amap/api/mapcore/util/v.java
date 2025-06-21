package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class v extends com.autonavi.amap.mapcore.AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState) {
        android.util.Pair<java.lang.Float, com.autonavi.amap.mapcore.IPoint> a = com.amap.api.mapcore.util.dl.a(this, this.mapConfig);
        if (a == null) {
            return;
        }
        iGLMapState.setMapZoomer(((java.lang.Float) a.first).floatValue());
        java.lang.Object obj = a.second;
        iGLMapState.setMapGeoCenter(((android.graphics.Point) ((com.autonavi.amap.mapcore.IPoint) obj)).x, ((android.graphics.Point) ((com.autonavi.amap.mapcore.IPoint) obj)).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
