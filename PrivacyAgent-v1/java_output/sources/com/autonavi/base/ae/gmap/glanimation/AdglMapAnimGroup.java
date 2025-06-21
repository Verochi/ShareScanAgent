package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes12.dex */
public class AdglMapAnimGroup extends com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    int startZoomDuration;
    com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V zoomStartParam = null;
    com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V zoomEndParam = null;
    com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V moveParam = null;
    com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V rotateMapParam = null;
    com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V rotateCameraParam = null;

    public AdglMapAnimGroup(int i) {
        reset();
        this.duration = i;
    }

    public static boolean checkLevel(float f) {
        return f >= 3.0f && f <= 20.0f;
    }

    private void initZoomEndParam(float f, float f2, int i) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i, 1.0f);
        this.zoomEndParam.setToValue(f2);
        this.zoomEndParam.setFromValue(f);
    }

    private void initZoomStartParam(float f, int i) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i, 1.0f);
        this.zoomStartParam.setToValue(f);
    }

    public void commitAnimation(java.lang.Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        com.autonavi.base.ae.gmap.GLMapState gLMapState = (com.autonavi.base.ae.gmap.GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (this.needZoom) {
            if (this.zoomStartParam == null) {
                this.hasCheckParams = true;
                return;
            }
            float mapZoomer = gLMapState.getMapZoomer();
            this.zoomStartParam.setFromValue(mapZoomer);
            if (this.hasMidZoom) {
                float toValue = this.zoomStartParam.getToValue() - mapZoomer;
                float fromValue = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
                if (java.lang.Math.abs(toValue) < 1.0E-6d || java.lang.Math.abs(fromValue) < 1.0E-6d) {
                    this.hasMidZoom = false;
                    this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam = null;
                } else {
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam.needToCaculate();
                }
            }
            if (!this.hasMidZoom && java.lang.Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) < 1.0E-6d) {
                this.needZoom = false;
            }
            if (this.needZoom) {
                if (this.hasMidZoom) {
                    int i = (this.duration - this.midZoomDuration) >> 1;
                    this.startZoomDuration = i;
                    this.endZoomDuration = i;
                } else {
                    this.startZoomDuration = this.duration;
                }
            }
        }
        if (this.needMove && this.moveParam != null) {
            com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            int i2 = ((android.graphics.Point) obtain).x;
            int i3 = ((android.graphics.Point) obtain).y;
            obtain.recycle();
            this.moveParam.setFromValue(i2, i3);
            this.needMove = this.moveParam.needToCaculate();
        }
        if (this.needRotateMap && this.rotateMapParam != null) {
            float mapAngle = gLMapState.getMapAngle();
            float toValue2 = this.rotateMapParam.getToValue();
            if (mapAngle > 180.0f && toValue2 == 0.0f) {
                toValue2 = 360.0f;
            }
            float f = ((int) toValue2) - ((int) mapAngle);
            if (f > 180.0f) {
                toValue2 -= 360.0f;
            } else if (f < -180.0f) {
                toValue2 += 360.0f;
            }
            this.rotateMapParam.setFromValue(mapAngle);
            this.rotateMapParam.setToValue(toValue2);
            this.needRotateMap = this.rotateMapParam.needToCaculate();
        }
        if (this.needRotateCamera && this.rotateCameraParam != null) {
            this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
            this.needRotateCamera = this.rotateCameraParam.needToCaculate();
        }
        if (this.needMove || this.needZoom || this.needRotateMap || this.needRotateCamera) {
            this.isOver = false;
        } else {
            this.isOver = true;
        }
        this.hasCheckParams = true;
        this.startTime = android.os.SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(java.lang.Object obj) {
        float curValue;
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
        int i = this.duration;
        if (i == 0.0f) {
            this.isOver = true;
            return;
        }
        float f = uptimeMillis / i;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        } else if (f < 0.0f) {
            this.isOver = true;
            return;
        }
        if (this.needZoom) {
            gLMapState.getMapZoomer();
            if (this.hasMidZoom) {
                long j = this.offsetTime;
                int i2 = this.startZoomDuration;
                if (j <= i2) {
                    this.zoomStartParam.setNormalizedTime(j / i2);
                    curValue = this.zoomStartParam.getCurValue();
                } else {
                    int i3 = this.midZoomDuration;
                    if (j <= i2 + i3) {
                        curValue = this.zoomStartParam.getToValue();
                    } else {
                        this.zoomEndParam.setNormalizedTime(((j - i2) - i3) / this.endZoomDuration);
                        curValue = this.zoomEndParam.getCurValue();
                    }
                }
                if (this.isOver) {
                    curValue = this.zoomEndParam.getToValue();
                }
            } else {
                this.zoomStartParam.setNormalizedTime(f);
                curValue = this.zoomStartParam.getCurValue();
            }
            gLMapState.setMapZoomer(curValue);
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null && this.needMove) {
            abstractAdglAnimationParam2V.setNormalizedTime(f);
            int fromXValue = (int) this.moveParam.getFromXValue();
            int fromYValue = (int) this.moveParam.getFromYValue();
            int toXValue = (int) this.moveParam.getToXValue();
            int toYValue = (int) this.moveParam.getToYValue();
            float curMult = this.moveParam.getCurMult();
            gLMapState.setMapGeoCenter(fromXValue + ((int) ((toXValue - fromXValue) * curMult)), fromYValue + ((int) ((toYValue - fromYValue) * curMult)));
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null && this.needRotateMap) {
            abstractAdglAnimationParam1V.setNormalizedTime(f);
            gLMapState.setMapAngle((int) this.rotateMapParam.getCurValue());
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V2 == null || !this.needRotateCamera) {
            return;
        }
        abstractAdglAnimationParam1V2.setNormalizedTime(f);
        gLMapState.setCameraDegree((int) this.rotateCameraParam.getCurValue());
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomStartParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.zoomEndParam;
        if (abstractAdglAnimationParam1V2 != null) {
            abstractAdglAnimationParam1V2.reset();
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V abstractAdglAnimationParam1V3 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V3 != null) {
            abstractAdglAnimationParam1V3.reset();
        }
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setToCameraDegree(float f, int i) {
        this.needRotateCamera = false;
        if (f > 80.0f || f < 0.0f) {
            return;
        }
        this.needRotateCamera = true;
        if (this.rotateCameraParam == null) {
            this.rotateCameraParam = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V();
        }
        this.rotateCameraParam.reset();
        this.rotateCameraParam.setInterpolatorType(i, 1.0f);
        this.rotateCameraParam.setToValue(f);
    }

    public void setToMapAngle(float f, int i) {
        float f2 = f % 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i, 1.0f);
        this.rotateMapParam.setToValue(f2);
    }

    public void setToMapCenterGeo(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.needMove = true;
        if (this.moveParam == null) {
            this.moveParam = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V();
        }
        this.moveParam.reset();
        this.moveParam.setInterpolatorType(i3, 1.0f);
        this.moveParam.setToValue(i, i2);
    }

    public void setToMapLevel(float f, float f2, int i) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i > 0 && i < this.duration) {
            this.midZoomDuration = i;
        }
        if (checkLevel(f) && checkLevel(f2)) {
            this.hasMidZoom = true;
            initZoomStartParam(f2, 0);
            initZoomEndParam(f2, f, 0);
        } else if (checkLevel(f)) {
            this.hasMidZoom = false;
            initZoomStartParam(f, 0);
        } else if (!checkLevel(f2)) {
            this.needZoom = false;
        } else {
            this.hasMidZoom = false;
            initZoomStartParam(f2, 0);
        }
    }

    public void setToMapLevel(float f, int i) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f)) {
            initZoomStartParam(f, i);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }
}
