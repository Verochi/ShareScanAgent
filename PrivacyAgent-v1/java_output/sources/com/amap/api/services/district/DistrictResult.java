package com.amap.api.services.district;

/* loaded from: classes12.dex */
public final class DistrictResult implements android.os.Parcelable {
    public android.os.Parcelable.Creator<com.amap.api.services.district.DistrictResult> CREATOR;
    private com.amap.api.services.district.DistrictSearchQuery a;
    private java.util.ArrayList<com.amap.api.services.district.DistrictItem> b;
    private int c;
    private com.amap.api.services.core.AMapException d;

    /* renamed from: com.amap.api.services.district.DistrictResult$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.district.DistrictResult> {
        public AnonymousClass1() {
        }

        private static com.amap.api.services.district.DistrictResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.district.DistrictResult(parcel);
        }

        private static com.amap.api.services.district.DistrictResult[] a(int i) {
            return new com.amap.api.services.district.DistrictResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.district.DistrictResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.district.DistrictResult[] newArray(int i) {
            return a(i);
        }
    }

    public DistrictResult() {
        this.b = new java.util.ArrayList<>();
        this.CREATOR = new com.amap.api.services.district.DistrictResult.AnonymousClass1();
    }

    public DistrictResult(android.os.Parcel parcel) {
        this.b = new java.util.ArrayList<>();
        this.CREATOR = new com.amap.api.services.district.DistrictResult.AnonymousClass1();
        this.a = (com.amap.api.services.district.DistrictSearchQuery) parcel.readParcelable(com.amap.api.services.district.DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(com.amap.api.services.district.DistrictItem.CREATOR);
    }

    public DistrictResult(com.amap.api.services.district.DistrictSearchQuery districtSearchQuery, java.util.ArrayList<com.amap.api.services.district.DistrictItem> arrayList) {
        this.b = new java.util.ArrayList<>();
        this.CREATOR = new com.amap.api.services.district.DistrictResult.AnonymousClass1();
        this.a = districtSearchQuery;
        this.b = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.amap.api.services.district.DistrictResult.class != obj.getClass()) {
            return false;
        }
        com.amap.api.services.district.DistrictResult districtResult = (com.amap.api.services.district.DistrictResult) obj;
        com.amap.api.services.district.DistrictSearchQuery districtSearchQuery = this.a;
        if (districtSearchQuery == null) {
            if (districtResult.a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.a)) {
            return false;
        }
        java.util.ArrayList<com.amap.api.services.district.DistrictItem> arrayList = this.b;
        if (arrayList == null) {
            if (districtResult.b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.b)) {
            return false;
        }
        return true;
    }

    public final com.amap.api.services.core.AMapException getAMapException() {
        return this.d;
    }

    public final java.util.ArrayList<com.amap.api.services.district.DistrictItem> getDistrict() {
        return this.b;
    }

    public final int getPageCount() {
        return this.c;
    }

    public final com.amap.api.services.district.DistrictSearchQuery getQuery() {
        return this.a;
    }

    public final int hashCode() {
        com.amap.api.services.district.DistrictSearchQuery districtSearchQuery = this.a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        java.util.ArrayList<com.amap.api.services.district.DistrictItem> arrayList = this.b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAMapException(com.amap.api.services.core.AMapException aMapException) {
        this.d = aMapException;
    }

    public final void setDistrict(java.util.ArrayList<com.amap.api.services.district.DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public final void setPageCount(int i) {
        this.c = i;
    }

    public final void setQuery(com.amap.api.services.district.DistrictSearchQuery districtSearchQuery) {
        this.a = districtSearchQuery;
    }

    public final java.lang.String toString() {
        return "DistrictResult [mDisQuery=" + this.a + ", mDistricts=" + this.b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
    }
}
