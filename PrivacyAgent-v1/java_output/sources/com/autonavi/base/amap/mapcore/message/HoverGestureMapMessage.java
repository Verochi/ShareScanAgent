package com.autonavi.base.amap.mapcore.message;

/* loaded from: classes12.dex */
public class HoverGestureMapMessage extends com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage {
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(256);
    public float angleDelta;

    public HoverGestureMapMessage(int i, float f) {
        super(i);
        this.angleDelta = f;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage obtain(int i, float f) {
        com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            acquire = new com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage(i, f);
        } else {
            acquire.reset();
        }
        acquire.setParams(i, f);
        return acquire;
    }

    private void setParams(int i, float f) {
        setState(i);
        this.angleDelta = f;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        if (cameraDegree < 0.0f) {
            cameraDegree = 0.0f;
        } else if (cameraDegree > 80.0f) {
            cameraDegree = 80.0f;
        } else if (gLMapState.getCameraDegree() > 40.0f && cameraDegree > 40.0f && gLMapState.getCameraDegree() > cameraDegree) {
            cameraDegree = 40.0f;
        }
        gLMapState.setCameraDegree(cameraDegree);
        gLMapState.recalculate();
    }
}
