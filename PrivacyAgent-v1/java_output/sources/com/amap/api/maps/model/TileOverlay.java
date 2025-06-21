package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class TileOverlay extends com.amap.api.maps.model.BaseOverlay {
    protected java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    protected com.amap.api.maps.model.TileOverlayOptions options;

    public TileOverlay(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.TileOverlayOptions tileOverlayOptions, java.lang.String str) {
        super(str);
        com.autonavi.base.ae.gmap.bean.TileProviderInner tileProviderInner;
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = tileOverlayOptions;
        if (tileOverlayOptions == null || (tileProviderInner = tileOverlayOptions.getTileProviderInner()) == null) {
            return;
        }
        tileProviderInner.init(iGlOverlayLayer, str);
    }

    public final java.lang.Object callNativeFunction(java.lang.String str, java.lang.Object[] objArr) {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final void clearTileCache() {
        callNativeFunction("clearTileCache", null);
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.TileOverlay)) {
            try {
                com.amap.api.maps.model.TileOverlayOptions tileOverlayOptions = this.options;
                if (tileOverlayOptions != null && tileOverlayOptions.equals(((com.amap.api.maps.model.TileOverlay) obj).options)) {
                    if (this.overlayName.equals(((com.amap.api.maps.model.TileOverlay) obj).overlayName)) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final java.lang.String getId() {
        return this.overlayName;
    }

    public final float getZIndex() {
        return this.options.getZIndex();
    }

    public final int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        java.lang.String str = this.overlayName;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.options.hashCode();
    }

    public final boolean isVisible() {
        return this.options.isVisible();
    }

    public final void remove() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        this.options.visible(z);
        updateOption();
    }

    public final void setZIndex(float f) {
        this.options.zIndex(f);
        updateOption();
    }

    public final void updateOption() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (java.lang.Throwable unused) {
        }
    }
}
