package com.autonavi.base.ae.gmap.bean;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class TileSourceReq {
    public int sourceType;
    public int x;
    public int y;
    public int zoom;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public java.lang.String toString() {
        return "TileSourceReq{x=" + this.x + ", y=" + this.y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }
}
