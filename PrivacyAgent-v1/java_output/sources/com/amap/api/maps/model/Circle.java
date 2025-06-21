package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class Circle extends com.amap.api.maps.model.BaseOverlay {
    java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> a;
    private com.amap.api.maps.model.CircleOptions options;

    public Circle(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.CircleOptions circleOptions, java.lang.String str) {
        super(str);
        this.a = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = circleOptions;
    }

    private void a() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.a.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final boolean contains(com.amap.api.maps.model.LatLng latLng) {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.a.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.IsCircleContainPoint(this.options, latLng);
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.Circle)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((com.amap.api.maps.model.Circle) obj).getId() == getId();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final com.amap.api.maps.model.LatLng getCenter() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getCenter();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int getFillColor() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getFillColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final java.util.List<com.amap.api.maps.model.BaseHoleOptions> getHoleOptions() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getHoleOptions();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final java.lang.String getId() {
        try {
            return this.overlayName;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final double getRadius() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getRadius();
            }
            return 0.0d;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0d;
        }
    }

    public final int getStrokeColor() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getStrokeColor();
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getStrokeDottedLineType() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getStrokeDottedLineType();
            }
            return -1;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public final float getStrokeWidth() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.getZIndex();
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
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                return circleOptions.isVisible();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.a.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCenter(com.amap.api.maps.model.LatLng latLng) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.center(latLng);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFillColor(int i) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.fillColor(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setHoleOptions(java.util.List<com.amap.api.maps.model.BaseHoleOptions> list) {
        if (list != null) {
            try {
                synchronized (list) {
                    this.options.getHoleOptions().clear();
                    this.options.addHoles(list);
                    a();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setRadius(double d) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.radius(d);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeColor(int i) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.strokeColor(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeDottedLineType(int i) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.setStrokeDottedLineType(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.strokeWidth(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            com.amap.api.maps.model.CircleOptions circleOptions = this.options;
            if (circleOptions != null) {
                circleOptions.zIndex(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
