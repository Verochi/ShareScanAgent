package com.hihonor.push.framework.aidl;

/* loaded from: classes22.dex */
public class DataBuffer implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.hihonor.push.framework.aidl.DataBuffer> CREATOR = new com.hihonor.push.framework.aidl.DataBuffer.AnonymousClass1();
    public android.os.Bundle body;
    public java.lang.String eventType;
    public android.os.Bundle header;

    /* renamed from: com.hihonor.push.framework.aidl.DataBuffer$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.hihonor.push.framework.aidl.DataBuffer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.hihonor.push.framework.aidl.DataBuffer createFromParcel(android.os.Parcel parcel) {
            return new com.hihonor.push.framework.aidl.DataBuffer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.hihonor.push.framework.aidl.DataBuffer[] newArray(int i) {
            return new com.hihonor.push.framework.aidl.DataBuffer[i];
        }
    }

    public DataBuffer(android.os.Parcel parcel) {
        this.eventType = parcel.readString();
        this.header = parcel.readBundle(android.os.Bundle.class.getClassLoader());
        this.body = parcel.readBundle(android.os.Bundle.class.getClassLoader());
    }

    public DataBuffer(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        this.eventType = str;
        this.header = bundle;
        this.body = bundle2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public android.os.Bundle getBody() {
        return this.body;
    }

    public java.lang.String getEventType() {
        return this.eventType;
    }

    public android.os.Bundle getHeader() {
        return this.header;
    }

    public void setBody(android.os.Bundle bundle) {
        this.body = bundle;
    }

    public void setEventType(java.lang.String str) {
        this.eventType = str;
    }

    public void setHeader(android.os.Bundle bundle) {
        this.header = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.eventType);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.body);
    }
}
