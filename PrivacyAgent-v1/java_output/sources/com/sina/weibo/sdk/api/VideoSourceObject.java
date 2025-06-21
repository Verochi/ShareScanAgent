package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class VideoSourceObject extends com.sina.weibo.sdk.api.MediaObject {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.VideoSourceObject> CREATOR = new com.sina.weibo.sdk.api.VideoSourceObject.AnonymousClass1();
    private static final long serialVersionUID = 2745594466460840583L;
    public android.net.Uri coverPath;
    public long during;
    public android.net.Uri videoPath;

    /* renamed from: com.sina.weibo.sdk.api.VideoSourceObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.VideoSourceObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.VideoSourceObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.VideoSourceObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.VideoSourceObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.VideoSourceObject[i];
        }
    }

    public VideoSourceObject() {
    }

    public VideoSourceObject(android.os.Parcel parcel) {
        super(parcel);
        this.coverPath = (android.net.Uri) parcel.readParcelable(android.net.Uri.class.getClassLoader());
        this.videoPath = (android.net.Uri) parcel.readParcelable(android.net.Uri.class.getClassLoader());
        this.during = parcel.readLong();
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coverPath, i);
        parcel.writeParcelable(this.videoPath, i);
        parcel.writeLong(this.during);
    }
}
