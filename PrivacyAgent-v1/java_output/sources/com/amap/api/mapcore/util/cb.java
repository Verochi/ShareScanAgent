package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cb implements com.autonavi.amap.mapcore.interfaces.IInfoWindowManager, com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction {
    com.amap.api.mapcore.util.aj a;
    private final android.content.Context b;
    private final com.amap.api.maps.interfaces.IGlOverlayLayer c;
    private final java.lang.String d = "PopupOverlay";

    public cb(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, android.content.Context context) {
        this.b = context;
        this.c = iGlOverlayLayer;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void hideInfoWindow() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "hideInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(android.view.MotionEvent motionEvent) {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.c;
        if (iGlOverlayLayer != null && motionEvent != null) {
            java.lang.Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new java.lang.Object[]{java.lang.Double.valueOf(motionEvent.getX()), java.lang.Double.valueOf(motionEvent.getY())});
            if (nativeProperties instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) nativeProperties).booleanValue();
            }
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(com.amap.api.mapcore.util.aj ajVar) {
        synchronized (this) {
            this.a = ajVar;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAnimation(com.amap.api.maps.model.animation.Animation animation, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAppearAnimation(com.amap.api.maps.model.animation.Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackColor(int i) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackEnable(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackScale(float f, float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowDisappearAnimation(com.amap.api.maps.model.animation.Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowMovingAnimation(com.amap.api.maps.model.animation.Animation animation) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(com.amap.api.maps.model.BasePointOverlay basePointOverlay) throws android.os.RemoteException {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.c;
        if (iGlOverlayLayer != null && basePointOverlay != null) {
            iGlOverlayLayer.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new java.lang.Object[]{basePointOverlay.getId()});
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(com.autonavi.base.amap.api.mapcore.BaseOverlayImp baseOverlayImp) throws android.os.RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void startAnimation() {
    }
}
