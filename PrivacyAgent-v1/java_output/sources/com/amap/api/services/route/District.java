package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class District implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.District> CREATOR = new com.amap.api.services.route.District.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;

    /* renamed from: com.amap.api.services.route.District$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.District> {
        private static com.amap.api.services.route.District a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.District createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.District[] newArray(int i) {
            return null;
        }
    }

    public District() {
    }

    public District(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getDistrictAdcode() {
        return this.b;
    }

    public java.lang.String getDistrictName() {
        return this.a;
    }

    public void setDistrictAdcode(java.lang.String str) {
        this.b = str;
    }

    public void setDistrictName(java.lang.String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
