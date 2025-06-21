package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class w extends com.autonavi.amap.mapcore.AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        com.autonavi.amap.mapcore.DPoint dPoint = this.geoPoint;
        if (dPoint == null) {
            dPoint = abstractCameraUpdateMessage.geoPoint;
        }
        abstractCameraUpdateMessage.geoPoint = dPoint;
        abstractCameraUpdateMessage.zoom = java.lang.Float.isNaN(this.zoom) ? abstractCameraUpdateMessage.zoom : this.zoom;
        abstractCameraUpdateMessage.bearing = java.lang.Float.isNaN(this.bearing) ? abstractCameraUpdateMessage.bearing : this.bearing;
        abstractCameraUpdateMessage.tilt = java.lang.Float.isNaN(this.tilt) ? abstractCameraUpdateMessage.tilt : this.tilt;
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState) {
        normalChange(iGLMapState);
    }
}
