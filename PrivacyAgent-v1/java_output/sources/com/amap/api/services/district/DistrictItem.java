package com.amap.api.services.district;

/* loaded from: classes12.dex */
public final class DistrictItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.district.DistrictItem> CREATOR = new com.amap.api.services.district.DistrictItem.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private com.amap.api.services.core.LatLonPoint d;
    private java.lang.String e;
    private java.util.List<com.amap.api.services.district.DistrictItem> f;
    private java.lang.String[] g;

    /* renamed from: com.amap.api.services.district.DistrictItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.district.DistrictItem> {
        private static com.amap.api.services.district.DistrictItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.district.DistrictItem(parcel);
        }

        private static com.amap.api.services.district.DistrictItem[] a(int i) {
            return new com.amap.api.services.district.DistrictItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.district.DistrictItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.district.DistrictItem[] newArray(int i) {
            return a(i);
        }
    }

    public DistrictItem() {
        this.f = new java.util.ArrayList();
        this.g = new java.lang.String[0];
    }

    public DistrictItem(android.os.Parcel parcel) {
        this.f = new java.util.ArrayList();
        this.g = new java.lang.String[0];
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f = parcel.createTypedArrayList(CREATOR);
        java.lang.String[] strArr = new java.lang.String[parcel.readInt()];
        this.g = strArr;
        parcel.readStringArray(strArr);
    }

    public DistrictItem(java.lang.String str, java.lang.String str2, java.lang.String str3, com.amap.api.services.core.LatLonPoint latLonPoint, java.lang.String str4) {
        this.f = new java.util.ArrayList();
        this.g = new java.lang.String[0];
        this.c = str;
        this.a = str2;
        this.b = str3;
        this.d = latLonPoint;
        this.e = str4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String[] districtBoundary() {
        return this.g;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.amap.api.services.district.DistrictItem.class != obj.getClass()) {
            return false;
        }
        com.amap.api.services.district.DistrictItem districtItem = (com.amap.api.services.district.DistrictItem) obj;
        java.lang.String str = this.b;
        if (str == null) {
            if (districtItem.b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.b)) {
            return false;
        }
        com.amap.api.services.core.LatLonPoint latLonPoint = this.d;
        if (latLonPoint == null) {
            if (districtItem.d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.d)) {
            return false;
        }
        java.lang.String str2 = this.a;
        if (str2 == null) {
            if (districtItem.a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.a)) {
            return false;
        }
        if (!java.util.Arrays.equals(this.g, districtItem.g)) {
            return false;
        }
        java.util.List<com.amap.api.services.district.DistrictItem> list = this.f;
        if (list == null) {
            if (districtItem.f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f)) {
            return false;
        }
        java.lang.String str3 = this.e;
        if (str3 == null) {
            if (districtItem.e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.e)) {
            return false;
        }
        java.lang.String str4 = this.c;
        if (str4 == null) {
            if (districtItem.c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.c)) {
            return false;
        }
        return true;
    }

    public final java.lang.String getAdcode() {
        return this.b;
    }

    public final com.amap.api.services.core.LatLonPoint getCenter() {
        return this.d;
    }

    public final java.lang.String getCitycode() {
        return this.a;
    }

    public final java.lang.String getLevel() {
        return this.e;
    }

    public final java.lang.String getName() {
        return this.c;
    }

    public final java.util.List<com.amap.api.services.district.DistrictItem> getSubDistrict() {
        return this.f;
    }

    public final int hashCode() {
        java.lang.String str = this.b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        com.amap.api.services.core.LatLonPoint latLonPoint = this.d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        java.lang.String str2 = this.a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + java.util.Arrays.hashCode(this.g)) * 31;
        java.util.List<com.amap.api.services.district.DistrictItem> list = this.f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        java.lang.String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        java.lang.String str4 = this.c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAdcode(java.lang.String str) {
        this.b = str;
    }

    public final void setCenter(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public final void setCitycode(java.lang.String str) {
        this.a = str;
    }

    public final void setDistrictBoundary(java.lang.String[] strArr) {
        this.g = strArr;
    }

    public final void setLevel(java.lang.String str) {
        this.e = str;
    }

    public final void setName(java.lang.String str) {
        this.c = str;
    }

    public final void setSubDistrict(java.util.ArrayList<com.amap.api.services.district.DistrictItem> arrayList) {
        this.f = arrayList;
    }

    public final java.lang.String toString() {
        return "DistrictItem [mCitycode=" + this.a + ", mAdcode=" + this.b + ", mName=" + this.c + ", mCenter=" + this.d + ", mLevel=" + this.e + ", mDistricts=" + this.f + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeInt(this.g.length);
        parcel.writeStringArray(this.g);
    }
}
