package com.autonavi.base.amap.mapcore.message;

/* loaded from: classes12.dex */
public class MoveGestureMapMessage extends com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage {
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(1024);
    static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    public MoveGestureMapMessage(int i, float f, float f2) {
        super(i);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = f;
        this.touchDeltaY = f2;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage obtain(int i, float f, float f2, float f3, float f4) {
        com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage acquire;
        synchronized (com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage.class) {
            acquire = M_POOL.acquire();
            if (acquire == null) {
                acquire = new com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage(i, f, f2);
            } else {
                acquire.reset();
                acquire.setParams(i, f, f2);
            }
            acquire.touchX = (int) f3;
            acquire.touchY = (int) f4;
        }
        return acquire;
    }

    private void setParams(int i, float f, float f2) {
        setState(i);
        this.touchDeltaX = f;
        this.touchDeltaY = f2;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        int i = (int) this.touchDeltaX;
        int i2 = (int) this.touchDeltaY;
        int i3 = this.touchX - i;
        int i4 = this.touchY - i2;
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        win2geo(gLMapState, this.touchX, this.touchY, obtain);
        com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
        win2geo(gLMapState, i3, i4, obtain2);
        com.autonavi.amap.mapcore.IPoint obtain3 = com.autonavi.amap.mapcore.IPoint.obtain();
        gLMapState.getMapGeoCenter(obtain3);
        gLMapState.setMapGeoCenter(((android.graphics.Point) obtain3).x + (((android.graphics.Point) obtain2).x - ((android.graphics.Point) obtain).x), ((android.graphics.Point) obtain3).y + (((android.graphics.Point) obtain2).y - ((android.graphics.Point) obtain).y));
        gLMapState.recalculate();
        obtain3.recycle();
        obtain.recycle();
        obtain2.recycle();
    }
}
