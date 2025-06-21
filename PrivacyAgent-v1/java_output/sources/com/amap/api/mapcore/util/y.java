package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class y extends com.autonavi.amap.mapcore.AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.zoom += this.amount;
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState) {
        float mapZoomer = iGLMapState.getMapZoomer() + this.amount;
        this.zoom = mapZoomer;
        this.zoom = com.amap.api.mapcore.util.dl.a(this.mapConfig, mapZoomer);
        normalChange(iGLMapState);
    }
}
