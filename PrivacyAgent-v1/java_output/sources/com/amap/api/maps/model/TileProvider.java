package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public interface TileProvider {
    public static final com.amap.api.maps.model.Tile NO_TILE = com.amap.api.maps.model.Tile.obtain(-1, -1, null);

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    com.amap.api.maps.model.Tile getTile(int i, int i2, int i3);

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    int getTileHeight();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    int getTileWidth();
}
