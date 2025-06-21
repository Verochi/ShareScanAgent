package com.amap.api.services.cloud;

/* loaded from: classes12.dex */
public class CloudItemDetail extends com.amap.api.services.cloud.CloudItem {
    public static final android.os.Parcelable.Creator<com.amap.api.services.cloud.CloudItemDetail> CREATOR = new com.amap.api.services.cloud.CloudItemDetail.AnonymousClass1();

    /* renamed from: com.amap.api.services.cloud.CloudItemDetail$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.cloud.CloudItemDetail> {
        private static com.amap.api.services.cloud.CloudItemDetail a(android.os.Parcel parcel) {
            return new com.amap.api.services.cloud.CloudItemDetail(parcel);
        }

        private static com.amap.api.services.cloud.CloudItemDetail[] a(int i) {
            return new com.amap.api.services.cloud.CloudItemDetail[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.cloud.CloudItemDetail createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.cloud.CloudItemDetail[] newArray(int i) {
            return a(i);
        }
    }

    public CloudItemDetail(android.os.Parcel parcel) {
        super(parcel);
    }

    public CloudItemDetail(java.lang.String str, com.amap.api.services.core.LatLonPoint latLonPoint, java.lang.String str2, java.lang.String str3) {
        super(str, latLonPoint, str2, str3);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
