package com.amap.api.services.cloud;

/* loaded from: classes12.dex */
public class CloudItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.cloud.CloudItem> CREATOR = new com.amap.api.services.cloud.CloudItem.AnonymousClass1();
    private java.lang.String a;
    private int b;
    private java.lang.String c;
    private java.lang.String d;
    private java.util.HashMap<java.lang.String, java.lang.String> e;
    private java.util.List<com.amap.api.services.cloud.CloudImage> f;
    protected final com.amap.api.services.core.LatLonPoint mPoint;
    protected final java.lang.String mSnippet;
    protected final java.lang.String mTitle;

    /* renamed from: com.amap.api.services.cloud.CloudItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.cloud.CloudItem> {
        private static com.amap.api.services.cloud.CloudItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.cloud.CloudItem(parcel);
        }

        private static com.amap.api.services.cloud.CloudItem[] a(int i) {
            return new com.amap.api.services.cloud.CloudItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.cloud.CloudItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.cloud.CloudItem[] newArray(int i) {
            return a(i);
        }
    }

    public CloudItem(android.os.Parcel parcel) {
        this.b = -1;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.mPoint = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        this.e = hashMap;
        parcel.readMap(hashMap, java.util.HashMap.class.getClassLoader());
        java.util.List arrayList = new java.util.ArrayList();
        this.f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }

    public CloudItem(java.lang.String str, com.amap.api.services.core.LatLonPoint latLonPoint, java.lang.String str2, java.lang.String str3) {
        this.b = -1;
        this.a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof com.amap.api.services.cloud.CloudItem)) {
            return false;
        }
        com.amap.api.services.cloud.CloudItem cloudItem = (com.amap.api.services.cloud.CloudItem) obj;
        java.lang.String str = this.a;
        if (str == null) {
            if (cloudItem.a != null) {
                return false;
            }
        } else if (!str.equals(cloudItem.a)) {
            return false;
        }
        return true;
    }

    public java.util.List<com.amap.api.services.cloud.CloudImage> getCloudImage() {
        return this.f;
    }

    public java.lang.String getCreatetime() {
        return this.c;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getCustomfield() {
        return this.e;
    }

    public int getDistance() {
        return this.b;
    }

    public java.lang.String getID() {
        return this.a;
    }

    public com.amap.api.services.core.LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public java.lang.String getSnippet() {
        return this.mSnippet;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public java.lang.String getUpdatetime() {
        return this.d;
    }

    public int hashCode() {
        java.lang.String str = this.a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(java.lang.String str) {
        this.c = str;
    }

    public void setCustomfield(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this.e = hashMap;
    }

    public void setDistance(int i) {
        this.b = i;
    }

    public void setUpdatetime(java.lang.String str) {
        this.d = str;
    }

    public void setmCloudImage(java.util.List<com.amap.api.services.cloud.CloudImage> list) {
        this.f = list;
    }

    public java.lang.String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeMap(this.e);
        parcel.writeList(this.f);
    }
}
