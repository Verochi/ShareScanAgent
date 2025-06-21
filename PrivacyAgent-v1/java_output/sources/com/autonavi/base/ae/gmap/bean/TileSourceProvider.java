package com.autonavi.base.ae.gmap.bean;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public interface TileSourceProvider extends com.amap.api.maps.model.TileProvider {
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    void cancel(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq);

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    com.amap.api.maps.model.Tile getTile(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq);
}
