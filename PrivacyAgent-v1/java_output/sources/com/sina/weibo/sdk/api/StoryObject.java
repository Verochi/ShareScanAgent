package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class StoryObject implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.StoryObject> CREATOR = new com.sina.weibo.sdk.api.StoryObject.AnonymousClass1();
    public java.lang.String appId;
    public java.lang.String appPackage;
    public java.lang.String callbackAction;
    public java.lang.String sourcePath;
    public int sourceType;

    /* renamed from: com.sina.weibo.sdk.api.StoryObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.StoryObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.StoryObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.StoryObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.StoryObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.StoryObject[i];
        }
    }

    public StoryObject() {
    }

    public StoryObject(android.os.Parcel parcel) {
        this.sourcePath = parcel.readString();
        this.sourceType = parcel.readInt();
        this.appId = parcel.readString();
        this.appPackage = parcel.readString();
        this.callbackAction = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.sourcePath);
        parcel.writeInt(this.sourceType);
        parcel.writeString(this.appId);
        parcel.writeString(this.appPackage);
        parcel.writeString(this.callbackAction);
    }
}
