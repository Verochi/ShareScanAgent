package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class Railway implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.Railway> CREATOR = new com.amap.api.services.route.Railway.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;

    /* renamed from: com.amap.api.services.route.Railway$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.Railway> {
        private static com.amap.api.services.route.Railway a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.Railway(parcel);
        }

        private static com.amap.api.services.route.Railway[] a(int i) {
            return new com.amap.api.services.route.Railway[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.Railway createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.Railway[] newArray(int i) {
            return a(i);
        }
    }

    public Railway() {
    }

    public Railway(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getID() {
        return this.a;
    }

    public java.lang.String getName() {
        return this.b;
    }

    public void setID(java.lang.String str) {
        this.a = str;
    }

    public void setName(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
