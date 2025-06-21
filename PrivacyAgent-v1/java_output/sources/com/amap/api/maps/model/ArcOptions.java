package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class ArcOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable, java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.ArcOptionsCreator CREATOR = new com.amap.api.maps.model.ArcOptionsCreator();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    java.lang.String a;
    private com.amap.api.maps.model.LatLng endpoint;
    private com.amap.api.maps.model.LatLng passedpoint;
    private com.amap.api.maps.model.LatLng startpoint;
    private float strokeWidth = 10.0f;
    private int strokeColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public ArcOptions() {
        this.type = "ArcOptions";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.ArcOptions m16clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
        }
        com.amap.api.maps.model.ArcOptions arcOptions = new com.amap.api.maps.model.ArcOptions();
        arcOptions.a = this.a;
        arcOptions.startpoint = this.startpoint;
        arcOptions.passedpoint = this.passedpoint;
        arcOptions.endpoint = this.endpoint;
        arcOptions.strokeWidth = this.strokeWidth;
        arcOptions.strokeColor = this.strokeColor;
        arcOptions.zIndex = this.zIndex;
        arcOptions.isVisible = this.isVisible;
        return arcOptions;
    }

    @Override // android.os.Parcelable
    @com.autonavi.base.amap.mapcore.jbinding.JBinding2cFieldOrMethod
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.LatLng getEnd() {
        return this.endpoint;
    }

    public final com.amap.api.maps.model.LatLng getPassed() {
        return this.passedpoint;
    }

    public final com.amap.api.maps.model.LatLng getStart() {
        return this.startpoint;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final com.amap.api.maps.model.ArcOptions point(com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2, com.amap.api.maps.model.LatLng latLng3) {
        this.startpoint = latLng;
        this.passedpoint = latLng2;
        this.endpoint = latLng3;
        return this;
    }

    public final com.amap.api.maps.model.ArcOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final com.amap.api.maps.model.ArcOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public final com.amap.api.maps.model.ArcOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        android.os.Bundle bundle = new android.os.Bundle();
        com.amap.api.maps.model.LatLng latLng = this.startpoint;
        if (latLng != null) {
            bundle.putDouble("startlat", latLng.latitude);
            bundle.putDouble("startlng", this.startpoint.longitude);
        }
        com.amap.api.maps.model.LatLng latLng2 = this.passedpoint;
        if (latLng2 != null) {
            bundle.putDouble("passedlat", latLng2.latitude);
            bundle.putDouble("passedlng", this.passedpoint.longitude);
        }
        com.amap.api.maps.model.LatLng latLng3 = this.endpoint;
        if (latLng3 != null) {
            bundle.putDouble("endlat", latLng3.latitude);
            bundle.putDouble("endlng", this.endpoint.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.a);
    }

    public final com.amap.api.maps.model.ArcOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
