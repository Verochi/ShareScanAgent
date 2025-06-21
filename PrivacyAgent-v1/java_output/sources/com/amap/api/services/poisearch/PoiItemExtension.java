package com.amap.api.services.poisearch;

/* loaded from: classes12.dex */
public class PoiItemExtension implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.poisearch.PoiItemExtension> CREATOR = new com.amap.api.services.poisearch.PoiItemExtension.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;

    /* renamed from: com.amap.api.services.poisearch.PoiItemExtension$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.poisearch.PoiItemExtension> {
        private static com.amap.api.services.poisearch.PoiItemExtension a(android.os.Parcel parcel) {
            return new com.amap.api.services.poisearch.PoiItemExtension(parcel);
        }

        private static com.amap.api.services.poisearch.PoiItemExtension[] a(int i) {
            return new com.amap.api.services.poisearch.PoiItemExtension[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.poisearch.PoiItemExtension createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.poisearch.PoiItemExtension[] newArray(int i) {
            return a(i);
        }
    }

    public PoiItemExtension(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public PoiItemExtension(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getOpentime() {
        return this.a;
    }

    public java.lang.String getmRating() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
