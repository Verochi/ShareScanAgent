package com.amap.api.services.poisearch;

/* loaded from: classes12.dex */
public final class Photo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.poisearch.Photo> CREATOR = new com.amap.api.services.poisearch.Photo.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;

    /* renamed from: com.amap.api.services.poisearch.Photo$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.poisearch.Photo> {
        private static com.amap.api.services.poisearch.Photo a(android.os.Parcel parcel) {
            return new com.amap.api.services.poisearch.Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.poisearch.Photo createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.poisearch.Photo[] newArray(int i) {
            return null;
        }
    }

    public Photo() {
    }

    public Photo(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public Photo(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String getTitle() {
        return this.a;
    }

    public final java.lang.String getUrl() {
        return this.b;
    }

    public final void setTitle(java.lang.String str) {
        this.a = str;
    }

    public final void setUrl(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
