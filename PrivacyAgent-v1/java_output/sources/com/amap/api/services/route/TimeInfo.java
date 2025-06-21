package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class TimeInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.TimeInfo> CREATOR = new com.amap.api.services.route.TimeInfo.AnonymousClass1();
    private long a;
    private java.util.List<com.amap.api.services.route.TimeInfosElement> b;

    /* renamed from: com.amap.api.services.route.TimeInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.TimeInfo> {
        private static com.amap.api.services.route.TimeInfo a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TimeInfo createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.TimeInfo[] newArray(int i) {
            return null;
        }
    }

    public TimeInfo() {
        this.b = new java.util.ArrayList();
    }

    public TimeInfo(android.os.Parcel parcel) {
        this.b = new java.util.ArrayList();
        this.a = parcel.readInt();
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.TimeInfosElement> getElements() {
        return this.b;
    }

    public long getStartTime() {
        return this.a;
    }

    public void setElements(java.util.List<com.amap.api.services.route.TimeInfosElement> list) {
        this.b = list;
    }

    public void setStartTime(long j) {
        this.a = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeTypedList(this.b);
    }
}
