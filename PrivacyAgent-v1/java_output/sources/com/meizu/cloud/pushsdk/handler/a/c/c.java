package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class c implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.c> CREATOR = new com.meizu.cloud.pushsdk.handler.a.c.c.AnonymousClass1();
    private com.meizu.cloud.pushsdk.handler.MessageV3 a;
    private java.lang.String b;
    private int c;
    private int d;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.c> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.c createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.a.c.c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.c[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.a.c.c[i];
        }
    }

    public c(android.os.Parcel parcel) {
        this.a = (com.meizu.cloud.pushsdk.handler.MessageV3) parcel.readParcelable(com.meizu.cloud.pushsdk.handler.MessageV3.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    public c(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        this.a = messageV3;
    }

    public com.meizu.cloud.pushsdk.handler.MessageV3 a() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.b + "', notificationId='" + this.c + "', state='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
