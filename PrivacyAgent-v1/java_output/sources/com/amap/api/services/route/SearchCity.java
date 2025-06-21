package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class SearchCity implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.SearchCity> CREATOR = new com.amap.api.services.route.SearchCity.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    /* renamed from: com.amap.api.services.route.SearchCity$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.SearchCity> {
        private static com.amap.api.services.route.SearchCity a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.SearchCity createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.SearchCity[] newArray(int i) {
            return null;
        }
    }

    public SearchCity() {
    }

    public SearchCity(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getSearchCityAdCode() {
        return this.c;
    }

    public java.lang.String getSearchCityName() {
        return this.a;
    }

    public java.lang.String getSearchCitycode() {
        return this.b;
    }

    public void setSearchCityName(java.lang.String str) {
        this.a = str;
    }

    public void setSearchCitycode(java.lang.String str) {
        this.b = str;
    }

    public void setSearchCityhAdCode(java.lang.String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
