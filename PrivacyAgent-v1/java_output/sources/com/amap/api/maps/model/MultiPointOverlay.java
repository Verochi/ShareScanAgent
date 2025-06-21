package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class MultiPointOverlay extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private com.amap.api.maps.model.MultiPointOverlayOptions options;

    public MultiPointOverlay(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = multiPointOverlayOptions;
    }

    private void a() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public java.util.List<com.amap.api.maps.model.MultiPointItem> getItems() {
        com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            return multiPointOverlayOptions.getMultiPointItems();
        }
        return null;
    }

    public void remove() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setAnchor(float f, float f2) {
        com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            multiPointOverlayOptions.anchor(f, f2);
            a();
        }
    }

    public void setEnable(boolean z) {
        com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            multiPointOverlayOptions.setEnable(z);
            a();
        }
    }

    public void setItems(java.util.List<com.amap.api.maps.model.MultiPointItem> list) {
        com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions = this.options;
        if (multiPointOverlayOptions != null) {
            multiPointOverlayOptions.setMultiPointItems(list);
            a();
        }
    }
}
