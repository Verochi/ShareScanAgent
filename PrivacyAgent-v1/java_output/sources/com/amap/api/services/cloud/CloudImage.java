package com.amap.api.services.cloud;

/* loaded from: classes12.dex */
public class CloudImage implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.cloud.CloudImage> CREATOR = new com.amap.api.services.cloud.CloudImage.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    /* renamed from: com.amap.api.services.cloud.CloudImage$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.cloud.CloudImage> {
        private static com.amap.api.services.cloud.CloudImage a(android.os.Parcel parcel) {
            return new com.amap.api.services.cloud.CloudImage(parcel);
        }

        private static com.amap.api.services.cloud.CloudImage[] a(int i) {
            return new com.amap.api.services.cloud.CloudImage[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.cloud.CloudImage createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.cloud.CloudImage[] newArray(int i) {
            return a(i);
        }
    }

    public CloudImage(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public CloudImage(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getId() {
        return this.a;
    }

    public java.lang.String getPreurl() {
        return this.b;
    }

    public java.lang.String getUrl() {
        return this.c;
    }

    public void setId(java.lang.String str) {
        this.a = str;
    }

    public void setPreurl(java.lang.String str) {
        this.b = str;
    }

    public void setUrl(java.lang.String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
