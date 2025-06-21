package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class MyLocationStyle implements android.os.Parcelable {
    public static final com.amap.api.maps.model.MyLocationStyleCreator CREATOR = new com.amap.api.maps.model.MyLocationStyleCreator();
    public static final java.lang.String ERROR_CODE = "errorCode";
    public static final java.lang.String ERROR_INFO = "errorInfo";
    public static final java.lang.String LOCATION_TYPE = "locationType";
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_LOCATION_ROTATE = 4;
    public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 5;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 7;
    public static final int LOCATION_TYPE_SHOW = 0;
    private com.amap.api.maps.model.BitmapDescriptor mMyLocationIcon;
    private float mAnchorU = 0.5f;
    private float mAnchorV = 0.5f;
    private int mRadiusFillColor = android.graphics.Color.argb(100, 0, 0, 180);
    private int mStrokeColor = android.graphics.Color.argb(255, 0, 0, 220);
    private float mStrokeWidth = 1.0f;
    private int mLocationType = 4;
    private long interval = 2000;
    private boolean myLocationVisible = true;

    public com.amap.api.maps.model.MyLocationStyle anchor(float f, float f2) {
        this.mAnchorU = f;
        this.mAnchorV = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.mAnchorU;
    }

    public float getAnchorV() {
        return this.mAnchorV;
    }

    public long getInterval() {
        return this.interval;
    }

    public com.amap.api.maps.model.BitmapDescriptor getMyLocationIcon() {
        return this.mMyLocationIcon;
    }

    public int getMyLocationType() {
        return this.mLocationType;
    }

    public int getRadiusFillColor() {
        return this.mRadiusFillColor;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public com.amap.api.maps.model.MyLocationStyle interval(long j) {
        this.interval = j;
        return this;
    }

    public boolean isMyLocationShowing() {
        return this.myLocationVisible;
    }

    public com.amap.api.maps.model.MyLocationStyle myLocationIcon(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        this.mMyLocationIcon = bitmapDescriptor;
        return this;
    }

    public com.amap.api.maps.model.MyLocationStyle myLocationType(int i) {
        this.mLocationType = i;
        return this;
    }

    public com.amap.api.maps.model.MyLocationStyle radiusFillColor(int i) {
        this.mRadiusFillColor = i;
        return this;
    }

    public com.amap.api.maps.model.MyLocationStyle showMyLocation(boolean z) {
        this.myLocationVisible = z;
        return this;
    }

    public com.amap.api.maps.model.MyLocationStyle strokeColor(int i) {
        this.mStrokeColor = i;
        return this;
    }

    public com.amap.api.maps.model.MyLocationStyle strokeWidth(float f) {
        this.mStrokeWidth = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.mMyLocationIcon, i);
        parcel.writeFloat(this.mAnchorU);
        parcel.writeFloat(this.mAnchorV);
        parcel.writeInt(this.mRadiusFillColor);
        parcel.writeInt(this.mStrokeColor);
        parcel.writeFloat(this.mStrokeWidth);
        parcel.writeInt(this.mLocationType);
        parcel.writeLong(this.interval);
        parcel.writeBooleanArray(new boolean[]{this.myLocationVisible});
    }
}
