package com.autonavi.base.amap.mapcore.message;

/* loaded from: classes12.dex */
public class RotateGestureMapMessage extends com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage {
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(256);
    public float angleDelta;
    public int pivotX;
    public int pivotY;

    public RotateGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        this.pivotX = 0;
        this.pivotY = 0;
        this.angleDelta = 0.0f;
        setParams(i, f, i2, i3);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage obtain(int i, float f, int i2, int i3) {
        com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage(i, f, i2, i3);
        }
        acquire.reset();
        acquire.setParams(i, f, i2, i3);
        return acquire;
    }

    private void setParams(int i, float f, int i2, int i3) {
        setState(i);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        com.autonavi.amap.mapcore.IPoint obtain;
        com.autonavi.amap.mapcore.IPoint obtain2;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isUseAnchor) {
            i = this.anchorX;
            i2 = this.anchorY;
        }
        if (i > 0 || i2 > 0) {
            obtain = com.autonavi.amap.mapcore.IPoint.obtain();
            obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
            win2geo(gLMapState, i, i2, obtain);
            gLMapState.setMapGeoCenter(((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y);
        } else {
            obtain = null;
            obtain2 = null;
        }
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
        if (i > 0 || i2 > 0) {
            win2geo(gLMapState, i, i2, obtain2);
            if (obtain != null) {
                gLMapState.setMapGeoCenter((((android.graphics.Point) obtain).x * 2) - ((android.graphics.Point) obtain2).x, (((android.graphics.Point) obtain).y * 2) - ((android.graphics.Point) obtain2).y);
            }
            gLMapState.recalculate();
        }
        if (obtain != null) {
            obtain.recycle();
        }
        if (obtain2 != null) {
            obtain2.recycle();
        }
    }
}
