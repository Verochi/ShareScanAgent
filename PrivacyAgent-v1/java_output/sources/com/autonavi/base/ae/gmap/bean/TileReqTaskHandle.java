package com.autonavi.base.ae.gmap.bean;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class TileReqTaskHandle {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    long nativeObj;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    int status;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    com.amap.api.maps.model.Tile tile;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public TileReqTaskHandle() {
    }

    public void finish(com.amap.api.maps.model.Tile tile) {
        this.tile = tile;
    }
}
