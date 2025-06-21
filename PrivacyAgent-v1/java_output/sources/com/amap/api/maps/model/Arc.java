package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class Arc extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private com.amap.api.maps.model.ArcOptions options;

    public Arc(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.ArcOptions arcOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = arcOptions;
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

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.Arc)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((com.amap.api.maps.model.Arc) obj).getId() == getId();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final java.lang.String getId() {
        try {
            return this.overlayName;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int getStrokeColor() {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final float getStrokeWidth() {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getZIndex();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int hashCode() {
        try {
            return super.hashCode();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final boolean isVisible() {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.isVisible();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeColor(int i) {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeColor(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeWidth(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            com.amap.api.maps.model.ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.zIndex(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
