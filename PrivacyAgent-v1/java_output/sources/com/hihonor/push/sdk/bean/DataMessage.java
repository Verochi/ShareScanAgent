package com.hihonor.push.sdk.bean;

/* loaded from: classes22.dex */
public class DataMessage implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.hihonor.push.sdk.bean.DataMessage> CREATOR = new com.hihonor.push.sdk.bean.DataMessage.AnonymousClass1();
    private java.lang.String content;
    private long msgId;

    /* renamed from: com.hihonor.push.sdk.bean.DataMessage$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.hihonor.push.sdk.bean.DataMessage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.hihonor.push.sdk.bean.DataMessage createFromParcel(android.os.Parcel parcel) {
            return new com.hihonor.push.sdk.bean.DataMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.hihonor.push.sdk.bean.DataMessage[] newArray(int i) {
            return new com.hihonor.push.sdk.bean.DataMessage[i];
        }
    }

    public DataMessage() {
    }

    public DataMessage(android.os.Parcel parcel) {
        this.msgId = parcel.readLong();
        this.content = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public java.lang.String toString() {
        return "DataMessage{msgId=" + this.msgId + ", content='" + this.content + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.msgId);
        parcel.writeString(this.content);
    }
}
