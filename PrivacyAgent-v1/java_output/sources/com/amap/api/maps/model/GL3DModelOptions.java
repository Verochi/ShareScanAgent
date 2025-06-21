package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class GL3DModelOptions extends com.amap.api.maps.model.BaseOptions {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.LatLng latLng;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String modelData;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float rotate;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String snippet;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String title;
    private java.util.List<java.lang.Float> vertextList = new java.util.ArrayList();
    private java.util.List<java.lang.Float> textrueList = new java.util.ArrayList();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean isModeltUpdate = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int fixedLength = 50;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean visibile = true;

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public com.amap.api.maps.model.GL3DModelOptions angle(float f) {
        this.rotate = f;
        return this;
    }

    public float getAngle() {
        return this.rotate;
    }

    public com.amap.api.maps.model.BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public com.amap.api.maps.model.LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public java.lang.String getSnippet() {
        return this.snippet;
    }

    public java.util.List<java.lang.Float> getTextrue() {
        return this.textrueList;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.util.List<java.lang.Float> getVertext() {
        return this.vertextList;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public com.amap.api.maps.model.GL3DModelOptions position(com.amap.api.maps.model.LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions setModelFixedLength(int i) {
        this.fixedLength = i;
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions setVisible(boolean z) {
        this.visibile = z;
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions snippet(java.lang.String str) {
        this.snippet = str;
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions textureDrawable(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions title(java.lang.String str) {
        this.title = str;
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions vertexData(java.lang.String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public com.amap.api.maps.model.GL3DModelOptions vertexData(java.util.List<java.lang.Float> list, java.util.List<java.lang.Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.vertextList != null) {
            for (int i = 0; i < this.vertextList.size() - 3; i += 3) {
                sb.append("v ");
                sb.append(this.vertextList.get(i));
                sb.append(" ");
                sb.append(this.vertextList.get(i + 1));
                sb.append(" ");
                sb.append(this.vertextList.get(i + 2));
                sb.append("\n");
            }
        }
        if (this.textrueList != null) {
            for (int i2 = 0; i2 < this.textrueList.size() - 2; i2 += 2) {
                sb.append("vt ");
                sb.append(this.textrueList.get(i2));
                sb.append(" ");
                sb.append(1.0f - this.textrueList.get(i2 + 1).floatValue());
                sb.append("\n");
            }
        }
        vertexData(sb.toString());
        return this;
    }
}
