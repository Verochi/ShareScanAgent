package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes12.dex */
public class AdglMapAnimFlingP20 extends com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation {
    private boolean hasCheckParams;
    private com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public AdglMapAnimFlingP20(int i) {
        reset();
        this.duration = i;
    }

    public void commitAnimation(java.lang.Object obj) {
        com.autonavi.base.ae.gmap.GLMapState gLMapState = (com.autonavi.base.ae.gmap.GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f = this.velocityScreenX;
        int i = this.duration;
        float f2 = (f * i) / 2000.0f;
        float f3 = (this.velocityScreenY * i) / 2000.0f;
        if (java.lang.Math.abs(f2) != 0.0f && java.lang.Math.abs(f3) != 0.0f) {
            this.isOver = false;
            com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.moveParam.setFromValue(((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y);
            double mapAngle = (gLMapState.getMapAngle() * 3.141592653589793d) / 180.0d;
            double mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double d = f2;
            double d2 = f3;
            this.moveParam.setToValue(((android.graphics.Point) obtain).x - (((java.lang.Math.cos(mapAngle) * d) - (java.lang.Math.sin(mapAngle) * d2)) * mapLenWithWin), ((android.graphics.Point) obtain).y - (mapLenWithWin * ((d * java.lang.Math.sin(mapAngle)) + (d2 * java.lang.Math.cos(mapAngle)))));
            this.needMove = this.moveParam.needToCaculate();
            obtain.recycle();
        }
        this.hasCheckParams = true;
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
        if (f < 0.0f || f > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f);
        gLMapState.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
    }

    public void reset() {
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f, float f2) {
        this.moveParam = null;
        this.velocityScreenX = f;
        this.velocityScreenY = f2;
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
