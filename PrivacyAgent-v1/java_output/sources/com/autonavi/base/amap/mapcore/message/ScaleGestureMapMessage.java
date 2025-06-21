package com.autonavi.base.amap.mapcore.message;

/* loaded from: classes12.dex */
public class ScaleGestureMapMessage extends com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage {
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(256);
    public int pivotX;
    public int pivotY;
    public float scaleDelta;

    public ScaleGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        this.scaleDelta = 0.0f;
        this.pivotX = 0;
        this.pivotY = 0;
        setParams(i, f, i2, i3);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage obtain(int i, float f, int i2, int i3) {
        com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage(i, f, i2, i3);
        }
        acquire.reset();
        acquire.setParams(i, f, i2, i3);
        return acquire;
    }

    private void setMapZoomer(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    private void setParams(int i, float f, int i2, int i3) {
        setState(i);
        this.scaleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 1;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        com.autonavi.amap.mapcore.IPoint obtain;
        com.autonavi.amap.mapcore.IPoint obtain2;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i = this.width >> 1;
            i2 = this.height >> 1;
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
        setMapZoomer(gLMapState);
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
