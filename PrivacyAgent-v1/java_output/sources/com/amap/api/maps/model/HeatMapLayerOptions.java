package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class HeatMapLayerOptions extends com.amap.api.maps.model.BaseOptions {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.Gradient DEFAULT_GRADIENT;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static final int[] DEFAULT_GRADIENT_COLORS;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static final float[] DEFAULT_GRADIENT_START_POINTS;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final double DEFAULT_OPACITY = 0.6d;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final int DEFAULT_RADIUS = 12;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final int TYPE_GRID = 1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final int TYPE_HEXAGON = 2;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private int[] mColors;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.util.Collection<com.amap.api.maps.model.WeightedLatLng> mData;
    private double mLatitude;
    private float[] mStartPoints;
    private double[] pointList;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.Gradient mGradient = DEFAULT_GRADIENT;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private double maxIntensity = 0.0d;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float mGap = 0.0f;
    private int mType = 2;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isPointsUpdated = false;

    static {
        int[] iArr = {android.graphics.Color.rgb(102, 225, 0), android.graphics.Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new com.amap.api.maps.model.Gradient(iArr, fArr);
    }

    public HeatMapLayerOptions() {
        this.type = "HeatMapLayerOptions";
    }

    private static java.util.Collection<com.amap.api.maps.model.WeightedLatLng> a(java.util.Collection<com.amap.api.maps.model.LatLng> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.amap.api.maps.model.LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.amap.api.maps.model.WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    private void a() {
        java.util.Collection<com.amap.api.maps.model.WeightedLatLng> data;
        com.amap.api.maps.model.LatLng latLng;
        if (!this.isPointsUpdated || (data = getData()) == null) {
            return;
        }
        this.pointList = new double[data.size() * 3];
        double d = Double.NaN;
        double d2 = Double.NaN;
        int i = 0;
        for (com.amap.api.maps.model.WeightedLatLng weightedLatLng : data) {
            if (weightedLatLng != null && (latLng = weightedLatLng.latLng) != null) {
                double[] dArr = this.pointList;
                int i2 = i * 3;
                double d3 = latLng.latitude;
                dArr[i2] = d3;
                dArr[i2 + 1] = latLng.longitude;
                dArr[i2 + 2] = weightedLatLng.intensity;
                i++;
                if (java.lang.Double.isNaN(d)) {
                    d = d3;
                }
                if (java.lang.Double.isNaN(d2)) {
                    d2 = d3;
                }
                if (d3 > d2) {
                    d2 = d3;
                }
                if (d3 < d) {
                    d = d3;
                }
            }
        }
        this.mLatitude = (java.lang.Double.isNaN(d) || java.lang.Double.isNaN(d2)) ? 0.0d : (d + d2) / 2.0d;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions data(java.util.Collection<com.amap.api.maps.model.LatLng> collection) {
        return weightedData(a(collection));
    }

    public com.amap.api.maps.model.HeatMapLayerOptions gap(float f) {
        this.mGap = f;
        return this;
    }

    public java.util.Collection<com.amap.api.maps.model.WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public com.amap.api.maps.model.Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions gradient(com.amap.api.maps.model.Gradient gradient) {
        this.mGradient = gradient;
        if (gradient != null) {
            this.mColors = gradient.getColors();
            this.mStartPoints = this.mGradient.getStartPoints();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions maxIntensity(double d) {
        this.maxIntensity = d;
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions maxZoom(float f) {
        this.maxZoom = f;
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions minZoom(float f) {
        this.minZoom = f;
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions opacity(float f) {
        this.mOpacity = java.lang.Math.max(0.0f, java.lang.Math.min(f, 1.0f));
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions size(float f) {
        this.mSize = f;
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions type(int i) {
        this.mType = i;
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions weightedData(java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection) {
        this.mData = collection;
        this.isPointsUpdated = true;
        a();
        return this;
    }

    public com.amap.api.maps.model.HeatMapLayerOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
