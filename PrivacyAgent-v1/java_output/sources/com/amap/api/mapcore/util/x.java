package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class x extends com.autonavi.amap.mapcore.AbstractCameraUpdateMessage {
    private static void a(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, int i, int i2, android.graphics.Point point) {
        iGLMapState.screenToP20Point(i, i2, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState) {
        float f = this.xPixel;
        float f2 = (this.width / 2.0f) + f;
        float f3 = (this.height / 2.0f) + this.yPixel;
        a(iGLMapState, (int) f2, (int) f3, new android.graphics.Point());
        iGLMapState.setMapGeoCenter(r1.x, r1.y);
    }
}
