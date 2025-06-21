package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class ChatObject extends com.sina.weibo.sdk.api.MediaObject {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.ChatObject> CREATOR = new com.sina.weibo.sdk.api.ChatObject.AnonymousClass1();
    public java.lang.String content;
    public java.lang.String image_url;
    public java.lang.String summary;
    public java.lang.String url;

    /* renamed from: com.sina.weibo.sdk.api.ChatObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.ChatObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.ChatObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.ChatObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.ChatObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.ChatObject[i];
        }
    }

    public ChatObject() {
    }

    public ChatObject(android.os.Parcel parcel) {
        super(parcel);
        this.url = parcel.readString();
        this.content = parcel.readString();
        this.image_url = parcel.readString();
        this.summary = parcel.readString();
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.url);
        parcel.writeString(this.content);
        parcel.writeString(this.image_url);
        parcel.writeString(this.summary);
    }
}
