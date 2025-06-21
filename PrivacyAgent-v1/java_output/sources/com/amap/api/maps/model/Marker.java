package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class Marker extends com.amap.api.maps.model.BasePointOverlay {
    private com.autonavi.amap.mapcore.IPoint geoPoint;
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private boolean isClickable;
    private boolean isInfoWindowEnable;
    private boolean isRemoved;
    private boolean isUseAnimation;
    private com.amap.api.maps.model.animation.Animation mCurAnimation;
    private com.amap.api.maps.model.animation.Animation.AnimationListener mCurAnimationListener;
    private com.amap.api.maps.model.Marker.a mCurInnerAnimationListener;
    private java.lang.Object object;
    private com.amap.api.maps.model.MarkerOptions options;
    private com.amap.api.maps.model.LatLng viewModeLatLng;
    private com.autonavi.amap.mapcore.DPoint viewModeLatLngDp;

    public class a implements com.amap.api.maps.model.animation.Animation.AnimationListener {
        private final com.amap.api.mapcore.util.ij b;
        private final com.amap.api.mapcore.util.ij c;

        /* renamed from: com.amap.api.maps.model.Marker$a$1, reason: invalid class name */
        public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
            final /* synthetic */ com.amap.api.maps.model.Marker a;
            final /* synthetic */ com.amap.api.maps.model.animation.Animation.AnimationListener b;

            public AnonymousClass1(com.amap.api.maps.model.Marker marker, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
                this.a = marker;
                this.b = animationListener;
            }

            @Override // com.amap.api.mapcore.util.ij
            public final void runTask() {
                try {
                    com.amap.api.maps.model.animation.Animation.AnimationListener animationListener = this.b;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.model.Marker$a$2, reason: invalid class name */
        public class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
            final /* synthetic */ com.amap.api.maps.model.Marker a;
            final /* synthetic */ com.amap.api.maps.model.animation.Animation.AnimationListener b;

            public AnonymousClass2(com.amap.api.maps.model.Marker marker, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
                this.a = marker;
                this.b = animationListener;
            }

            @Override // com.amap.api.mapcore.util.ij
            public final void runTask() {
                try {
                    com.amap.api.maps.model.animation.Animation.AnimationListener animationListener = this.b;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd();
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        private a(com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
            this.b = new com.amap.api.maps.model.Marker.a.AnonymousClass1(com.amap.api.maps.model.Marker.this, animationListener);
            this.c = new com.amap.api.maps.model.Marker.a.AnonymousClass2(com.amap.api.maps.model.Marker.this, animationListener);
        }

        public /* synthetic */ a(com.amap.api.maps.model.Marker marker, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener, byte b) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            com.amap.api.mapcore.util.dj.a().a(this.c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            com.amap.api.mapcore.util.dj.a().a(this.b);
        }
    }

    public Marker(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.MarkerOptions markerOptions, java.lang.String str) {
        super(str);
        this.isRemoved = false;
        this.viewModeLatLngDp = new com.autonavi.amap.mapcore.DPoint();
        this.viewModeLatLng = null;
        this.isUseAnimation = false;
        this.mCurAnimation = null;
        this.mCurAnimationListener = null;
        this.mCurInnerAnimationListener = null;
        this.isClickable = true;
        this.isInfoWindowEnable = true;
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = markerOptions;
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
    public final void destroy() {
        try {
            remove();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.maps.model.Marker)) {
            try {
                com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
                if (markerOptions != null && markerOptions.equals(((com.amap.api.maps.model.Marker) obj).options)) {
                    if (this.overlayName.equals(((com.amap.api.maps.model.Marker) obj).overlayName)) {
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

    public final float getAlpha() {
        java.lang.Object a2;
        if (this.options != null) {
            return (!this.isUseAnimation || (a2 = a("getAlpha", null)) == null) ? this.options.getAlpha() : ((java.lang.Double) a2).floatValue();
        }
        return 1.0f;
    }

    public final float getAnchorU() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorU();
        }
        return 0.0f;
    }

    public final float getAnchorV() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorV();
        }
        return 0.0f;
    }

    public final int getDisplayLevel() {
        return 5;
    }

    public final com.autonavi.amap.mapcore.IPoint getGeoPoint() {
        if (this.geoPoint == null) {
            this.geoPoint = new com.autonavi.amap.mapcore.IPoint();
        }
        com.amap.api.maps.model.LatLng position = getPosition();
        if (position != null) {
            com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(position.latitude, position.longitude, 20, this.geoPoint);
        }
        return this.geoPoint;
    }

    public final java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> getIcons() {
        try {
            return this.options.getIcons();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final java.lang.String getId() {
        try {
            return this.overlayName;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final java.lang.Object getObject() {
        return this.object;
    }

    public final com.amap.api.maps.model.MarkerOptions getOptions() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions;
        }
        return null;
    }

    public final int getPeriod() {
        try {
            return this.options.getPeriod();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final com.amap.api.maps.model.LatLng getPosition() {
        java.lang.Object a2;
        try {
            if (this.options != null) {
                if (!isViewMode()) {
                    return (!this.isUseAnimation || (a2 = a("getPosition", null)) == null) ? this.options.getPosition() : (com.amap.api.maps.model.LatLng) a2;
                }
                this.glOverlayLayerRef.get().getMap().getPixel2LatLng(this.options.getScreenX(), this.options.getScreenY(), this.viewModeLatLngDp);
                com.amap.api.maps.model.LatLng latLng = this.viewModeLatLng;
                if (latLng != null) {
                    double d = latLng.latitude;
                    com.autonavi.amap.mapcore.DPoint dPoint = this.viewModeLatLngDp;
                    if (d == dPoint.y && latLng.longitude == dPoint.x) {
                        return latLng;
                    }
                }
                com.autonavi.amap.mapcore.DPoint dPoint2 = this.viewModeLatLngDp;
                return new com.amap.api.maps.model.LatLng(dPoint2.y, dPoint2.x);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final float getRotateAngle() {
        if (this.options == null) {
            return 0.0f;
        }
        if (this.isUseAnimation) {
            java.lang.Object a2 = a("getRotateAngle", null);
            "getRotateAngle ".concat(java.lang.String.valueOf(a2));
            if (a2 != null) {
                return ((java.lang.Double) a2).floatValue();
            }
        }
        return this.options.getRotateAngle();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final java.lang.String getSnippet() {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getSnippet();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final java.lang.String getTitle() {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getTitle();
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0.0f;
    }

    public final int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        java.lang.String str = this.overlayName;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.options.hashCode();
    }

    public final void hideInfoWindow() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.hideInfoWindow(this.overlayName);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isClickable() {
        java.lang.Object a2 = a("isClickable", null);
        return a2 instanceof java.lang.Boolean ? ((java.lang.Boolean) a2).booleanValue() : this.isClickable;
    }

    public final boolean isDraggable() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isDraggable();
        }
        return false;
    }

    public final boolean isFlat() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isFlat();
        }
        return false;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isInfoWindowEnable() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        return markerOptions != null ? markerOptions.isInfoWindowEnable() : this.isInfoWindowEnable;
    }

    public final boolean isInfoWindowShown() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return false;
        }
        java.lang.Object a2 = a("isInfoWindowShown", null);
        if (a2 instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) a2).booleanValue();
        }
        return false;
    }

    public final boolean isPerspective() {
        return false;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isViewMode() {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isViewMode();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isVisible() {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.isVisible();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void remove() {
        try {
            if (isInfoWindowShown()) {
                hideInfoWindow();
            }
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            this.isRemoved = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlpha(float f) {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.alpha(f);
            a();
        }
    }

    public final void setAnchor(float f, float f2) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.anchor(f, f2);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setAnimation(com.amap.api.maps.model.animation.Animation animation) {
        if (animation != null) {
            try {
                com.amap.api.maps.model.animation.Animation.AnimationListener animationListener = this.mCurAnimationListener;
                if (animationListener != null) {
                    animation.setAnimationListener(animationListener);
                }
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        this.mCurAnimation = animation;
        this.isUseAnimation = animation != null;
        a("setAnimation", new java.lang.Object[]{animation});
        if (animation != null) {
            animation.resetUpdateFlags();
        }
    }

    public final void setAnimationListener(com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
        this.mCurAnimationListener = animationListener;
        com.amap.api.maps.model.Marker.a aVar = new com.amap.api.maps.model.Marker.a(this, animationListener, (byte) 0);
        this.mCurInnerAnimationListener = aVar;
        if (this.mCurAnimation != null) {
            a("setAnimationListener", new java.lang.Object[]{aVar});
        }
    }

    public final void setAutoOverturnInfoWindow(boolean z) {
    }

    public final void setBelowMaskLayer(boolean z) {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.belowMaskLayer(z);
            a();
        }
    }

    public final void setClickable(boolean z) {
        this.isClickable = z;
        a("setClickable", new java.lang.Object[]{java.lang.Boolean.valueOf(z)});
    }

    public final void setDisplayLevel(int i) {
    }

    public final void setDraggable(boolean z) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.draggable(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFixingPointEnable(boolean z) {
    }

    public final void setFlat(boolean z) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.setFlat(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setGeoPoint(com.autonavi.amap.mapcore.IPoint iPoint) {
        this.geoPoint = iPoint;
        if (iPoint != null) {
            com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(((android.graphics.Point) iPoint).x, ((android.graphics.Point) iPoint).y, 20);
            com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
            pixelsToLatLong.recycle();
            this.options.position(latLng);
            a();
        }
    }

    public final void setIcon(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                    a();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setIcons(java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> arrayList) {
        try {
            this.options.icons(arrayList);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowEnable(boolean z) {
        this.isInfoWindowEnable = z;
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z);
            a();
        }
    }

    public final void setMarkerOptions(com.amap.api.maps.model.MarkerOptions markerOptions) {
        this.options = markerOptions;
        a();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setObject(java.lang.Object obj) {
        this.object = obj;
    }

    public final void setPeriod(int i) {
        try {
            this.options.period(i);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPerspective(boolean z) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setPosition(com.amap.api.maps.model.LatLng latLng) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPositionByPixels(int i, int i2) {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.setScreenPosition(i, i2);
            a();
        }
    }

    public final void setPositionNotUpdate(com.amap.api.maps.model.LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setRotateAngle(float f) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.rotateAngle(f);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateAngleNotUpdate(float f) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setSnippet(java.lang.String str) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.snippet(str);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setTitle(java.lang.String str) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.title(str);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setToTop() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.set2Top(this.overlayName);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.visible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        com.amap.api.maps.model.MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.zIndex(f);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void showInfoWindow() {
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
    public final boolean startAnimation() {
        java.lang.Object a2 = a("startAnimation", null);
        if (a2 instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) a2).booleanValue();
        }
        return false;
    }
}
