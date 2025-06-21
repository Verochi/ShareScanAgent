package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class Polyline extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private com.amap.api.maps.model.PolylineOptions options;

    public Polyline(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.PolylineOptions polylineOptions) {
        super("");
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = polylineOptions;
    }

    public Polyline(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.PolylineOptions polylineOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = polylineOptions;
    }

    private void a() {
        try {
            synchronized (this) {
                com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (!android.text.TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                    iGlOverlayLayer.updateOption(this.overlayName, this.options);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.amap.api.maps.model.Polyline)) {
            return false;
        }
        try {
            if (super.equals(obj)) {
                return true;
            }
            return ((com.amap.api.maps.model.Polyline) obj).getId() == getId();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getColor() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getEraseColor() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getEraseColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public com.amap.api.maps.model.BitmapDescriptor getEraseTexture() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getEraseTexture();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean getEraseVisible() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getEraseVisible();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public float getFootPrintGap() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getFootPrintGap();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public com.amap.api.maps.model.BitmapDescriptor getFootPrintTexture() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getFootPrintTexture();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public java.lang.String getId() {
        try {
            return this.overlayName;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public com.amap.api.maps.model.LatLng getNearestLatLng(com.amap.api.maps.model.LatLng latLng) {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.getNearestLatLng(this.options, latLng);
        }
        return null;
    }

    public com.amap.api.maps.model.PolylineOptions getOptions() {
        return this.options;
    }

    public java.util.List<com.amap.api.maps.model.LatLng> getPoints() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPoints();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getPolylineShownRangeBegin() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPolylineShownRangeBegin();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getPolylineShownRangeEnd() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPolylineShownRangeEnd();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getShownRatio() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getShownRatio();
            }
            return -1.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1.0f;
        }
    }

    public float getWidth() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getWidth();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getZIndex();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isDottedLine() {
        com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            return polylineOptions.isDottedLine();
        }
        return false;
    }

    public boolean isGeodesic() {
        com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
        return polylineOptions != null && polylineOptions.isGeodesic();
    }

    public boolean isShowPolylineRangeEnable() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.isShowPolylineRangeEnable();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.isVisible();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            this.overlayName = null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAboveMaskLayer(boolean z) {
        com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.aboveMaskLayer(z);
            a();
        }
    }

    public void setColor(int i) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.color(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @java.lang.Deprecated
    public void setCustemTextureIndex(java.util.List<java.lang.Integer> list) {
        setCustomTextureIndex(list);
    }

    public void setCustomTexture(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setCustomTexture(bitmapDescriptor);
            a();
        }
    }

    public void setCustomTextureIndex(java.util.List<java.lang.Integer> list) {
        synchronized (this) {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setCustomTextureIndex(list);
                a();
            }
        }
    }

    public void setCustomTextureList(java.util.List<com.amap.api.maps.model.BitmapDescriptor> list) {
        try {
            this.options.setCustomTextureList(list);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDottedLine(boolean z) {
        com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setDottedLine(z);
            a();
        }
    }

    public void setEraseColor(boolean z, int i) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setEraseColor(z, i);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setEraseTexture(boolean z, com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setEraseTexture(z, bitmapDescriptor);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setFootPrintGap(float f) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setFootPrintGap(f);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setFootPrintTexture(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setFootPrintTexture(bitmapDescriptor);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setGeodesic(boolean z) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.geodesic(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setOptions(com.amap.api.maps.model.PolylineOptions polylineOptions) {
        this.options = polylineOptions;
        a();
    }

    public void setPoints(java.util.List<com.amap.api.maps.model.LatLng> list) {
        try {
            synchronized (this) {
                com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.setPoints(list);
                    a();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPolylineShowRange(float f, float f2) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setPolylineShowRange(f, f2);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setShownRange(float f, float f2) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setShownRange(f, f2);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setShownRatio(float f) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setShownRatio(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTransparency(float f) {
        com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.transparency(f);
            a();
        }
    }

    public void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.width(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.zIndex(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void showPolylineRangeEnabled(boolean z) {
        try {
            com.amap.api.maps.model.PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.showPolylineRangeEnabled(z);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
