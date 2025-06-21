package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public class DataBuffer implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.huawei.hms.core.aidl.DataBuffer> CREATOR = new com.huawei.hms.core.aidl.DataBuffer.a();
    public java.lang.String URI;
    private int a;
    private android.os.Bundle b;
    public android.os.Bundle header;

    public static class a implements android.os.Parcelable.Creator<com.huawei.hms.core.aidl.DataBuffer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.core.aidl.DataBuffer createFromParcel(android.os.Parcel parcel) {
            return new com.huawei.hms.core.aidl.DataBuffer(parcel, (com.huawei.hms.core.aidl.DataBuffer.a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.core.aidl.DataBuffer[] newArray(int i) {
            return new com.huawei.hms.core.aidl.DataBuffer[i];
        }
    }

    public DataBuffer() {
        this.header = null;
        this.a = 1;
        this.b = null;
    }

    private DataBuffer(android.os.Parcel parcel) {
        this.header = null;
        this.a = 1;
        this.b = null;
        a(parcel);
    }

    public /* synthetic */ DataBuffer(android.os.Parcel parcel, com.huawei.hms.core.aidl.DataBuffer.a aVar) {
        this(parcel);
    }

    public DataBuffer(java.lang.String str) {
        this.header = null;
        this.a = 1;
        this.b = null;
        this.URI = str;
    }

    public DataBuffer(java.lang.String str, int i) {
        this.header = null;
        this.b = null;
        this.URI = str;
        this.a = i;
    }

    private static java.lang.ClassLoader a(java.lang.Class cls) {
        return cls.getClassLoader();
    }

    private void a(android.os.Parcel parcel) {
        this.a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(a(android.os.Bundle.class));
        this.b = parcel.readBundle(a(android.os.Bundle.class));
    }

    public com.huawei.hms.core.aidl.DataBuffer addBody(android.os.Bundle bundle) {
        this.b = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public android.os.Bundle getBody() {
        return this.b;
    }

    public int getBodySize() {
        return this.b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.b);
    }
}
