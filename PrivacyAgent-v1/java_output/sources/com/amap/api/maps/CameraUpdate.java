package com.amap.api.maps;

/* loaded from: classes12.dex */
public final class CameraUpdate {
    com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a;

    public CameraUpdate(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.a = abstractCameraUpdateMessage;
    }

    public final com.autonavi.amap.mapcore.AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.a;
    }
}
