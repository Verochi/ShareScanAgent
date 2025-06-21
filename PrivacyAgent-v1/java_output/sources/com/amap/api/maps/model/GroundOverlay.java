package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class GroundOverlay extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private float high;
    private com.amap.api.maps.model.GroundOverlayOptions options;
    private com.amap.api.maps.model.LatLng point;
    private float width;

    public GroundOverlay(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = groundOverlayOptions;
    }

    private void a() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public final void destroy() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.GroundOverlay)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((com.amap.api.maps.model.GroundOverlay) obj).getId() == getId();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final float getBearing() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getBearing();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final com.amap.api.maps.model.LatLngBounds getBounds() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getBounds();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getHeight() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getHeight();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
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

    public final com.amap.api.maps.model.LatLng getPosition() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getLocation();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getTransparency() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getTransparency();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getWidth() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getWidth();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getZIndex();
            }
            return 0.0f;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean isVisible() {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.isVisible();
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
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || groundOverlayOptions.getImage() == null) {
                return;
            }
            this.options.getImage().recycle();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setBearing(float f) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.bearing(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDimensions(float f) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                com.amap.api.maps.model.LatLng latLng = this.point;
                if (latLng == null) {
                    latLng = groundOverlayOptions.getLocation();
                }
                if (latLng == null) {
                    this.width = f;
                } else {
                    this.options.position(latLng, f);
                    a();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDimensions(float f, float f2) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                com.amap.api.maps.model.LatLng latLng = this.point;
                if (latLng == null) {
                    latLng = groundOverlayOptions.getLocation();
                }
                if (latLng == null) {
                    this.width = f;
                    this.high = f2;
                } else {
                    com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions2 = this.options;
                    groundOverlayOptions2.position(groundOverlayOptions2.getLocation(), f, f2);
                    a();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setImage(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.image(bitmapDescriptor);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPosition(com.amap.api.maps.model.LatLng latLng) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || latLng == null) {
                return;
            }
            float f = this.width;
            if (f <= 0.0f) {
                f = groundOverlayOptions.getWidth();
            }
            float f2 = this.high;
            if (f2 <= 0.0f) {
                f2 = this.options.getHeight();
            }
            if (f == 0.0f) {
                this.point = latLng;
                return;
            }
            if (f2 == 0.0f) {
                this.options.position(latLng, f);
                a();
            } else if (f2 > 0.0f) {
                this.options.position(latLng, f, f2);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPositionFromBounds(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || latLngBounds == null) {
                return;
            }
            groundOverlayOptions.positionFromBounds(latLngBounds);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTransparency(float f) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.transparency(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.zIndex(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
