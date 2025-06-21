package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class MediaInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.aliyun.svideo.media.MediaInfo> CREATOR = new com.aliyun.svideo.media.MediaInfo.AnonymousClass1();
    public long addTime;
    public int duration;
    public java.lang.String filePath;
    public java.lang.String fileUri;
    public int id;
    public boolean isSquare;
    public java.lang.String mimeType;
    public long startTime;
    public java.lang.String thumbnailPath;
    public java.lang.String thumbnailUri;
    public java.lang.String title;
    public int type;

    /* renamed from: com.aliyun.svideo.media.MediaInfo$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.aliyun.svideo.media.MediaInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.aliyun.svideo.media.MediaInfo createFromParcel(android.os.Parcel parcel) {
            return new com.aliyun.svideo.media.MediaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.aliyun.svideo.media.MediaInfo[] newArray(int i) {
            return new com.aliyun.svideo.media.MediaInfo[i];
        }
    }

    public MediaInfo() {
    }

    public MediaInfo(android.os.Parcel parcel) {
        this.filePath = parcel.readString();
        this.thumbnailPath = parcel.readString();
        this.mimeType = parcel.readString();
        this.title = parcel.readString();
        this.startTime = parcel.readLong();
        this.duration = parcel.readInt();
        this.id = parcel.readInt();
        this.addTime = parcel.readLong();
        this.isSquare = parcel.readByte() != 0;
        this.type = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideo.media.MediaInfo) && this.id == ((com.aliyun.svideo.media.MediaInfo) obj).id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.filePath);
        parcel.writeString(this.thumbnailPath);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.title);
        parcel.writeLong(this.startTime);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.id);
        parcel.writeLong(this.addTime);
        parcel.writeByte(this.isSquare ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
    }
}
