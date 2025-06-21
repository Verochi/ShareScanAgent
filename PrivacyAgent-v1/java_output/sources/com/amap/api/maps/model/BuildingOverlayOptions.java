package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class BuildingOverlayOptions extends com.amap.api.maps.model.BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = -7829368;
    private int buildingSideColor = -7829368;
    private boolean isVisible = true;
    private java.util.List<com.amap.api.maps.model.LatLng> buildingLatlngs = new java.util.ArrayList();

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public java.util.List<com.amap.api.maps.model.LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public synchronized int[] getPoints() {
        java.util.List<com.amap.api.maps.model.LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[this.buildingLatlngs.size() * 2];
        int i = 0;
        for (int i2 = 0; i2 < this.buildingLatlngs.size(); i2++) {
            com.amap.api.maps.model.LatLng latLng = this.buildingLatlngs.get(i2);
            if (latLng != null) {
                android.graphics.Point latLongToPixels = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i3 = i + 1;
                iArr[i] = latLongToPixels.x;
                i = i3 + 1;
                iArr[i3] = latLongToPixels.y;
            }
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public com.amap.api.maps.model.BuildingOverlayOptions setBuildingHeight(int i) {
        this.buildingHeight = i;
        return this;
    }

    public com.amap.api.maps.model.BuildingOverlayOptions setBuildingHeightScale(int i) {
        this.buildingHeightScale = i;
        return this;
    }

    public synchronized com.amap.api.maps.model.BuildingOverlayOptions setBuildingLatlngs(java.util.List<com.amap.api.maps.model.LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[list.size() * 2];
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.amap.api.maps.model.LatLng latLng = list.get(i2);
                android.graphics.Point latLongToPixels = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int[] iArr = this.buildingLatlngsPoints;
                int i3 = i + 1;
                iArr[i] = latLongToPixels.x;
                i = i3 + 1;
                iArr[i3] = latLongToPixels.y;
            }
        }
        return this;
    }

    public com.amap.api.maps.model.BuildingOverlayOptions setBuildingSideColor(int i) {
        this.buildingSideColor = i;
        return this;
    }

    public com.amap.api.maps.model.BuildingOverlayOptions setBuildingTopColor(int i) {
        this.buildingTopColor = i;
        return this;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }

    public void setZIndex(float f) {
        this.zindex = f;
    }
}
