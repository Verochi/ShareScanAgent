package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class MediaObject implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.MediaObject> CREATOR = new com.sina.weibo.sdk.api.MediaObject.AnonymousClass1();
    private static final long serialVersionUID = -5562495969515901397L;
    public java.lang.String actionUrl;
    public java.lang.String description;
    public java.lang.String identify;
    public java.lang.String schema;
    public byte[] thumbData;
    public java.lang.String title;

    /* renamed from: com.sina.weibo.sdk.api.MediaObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.MediaObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.MediaObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.MediaObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.MediaObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.MediaObject[i];
        }
    }

    public MediaObject() {
    }

    public MediaObject(android.os.Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }
}
