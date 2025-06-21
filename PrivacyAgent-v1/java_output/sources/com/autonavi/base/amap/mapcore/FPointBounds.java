package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final com.autonavi.base.amap.mapcore.FPoint northeast;
    public final com.autonavi.base.amap.mapcore.FPoint southwest;

    public static final class Builder {
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;
        private float mEast = Float.NEGATIVE_INFINITY;

        private boolean containsx(double d) {
            float f = this.mWest;
            float f2 = this.mEast;
            return f <= f2 ? ((double) f) <= d && d <= ((double) f2) : ((double) f) <= d || d <= ((double) f2);
        }

        public final com.autonavi.base.amap.mapcore.FPointBounds build() {
            return new com.autonavi.base.amap.mapcore.FPointBounds(com.autonavi.base.amap.mapcore.FPoint.obtain(this.mWest, this.mSouth), com.autonavi.base.amap.mapcore.FPoint.obtain(this.mEast, this.mNorth));
        }

        public final com.autonavi.base.amap.mapcore.FPointBounds.Builder include(com.autonavi.base.amap.mapcore.FPoint fPoint) {
            this.mSouth = java.lang.Math.min(this.mSouth, ((android.graphics.PointF) fPoint).y);
            this.mNorth = java.lang.Math.max(this.mNorth, ((android.graphics.PointF) fPoint).y);
            this.mWest = java.lang.Math.min(this.mWest, ((android.graphics.PointF) fPoint).x);
            this.mEast = java.lang.Math.max(this.mEast, ((android.graphics.PointF) fPoint).x);
            return this;
        }
    }

    public FPointBounds(int i, com.autonavi.base.amap.mapcore.FPoint fPoint, com.autonavi.base.amap.mapcore.FPoint fPoint2) {
        this.mVersionCode = i;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public FPointBounds(com.autonavi.base.amap.mapcore.FPoint fPoint, com.autonavi.base.amap.mapcore.FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }

    public static com.autonavi.base.amap.mapcore.FPointBounds.Builder builder() {
        return new com.autonavi.base.amap.mapcore.FPointBounds.Builder();
    }

    private boolean containsx(double d) {
        float f = ((android.graphics.PointF) this.southwest).x;
        float f2 = ((android.graphics.PointF) this.northeast).x;
        return f <= f2 ? ((double) f) <= d && d <= ((double) f2) : ((double) f) <= d || d <= ((double) f2);
    }

    private boolean containsy(double d) {
        return ((double) ((android.graphics.PointF) this.southwest).y) <= d && d <= ((double) ((android.graphics.PointF) this.northeast).y);
    }

    private boolean intersect(com.autonavi.base.amap.mapcore.FPointBounds fPointBounds) {
        com.autonavi.base.amap.mapcore.FPoint fPoint;
        com.autonavi.base.amap.mapcore.FPoint fPoint2;
        com.autonavi.base.amap.mapcore.FPoint fPoint3;
        com.autonavi.base.amap.mapcore.FPoint fPoint4;
        if (fPointBounds != null && (fPoint = fPointBounds.northeast) != null && (fPoint2 = fPointBounds.southwest) != null && (fPoint3 = this.northeast) != null && (fPoint4 = this.southwest) != null) {
            float f = ((android.graphics.PointF) fPoint).x;
            float f2 = ((android.graphics.PointF) fPoint2).x + f;
            float f3 = ((android.graphics.PointF) fPoint3).x;
            float f4 = ((android.graphics.PointF) fPoint4).x;
            double d = (f2 - f3) - f4;
            double d2 = ((f3 - f4) + f) - f4;
            float f5 = ((android.graphics.PointF) fPoint).y;
            float f6 = ((android.graphics.PointF) fPoint2).y;
            float f7 = ((android.graphics.PointF) fPoint3).y;
            float f8 = ((android.graphics.PointF) fPoint4).y;
            double d3 = ((f5 + f6) - f7) - f8;
            double d4 = ((f7 - f8) + f5) - f6;
            if (java.lang.Math.abs(d) < d2 && java.lang.Math.abs(d3) < d4) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(com.autonavi.base.amap.mapcore.FPoint fPoint) {
        return containsy((double) ((android.graphics.PointF) fPoint).y) && containsx((double) ((android.graphics.PointF) fPoint).x);
    }

    public boolean contains(com.autonavi.base.amap.mapcore.FPointBounds fPointBounds) {
        return fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.autonavi.base.amap.mapcore.FPointBounds)) {
            return false;
        }
        com.autonavi.base.amap.mapcore.FPointBounds fPointBounds = (com.autonavi.base.amap.mapcore.FPointBounds) obj;
        return this.southwest.equals(fPointBounds.southwest) && this.northeast.equals(fPointBounds.northeast);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean intersects(com.autonavi.base.amap.mapcore.FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        return intersect(fPointBounds) || fPointBounds.intersect(this);
    }

    public java.lang.String toString() {
        return "southwest = (" + ((android.graphics.PointF) this.southwest).x + "," + ((android.graphics.PointF) this.southwest).y + ") northeast = (" + ((android.graphics.PointF) this.northeast).x + "," + ((android.graphics.PointF) this.northeast).y + ")";
    }
}
