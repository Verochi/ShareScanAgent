package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class CameraPosition implements android.os.Parcelable {
    private static final java.lang.String CLASSNAME = "CameraPosition";
    public static final com.amap.api.maps.model.CameraPositionCreator CREATOR = new com.amap.api.maps.model.CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final com.amap.api.maps.model.LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private float bearing;
        private com.amap.api.maps.model.LatLng target;
        private float tilt;
        private float zoom;

        public Builder() {
        }

        public Builder(com.amap.api.maps.model.CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public final com.amap.api.maps.model.CameraPosition.Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public final com.amap.api.maps.model.CameraPosition build() {
            try {
                if (this.target == null) {
                    return null;
                }
                return new com.amap.api.maps.model.CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, com.amap.api.maps.model.CameraPosition.CLASSNAME, "build");
                return null;
            }
        }

        public final com.amap.api.maps.model.CameraPosition.Builder target(com.amap.api.maps.model.LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final com.amap.api.maps.model.CameraPosition.Builder tilt(float f) {
            this.tilt = f;
            return this;
        }

        public final com.amap.api.maps.model.CameraPosition.Builder zoom(float f) {
            this.zoom = f;
            return this;
        }
    }

    public CameraPosition(com.amap.api.maps.model.LatLng latLng, float f, float f2, float f3) {
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2;
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !com.amap.api.mapcore.util.de.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public static com.amap.api.maps.model.CameraPosition.Builder builder() {
        return new com.amap.api.maps.model.CameraPosition.Builder();
    }

    public static com.amap.api.maps.model.CameraPosition.Builder builder(com.amap.api.maps.model.CameraPosition cameraPosition) {
        return new com.amap.api.maps.model.CameraPosition.Builder(cameraPosition);
    }

    public static final com.amap.api.maps.model.CameraPosition fromLatLngZoom(com.amap.api.maps.model.LatLng latLng, float f) {
        return new com.amap.api.maps.model.CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.amap.api.maps.model.CameraPosition)) {
            return false;
        }
        com.amap.api.maps.model.CameraPosition cameraPosition = (com.amap.api.maps.model.CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && java.lang.Float.floatToIntBits(this.zoom) == java.lang.Float.floatToIntBits(cameraPosition.zoom) && java.lang.Float.floatToIntBits(this.tilt) == java.lang.Float.floatToIntBits(cameraPosition.tilt) && java.lang.Float.floatToIntBits(this.bearing) == java.lang.Float.floatToIntBits(cameraPosition.bearing);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final java.lang.String toString() {
        return com.amap.api.mapcore.util.dl.a(com.amap.api.mapcore.util.dl.a(com.umeng.ccg.a.A, this.target), com.amap.api.mapcore.util.dl.a("zoom", java.lang.Float.valueOf(this.zoom)), com.amap.api.mapcore.util.dl.a("tilt", java.lang.Float.valueOf(this.tilt)), com.amap.api.mapcore.util.dl.a("bearing", java.lang.Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }
}
