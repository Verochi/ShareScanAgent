package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class GL3DModel extends com.amap.api.maps.model.BasePointOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private java.lang.Object object;
    private com.amap.api.maps.model.GL3DModelOptions options;

    public GL3DModel(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = gL3DModelOptions;
    }

    private java.lang.Object a(java.lang.String str, java.lang.Object[] objArr) {
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

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        remove();
    }

    public float getAngle() {
        try {
            return this.options.getAngle();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public java.lang.String getId() {
        try {
            return this.overlayName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public java.lang.Object getObject() {
        return this.object;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public com.amap.api.maps.model.LatLng getPosition() {
        try {
            return this.options.getLatLng();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        try {
            return getAngle();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public java.lang.String getSnippet() {
        try {
            com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getSnippet() : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public java.lang.String getTitle() {
        try {
            com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getTitle() : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        return true;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            return this.options.isVisible();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
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

    public void setAngle(float f) {
        try {
            this.options.angle(f);
            a();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(com.amap.api.maps.model.animation.Animation animation) {
        try {
            a("setAnimation", new java.lang.Object[]{animation});
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(com.autonavi.amap.mapcore.IPoint iPoint) {
    }

    public void setModelFixedLength(int i) {
        try {
            this.options.setModelFixedLength(i);
            a();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(java.lang.Object obj) {
        try {
            this.object = obj;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(com.amap.api.maps.model.LatLng latLng) {
        try {
            this.options.position(latLng);
            a();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f) {
        try {
            setAngle(f);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(java.lang.String str) {
        com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.snippet(str);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(java.lang.String str) {
        com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.title(str);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z) {
        try {
            this.options.setVisible(z);
            a();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setZoomLimit(float f) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.showInfoWindow(this.overlayName);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        java.lang.Object a = a("startAnimation", null);
        if (a instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) a).booleanValue();
        }
        return false;
    }
}
