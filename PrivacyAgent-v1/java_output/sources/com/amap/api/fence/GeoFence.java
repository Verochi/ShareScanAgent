package com.amap.api.fence;

/* loaded from: classes12.dex */
public class GeoFence implements android.os.Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final java.lang.String BUNDLE_KEY_CUSTOMID = "customId";
    public static final java.lang.String BUNDLE_KEY_FENCE = "fence";
    public static final java.lang.String BUNDLE_KEY_FENCEID = "fenceid";
    public static final java.lang.String BUNDLE_KEY_FENCESTATUS = "event";
    public static final java.lang.String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final android.os.Parcelable.Creator<com.amap.api.fence.GeoFence> CREATOR = new com.amap.api.fence.GeoFence.AnonymousClass1();
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private android.app.PendingIntent d;
    private int e;
    private com.amap.api.fence.PoiItem f;
    private java.util.List<com.amap.api.fence.DistrictItem> g;
    private java.util.List<java.util.List<com.amap.api.location.DPoint>> h;
    private float i;
    private long j;
    private int k;
    private float l;
    private float m;
    private com.amap.api.location.DPoint n;
    private int o;
    private long p;
    private boolean q;
    private com.amap.api.location.AMapLocation r;

    /* renamed from: com.amap.api.fence.GeoFence$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.fence.GeoFence> {
        private static com.amap.api.fence.GeoFence a(android.os.Parcel parcel) {
            return new com.amap.api.fence.GeoFence(parcel);
        }

        private static com.amap.api.fence.GeoFence[] a(int i) {
            return new com.amap.api.fence.GeoFence[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.fence.GeoFence createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.fence.GeoFence[] newArray(int i) {
            return a(i);
        }
    }

    public GeoFence() {
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1L;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1L;
        this.q = true;
        this.r = null;
    }

    public GeoFence(android.os.Parcel parcel) {
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1L;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1L;
        this.q = true;
        this.r = null;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (android.app.PendingIntent) parcel.readParcelable(android.app.PendingIntent.class.getClassLoader());
        this.e = parcel.readInt();
        this.f = (com.amap.api.fence.PoiItem) parcel.readParcelable(com.amap.api.fence.PoiItem.class.getClassLoader());
        this.g = parcel.createTypedArrayList(com.amap.api.fence.DistrictItem.CREATOR);
        this.i = parcel.readFloat();
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readFloat();
        this.n = (com.amap.api.location.DPoint) parcel.readParcelable(com.amap.api.location.DPoint.class.getClassLoader());
        this.o = parcel.readInt();
        this.p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.h = new java.util.ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.h.add(parcel.createTypedArrayList(com.amap.api.location.DPoint.CREATOR));
            }
        }
        this.q = parcel.readByte() != 0;
        this.r = (com.amap.api.location.AMapLocation) parcel.readParcelable(com.amap.api.location.AMapLocation.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.amap.api.fence.GeoFence)) {
            return false;
        }
        com.amap.api.fence.GeoFence geoFence = (com.amap.api.fence.GeoFence) obj;
        if (android.text.TextUtils.isEmpty(this.b)) {
            if (!android.text.TextUtils.isEmpty(geoFence.b)) {
                return false;
            }
        } else if (!this.b.equals(geoFence.b)) {
            return false;
        }
        com.amap.api.location.DPoint dPoint = this.n;
        if (dPoint == null) {
            if (geoFence.n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.n)) {
            return false;
        }
        if (this.i != geoFence.i) {
            return false;
        }
        java.util.List<java.util.List<com.amap.api.location.DPoint>> list = this.h;
        java.util.List<java.util.List<com.amap.api.location.DPoint>> list2 = geoFence.h;
        return list == null ? list2 == null : list.equals(list2);
    }

    public int getActivatesAction() {
        return this.k;
    }

    public com.amap.api.location.DPoint getCenter() {
        return this.n;
    }

    public com.amap.api.location.AMapLocation getCurrentLocation() {
        return this.r;
    }

    public java.lang.String getCustomId() {
        return this.b;
    }

    public java.util.List<com.amap.api.fence.DistrictItem> getDistrictItemList() {
        return this.g;
    }

    public long getEnterTime() {
        return this.p;
    }

    public long getExpiration() {
        return this.j;
    }

    public java.lang.String getFenceId() {
        return this.a;
    }

    public float getMaxDis2Center() {
        return this.m;
    }

    public float getMinDis2Center() {
        return this.l;
    }

    public android.app.PendingIntent getPendingIntent() {
        return this.d;
    }

    public java.lang.String getPendingIntentAction() {
        return this.c;
    }

    public com.amap.api.fence.PoiItem getPoiItem() {
        return this.f;
    }

    public java.util.List<java.util.List<com.amap.api.location.DPoint>> getPointList() {
        return this.h;
    }

    public float getRadius() {
        return this.i;
    }

    public int getStatus() {
        return this.o;
    }

    public int getType() {
        return this.e;
    }

    public int hashCode() {
        return this.b.hashCode() + this.h.hashCode() + this.n.hashCode() + ((int) (this.i * 100.0f));
    }

    public boolean isAble() {
        return this.q;
    }

    public void setAble(boolean z) {
        this.q = z;
    }

    public void setActivatesAction(int i) {
        this.k = i;
    }

    public void setCenter(com.amap.api.location.DPoint dPoint) {
        this.n = dPoint;
    }

    public void setCurrentLocation(com.amap.api.location.AMapLocation aMapLocation) {
        this.r = aMapLocation.m13clone();
    }

    public void setCustomId(java.lang.String str) {
        this.b = str;
    }

    public void setDistrictItemList(java.util.List<com.amap.api.fence.DistrictItem> list) {
        this.g = list;
    }

    public void setEnterTime(long j) {
        this.p = j;
    }

    public void setExpiration(long j) {
        this.j = j < 0 ? -1L : j + com.loc.gd.b();
    }

    public void setFenceId(java.lang.String str) {
        this.a = str;
    }

    public void setMaxDis2Center(float f) {
        this.m = f;
    }

    public void setMinDis2Center(float f) {
        this.l = f;
    }

    public void setPendingIntent(android.app.PendingIntent pendingIntent) {
        this.d = pendingIntent;
    }

    public void setPendingIntentAction(java.lang.String str) {
        this.c = str;
    }

    public void setPoiItem(com.amap.api.fence.PoiItem poiItem) {
        this.f = poiItem;
    }

    public void setPointList(java.util.List<java.util.List<com.amap.api.location.DPoint>> list) {
        this.h = list;
    }

    public void setRadius(float f) {
        this.i = f;
    }

    public void setStatus(int i) {
        this.o = i;
    }

    public void setType(int i) {
        this.e = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeTypedList(this.g);
        parcel.writeFloat(this.i);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeFloat(this.m);
        parcel.writeParcelable(this.n, i);
        parcel.writeInt(this.o);
        parcel.writeLong(this.p);
        java.util.List<java.util.List<com.amap.api.location.DPoint>> list = this.h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.h.size());
            java.util.Iterator<java.util.List<com.amap.api.location.DPoint>> it = this.h.iterator();
            while (it.hasNext()) {
                parcel.writeTypedList(it.next());
            }
        }
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.r, i);
    }
}
