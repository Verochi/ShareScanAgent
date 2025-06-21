package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class MarkerOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable, java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.MarkerOptionsCreator CREATOR = new com.amap.api.maps.model.MarkerOptionsCreator();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    java.lang.String a;
    private com.amap.api.maps.model.LatLng gpsLatLng;
    private boolean isBelowMaskLayer;
    private com.amap.api.maps.model.LatLng latLng;
    private float rotate;
    private int screenX;
    private int screenY;
    private java.lang.String snippet;
    private java.lang.String title;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private float zIndex = 0.0f;
    private boolean isDraggable = false;
    private boolean isVisible = true;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private boolean perspective = false;
    private int offsetX = 0;
    private int offsetY = 0;
    private java.util.List<com.amap.api.maps.model.BitmapDescriptor> bitmapDescriptors = new java.util.ArrayList();
    private int period = 20;
    private boolean isGps = false;
    private boolean isFlat = false;
    private boolean isRotatingMode = false;
    private float angleOffset = 0.0f;
    private boolean isViewMode = false;
    private float alpha = 1.0f;
    private boolean autoOverturn = false;
    private boolean infoWindowEnabled = true;
    private int dispLevel = 5;
    private com.amap.api.maps.model.MarkerOptions.MarkerUpdateFlags updateFlags = new com.amap.api.maps.model.MarkerOptions.MarkerUpdateFlags();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class MarkerUpdateFlags extends com.amap.api.maps.model.BaseOptions.BaseUpdateFlags {
        protected boolean latlngUpdate = false;
        protected boolean gpsLatLngUpdate = false;
        protected boolean bitmapDescriptorsUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.latlngUpdate = false;
            this.gpsLatLngUpdate = false;
            this.bitmapDescriptorsUpdate = false;
        }
    }

    public MarkerOptions() {
        this.type = "MarkerOptions";
    }

    private void a() {
        if (this.bitmapDescriptors == null) {
            try {
                this.bitmapDescriptors = new java.util.ArrayList();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b() {
        com.amap.api.maps.model.LatLng latLng;
        try {
            if (!this.isGps || (latLng = this.latLng) == null) {
                return;
            }
            double[] a = com.autonavi.util.a.a(latLng.longitude, latLng.latitude);
            this.gpsLatLng = new com.amap.api.maps.model.LatLng(a[1], a[0]);
            this.updateFlags.gpsLatLngUpdate = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final com.amap.api.maps.model.MarkerOptions alpha(float f) {
        this.alpha = f;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions angleOffset(float f) {
        this.angleOffset = f;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions autoOverturnInfoWindow(boolean z) {
        this.autoOverturn = z;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions belowMaskLayer(boolean z) {
        this.isBelowMaskLayer = z;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.MarkerOptions m21clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
        }
        com.amap.api.maps.model.MarkerOptions markerOptions = new com.amap.api.maps.model.MarkerOptions();
        markerOptions.latLng = this.latLng;
        markerOptions.gpsLatLng = this.gpsLatLng;
        markerOptions.title = this.title;
        markerOptions.snippet = this.snippet;
        markerOptions.anchorU = this.anchorU;
        markerOptions.anchorV = this.anchorV;
        markerOptions.zIndex = this.zIndex;
        markerOptions.isDraggable = this.isDraggable;
        markerOptions.isVisible = this.isVisible;
        markerOptions.a = this.a;
        markerOptions.perspective = this.perspective;
        markerOptions.offsetX = this.offsetX;
        markerOptions.offsetY = this.offsetY;
        markerOptions.bitmapDescriptors = this.bitmapDescriptors;
        markerOptions.period = this.period;
        markerOptions.isGps = this.isGps;
        markerOptions.isFlat = this.isFlat;
        markerOptions.isRotatingMode = this.isRotatingMode;
        markerOptions.angleOffset = this.angleOffset;
        markerOptions.screenX = this.screenX;
        markerOptions.screenY = this.screenY;
        markerOptions.isViewMode = this.isViewMode;
        markerOptions.alpha = this.alpha;
        markerOptions.autoOverturn = this.autoOverturn;
        markerOptions.infoWindowEnabled = this.infoWindowEnabled;
        markerOptions.dispLevel = this.dispLevel;
        markerOptions.rotate = this.rotate;
        markerOptions.isBelowMaskLayer = this.isBelowMaskLayer;
        markerOptions.updateFlags = this.updateFlags;
        return markerOptions;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.MarkerOptions displayLevel(int i) {
        this.dispLevel = i;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions draggable(boolean z) {
        this.isDraggable = z;
        return this;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getAngleOffset() {
        return this.angleOffset;
    }

    public final int getDisplayLevel() {
        return this.dispLevel;
    }

    public final com.amap.api.maps.model.BitmapDescriptor getIcon() {
        java.util.List<com.amap.api.maps.model.BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.bitmapDescriptors.get(0);
    }

    public final java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> getIcons() {
        return (java.util.ArrayList) this.bitmapDescriptors;
    }

    public final int getInfoWindowOffsetX() {
        return this.offsetX;
    }

    public final int getInfoWindowOffsetY() {
        return this.offsetY;
    }

    public final int getPeriod() {
        return this.period;
    }

    public final com.amap.api.maps.model.LatLng getPosition() {
        return this.latLng;
    }

    public final float getRotateAngle() {
        return this.rotate;
    }

    public final int getScreenX() {
        return this.screenX;
    }

    public final int getScreenY() {
        return this.screenY;
    }

    public final java.lang.String getSnippet() {
        return this.snippet;
    }

    public final java.lang.String getTitle() {
        return this.title;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final com.amap.api.maps.model.MarkerOptions.MarkerUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final com.amap.api.maps.model.MarkerOptions icon(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.bitmapDescriptors.clear();
            this.bitmapDescriptors.add(bitmapDescriptor);
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions icons(java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions infoWindowEnable(boolean z) {
        this.infoWindowEnabled = z;
        return this;
    }

    public final boolean isBelowMaskLayer() {
        return this.isBelowMaskLayer;
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public final boolean isFlat() {
        return this.isFlat;
    }

    public final boolean isGps() {
        return this.isGps;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return this.autoOverturn;
    }

    public final boolean isInfoWindowEnable() {
        return this.infoWindowEnabled;
    }

    public final boolean isPerspective() {
        return this.perspective;
    }

    public final boolean isRotatingMode() {
        return this.isRotatingMode;
    }

    public final boolean isViewMode() {
        return this.isViewMode;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final com.amap.api.maps.model.MarkerOptions period(int i) {
        if (i <= 1) {
            this.period = 1;
        } else {
            this.period = i;
        }
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions perspective(boolean z) {
        this.perspective = z;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions position(com.amap.api.maps.model.LatLng latLng) {
        this.latLng = latLng;
        this.isViewMode = false;
        b();
        this.updateFlags.latlngUpdate = true;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final com.amap.api.maps.model.MarkerOptions rotateAngle(float f) {
        this.rotate = f;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions rotatingIcons(java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> arrayList, float f) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            if (f != 0.0f) {
                this.angleOffset = f;
            } else {
                this.angleOffset = 360.0f / arrayList.size();
            }
            this.isRotatingMode = true;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions setFlat(boolean z) {
        this.isFlat = z;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions setGps(boolean z) {
        this.isGps = z;
        b();
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions setInfoWindowOffset(int i, int i2) {
        this.offsetX = i;
        this.offsetY = i2;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions setRotatingMode(boolean z) {
        this.isRotatingMode = z;
        return this;
    }

    public final void setScreenPosition(int i, int i2) {
        this.screenX = i;
        this.screenY = i2;
        this.isViewMode = true;
    }

    public final com.amap.api.maps.model.MarkerOptions snippet(java.lang.String str) {
        this.snippet = str;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions title(java.lang.String str) {
        this.title = str;
        return this;
    }

    public final com.amap.api.maps.model.MarkerOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.latLng, i);
        parcel.writeString(this.title);
        parcel.writeString(this.snippet);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.autoOverturn, this.infoWindowEnabled, this.isBelowMaskLayer, this.isRotatingMode});
        parcel.writeString(this.a);
        parcel.writeInt(this.period);
        parcel.writeList(this.bitmapDescriptors);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.alpha);
        parcel.writeInt(this.dispLevel);
        parcel.writeFloat(this.rotate);
        parcel.writeFloat(this.angleOffset);
        parcel.writeInt(this.screenX);
        parcel.writeInt(this.screenY);
        java.util.List<com.amap.api.maps.model.BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return;
        }
        parcel.writeParcelable(this.bitmapDescriptors.get(0), i);
    }

    public final com.amap.api.maps.model.MarkerOptions zIndex(float f) {
        if (this.zIndex != f) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }
}
