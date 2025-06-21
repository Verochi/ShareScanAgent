package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public class FPoint extends android.graphics.PointF {
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.autonavi.base.amap.mapcore.FPoint> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(32);

    public FPoint() {
    }

    public FPoint(float f, float f2) {
        ((android.graphics.PointF) this).x = f;
        ((android.graphics.PointF) this).y = f2;
    }

    public static com.autonavi.base.amap.mapcore.FPoint obtain() {
        com.autonavi.base.amap.mapcore.FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new com.autonavi.base.amap.mapcore.FPoint();
        }
        acquire.set(0.0f, 0.0f);
        return acquire;
    }

    public static com.autonavi.base.amap.mapcore.FPoint obtain(float f, float f2) {
        com.autonavi.base.amap.mapcore.FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new com.autonavi.base.amap.mapcore.FPoint(f, f2);
        }
        acquire.set(f, f2);
        return acquire;
    }

    @Override // android.graphics.PointF
    public boolean equals(java.lang.Object obj) {
        com.autonavi.base.amap.mapcore.FPoint fPoint = (com.autonavi.base.amap.mapcore.FPoint) obj;
        return fPoint != null && ((android.graphics.PointF) this).x == ((android.graphics.PointF) fPoint).x && ((android.graphics.PointF) this).y == ((android.graphics.PointF) fPoint).y;
    }

    @Override // android.graphics.PointF
    public int hashCode() {
        java.lang.Float.floatToIntBits(((android.graphics.PointF) this).x);
        return java.lang.Float.floatToIntBits(((android.graphics.PointF) this).y) * 37;
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
