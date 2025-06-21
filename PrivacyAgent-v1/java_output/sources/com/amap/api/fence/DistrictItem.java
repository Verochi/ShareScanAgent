package com.amap.api.fence;

/* loaded from: classes12.dex */
public class DistrictItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.fence.DistrictItem> CREATOR = new com.amap.api.fence.DistrictItem.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.util.List<com.amap.api.location.DPoint> d;

    /* renamed from: com.amap.api.fence.DistrictItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.fence.DistrictItem> {
        private static com.amap.api.fence.DistrictItem a(android.os.Parcel parcel) {
            return new com.amap.api.fence.DistrictItem(parcel);
        }

        private static com.amap.api.fence.DistrictItem[] a(int i) {
            return new com.amap.api.fence.DistrictItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.fence.DistrictItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.fence.DistrictItem[] newArray(int i) {
            return a(i);
        }
    }

    public DistrictItem() {
        this.a = "";
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public DistrictItem(android.os.Parcel parcel) {
        this.a = "";
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.createTypedArrayList(com.amap.api.location.DPoint.CREATOR);
    }

    public static android.os.Parcelable.Creator<com.amap.api.fence.DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAdcode() {
        return this.c;
    }

    public java.lang.String getCitycode() {
        return this.b;
    }

    public java.lang.String getDistrictName() {
        return this.a;
    }

    public java.util.List<com.amap.api.location.DPoint> getPolyline() {
        return this.d;
    }

    public void setAdcode(java.lang.String str) {
        this.c = str;
    }

    public void setCitycode(java.lang.String str) {
        this.b = str;
    }

    public void setDistrictName(java.lang.String str) {
        this.a = str;
    }

    public void setPolyline(java.util.List<com.amap.api.location.DPoint> list) {
        this.d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeTypedList(this.d);
    }
}
