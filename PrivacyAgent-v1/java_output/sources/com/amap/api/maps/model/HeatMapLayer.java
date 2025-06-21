package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class HeatMapLayer extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private com.amap.api.maps.model.HeatMapLayerOptions options;

    public HeatMapLayer(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = heatMapLayerOptions;
        a();
    }

    private void a() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void destroy() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.HeatMapLayer)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((com.amap.api.maps.model.HeatMapLayer) obj).getId().equals(getId());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public com.amap.api.maps.model.HeatMapItem getHeatMapItem(com.amap.api.maps.model.LatLng latLng) {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer == null) {
                return null;
            }
            java.lang.Object nativeProperties = iGlOverlayLayer.getNativeProperties(this.overlayName, "getHeatMapItem", new java.lang.Object[]{latLng});
            if (nativeProperties instanceof com.amap.api.maps.model.HeatMapItem) {
                return (com.amap.api.maps.model.HeatMapItem) nativeProperties;
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

    public com.amap.api.maps.model.HeatMapLayerOptions getOptions() {
        try {
            return this.options;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        try {
            com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                return heatMapLayerOptions.getZIndex();
            }
            return 0.0f;
        } catch (java.lang.Throwable unused) {
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                return heatMapLayerOptions.isVisible();
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public void setOptions(com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions) {
        try {
            this.options = heatMapLayerOptions;
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                heatMapLayerOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setZIndex(float f) {
        try {
            com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                heatMapLayerOptions.zIndex(f);
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
