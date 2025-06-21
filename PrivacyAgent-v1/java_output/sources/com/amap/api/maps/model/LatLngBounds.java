package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class LatLngBounds implements android.os.Parcelable {
    private static final java.lang.String CLASSNAME = "LatLngBounds";
    public static final com.amap.api.maps.model.LatLngBoundsCreator CREATOR = new com.amap.api.maps.model.LatLngBoundsCreator();
    private final int mVersionCode;
    public final com.amap.api.maps.model.LatLng northeast;
    public final com.amap.api.maps.model.LatLng southwest;

    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        private boolean a(double d) {
            double d2 = this.mWest;
            double d3 = this.mEast;
            return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
        }

        public final com.amap.api.maps.model.LatLngBounds build() {
            if (java.lang.Double.isNaN(this.mWest)) {
                return null;
            }
            double d = this.mWest;
            double d2 = this.mEast;
            if (d > d2) {
                this.mWest = d2;
                this.mEast = d;
            }
            double d3 = this.mSouth;
            double d4 = this.mNorth;
            if (d3 > d4) {
                this.mSouth = d4;
                this.mNorth = d3;
            }
            return new com.amap.api.maps.model.LatLngBounds(new com.amap.api.maps.model.LatLng(this.mSouth, this.mWest, false), new com.amap.api.maps.model.LatLng(this.mNorth, this.mEast, false));
        }

        public final com.amap.api.maps.model.LatLngBounds.Builder include(com.amap.api.maps.model.LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = java.lang.Math.min(this.mSouth, latLng.latitude);
            this.mNorth = java.lang.Math.max(this.mNorth, latLng.latitude);
            double d = latLng.longitude;
            if (!java.lang.Double.isNaN(this.mWest)) {
                if (!a(d)) {
                    if (com.amap.api.maps.model.LatLngBounds.c(this.mWest, d) < com.amap.api.maps.model.LatLngBounds.d(this.mEast, d)) {
                        this.mWest = d;
                    }
                }
                return this;
            }
            this.mWest = d;
            this.mEast = d;
            return this;
        }
    }

    public LatLngBounds(int i, com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2) {
        boolean z;
        try {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            z = false;
        }
        if (latLng == null) {
            throw new com.amap.api.maps.model.RuntimeRemoteException("null southwest");
        }
        if (latLng2 == null) {
            throw new com.amap.api.maps.model.RuntimeRemoteException("null northeast");
        }
        if (latLng2.latitude >= latLng.latitude) {
            z = true;
            this.mVersionCode = z ? i : 0;
            this.southwest = z ? latLng : null;
            this.northeast = z ? latLng2 : null;
            return;
        }
        throw new com.amap.api.maps.model.RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
    }

    public LatLngBounds(com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private boolean a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean a(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        com.amap.api.maps.model.LatLng latLng;
        com.amap.api.maps.model.LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d = latLng.longitude;
        double d2 = latLng2.longitude;
        com.amap.api.maps.model.LatLng latLng3 = this.northeast;
        double d3 = latLng3.longitude;
        com.amap.api.maps.model.LatLng latLng4 = this.southwest;
        double d4 = latLng4.longitude;
        double d5 = ((d + d2) - d3) - d4;
        double d6 = ((d3 - d4) + d) - d2;
        double d7 = latLng.latitude;
        double d8 = latLng2.latitude;
        double d9 = latLng3.latitude;
        double d10 = latLng4.latitude;
        return java.lang.Math.abs(d5) < d6 && java.lang.Math.abs(((d7 + d8) - d9) - d10) < ((d9 - d10) + d7) - d8;
    }

    private boolean b(double d) {
        double d2 = this.southwest.longitude;
        double d3 = this.northeast.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    public static com.amap.api.maps.model.LatLngBounds.Builder builder() {
        return new com.amap.api.maps.model.LatLngBounds.Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final int a() {
        return this.mVersionCode;
    }

    public final boolean contains(com.amap.api.maps.model.LatLng latLng) {
        return (latLng == null || this.northeast == null || this.southwest == null || !a(latLng.latitude) || !b(latLng.longitude)) ? false : true;
    }

    public final boolean contains(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.amap.api.maps.model.LatLngBounds)) {
            return false;
        }
        com.amap.api.maps.model.LatLngBounds latLngBounds = (com.amap.api.maps.model.LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final int hashCode() {
        return com.amap.api.mapcore.util.dl.a(new java.lang.Object[]{this.southwest, this.northeast});
    }

    public final com.amap.api.maps.model.LatLngBounds including(com.amap.api.maps.model.LatLng latLng) {
        com.amap.api.maps.model.LatLng latLng2;
        double d;
        if (latLng != null && this.northeast != null && (latLng2 = this.southwest) != null) {
            double min = java.lang.Math.min(latLng2.latitude, latLng.latitude);
            double max = java.lang.Math.max(this.northeast.latitude, latLng.latitude);
            double d2 = this.northeast.longitude;
            double d3 = this.southwest.longitude;
            double d4 = latLng.longitude;
            try {
                if (!b(d4)) {
                    if (c(d3, d4) >= d(d2, d4)) {
                        d = d4;
                        return new com.amap.api.maps.model.LatLngBounds(new com.amap.api.maps.model.LatLng(min, d3, false), new com.amap.api.maps.model.LatLng(max, d, false));
                    }
                    d3 = d4;
                }
                return new com.amap.api.maps.model.LatLngBounds(new com.amap.api.maps.model.LatLng(min, d3, false), new com.amap.api.maps.model.LatLng(max, d, false));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            d = d2;
        }
        return this;
    }

    public final boolean intersects(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        return a(latLngBounds) || latLngBounds.a(this);
    }

    public final java.lang.String toString() {
        return com.amap.api.mapcore.util.dl.a(com.amap.api.mapcore.util.dl.a("southwest", this.southwest), com.amap.api.mapcore.util.dl.a("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        com.amap.api.maps.model.LatLngBoundsCreator.a(this, parcel, i);
    }
}
