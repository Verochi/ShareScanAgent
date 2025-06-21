package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class NavigateArrow extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private com.amap.api.maps.model.NavigateArrowOptions options;

    public NavigateArrow(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = navigateArrowOptions;
    }

    private void a() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.NavigateArrow)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((com.amap.api.maps.model.NavigateArrow) obj).getId() == getId();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public java.lang.String getId() {
        try {
            return this.overlayName;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public java.util.List<com.amap.api.maps.model.LatLng> getPoints() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getPoints();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @java.lang.Deprecated
    public int getSideColor() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getSideColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getTopColor() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getTopColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getWidth() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getWidth();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getZIndex();
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

    public boolean is3DModel() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.is3DModel();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.isVisible();
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
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void set3DModel(boolean z) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.set3DModel(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(java.util.List<com.amap.api.maps.model.LatLng> list) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.setPoints(list);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSideColor(int i) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.sideColor(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTopColor(int i) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.topColor(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.width(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.zIndex(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
