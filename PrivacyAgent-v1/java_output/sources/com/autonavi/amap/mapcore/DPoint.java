package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public class DPoint {
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.autonavi.amap.mapcore.DPoint> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(32);
    public double x;
    public double y;

    public DPoint() {
    }

    public DPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public static com.autonavi.amap.mapcore.DPoint obtain() {
        com.autonavi.amap.mapcore.DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new com.autonavi.amap.mapcore.DPoint();
        }
        acquire.set(0.0d, 0.0d);
        return acquire;
    }

    public static com.autonavi.amap.mapcore.DPoint obtain(double d, double d2) {
        com.autonavi.amap.mapcore.DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new com.autonavi.amap.mapcore.DPoint(d, d2);
        }
        acquire.set(d, d2);
        return acquire;
    }

    private void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.autonavi.amap.mapcore.DPoint)) {
            return false;
        }
        com.autonavi.amap.mapcore.DPoint dPoint = (com.autonavi.amap.mapcore.DPoint) obj;
        return java.lang.Double.doubleToLongBits(this.x) == java.lang.Double.doubleToLongBits(dPoint.x) && java.lang.Double.doubleToLongBits(this.y) == java.lang.Double.doubleToLongBits(dPoint.y);
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
