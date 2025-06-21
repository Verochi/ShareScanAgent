package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes12.dex */
public class AdglMapAnimPivotZoom extends com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V zoomParam = null;

    public AdglMapAnimPivotZoom(int i) {
        reset();
        this.duration = i;
    }

    public void commitAnimation(java.lang.Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        com.autonavi.base.ae.gmap.GLMapState gLMapState = (com.autonavi.base.ae.gmap.GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        float mapZoomer = gLMapState.getMapZoomer();
        if (java.lang.Math.abs(this.mapLevelTo - mapZoomer) < 1.0E-6d) {
            this.isOver = true;
            this.hasCheckParams = true;
            return;
        }
        this.zoomParam.setFromValue(mapZoomer);
        this.zoomParam.setToValue(this.mapLevelTo);
        if (!this.zoomCenter) {
            com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.beginCenterGeoX = ((android.graphics.Point) obtain).x;
            this.beginCenterGeoY = ((android.graphics.Point) obtain).y;
            com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
            gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, obtain2);
            this.pivotGeoX = ((android.graphics.Point) obtain2).x;
            this.pivotGeoY = ((android.graphics.Point) obtain2).y;
            obtain.recycle();
            obtain2.recycle();
        }
        this.hasCheckParams = true;
        this.isOver = false;
        this.startTime = android.os.SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(java.lang.Object obj) {
        com.autonavi.base.ae.gmap.GLMapState gLMapState = (com.autonavi.base.ae.gmap.GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f = uptimeMillis / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        }
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        this.zoomParam.setNormalizedTime(f);
        float curValue = this.zoomParam.getCurValue();
        if (curValue > 20.0f) {
            this.isOver = true;
            curValue = 20.0f;
        }
        if (curValue < 3.0f) {
            this.isOver = true;
            curValue = 3.0f;
        }
        if (!this.zoomCenter) {
            float pow = (float) java.lang.Math.pow(2.0d, curValue - this.zoomParam.getFromValue());
            int i = this.pivotGeoX;
            int i2 = this.beginCenterGeoX;
            int i3 = (int) ((i - i2) * (1.0f - (1.0f / pow)));
            int i4 = this.pivotGeoY;
            int i5 = this.beginCenterGeoY;
            gLMapState.setMapGeoCenter(i2 + i3, i5 + ((int) ((i4 - i5) * r2)));
        }
        gLMapState.setMapZoomer(curValue);
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setToMapZoomAndPivot(float f, int i, android.graphics.Point point) {
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V();
        this.zoomParam = abstractAdglAnimationParam1V;
        abstractAdglAnimationParam1V.setInterpolatorType(i, 1.0f);
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        this.mapLevelTo = f;
        if (point != null) {
            this.winPivotX = point.x;
            this.winPivotY = point.y;
            this.zoomCenter = false;
        }
    }
}
