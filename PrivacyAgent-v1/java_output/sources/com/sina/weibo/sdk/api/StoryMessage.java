package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class StoryMessage implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.StoryMessage> CREATOR = new com.sina.weibo.sdk.api.StoryMessage.AnonymousClass1();
    private android.net.Uri imageUri;
    private android.net.Uri videoUri;

    /* renamed from: com.sina.weibo.sdk.api.StoryMessage$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.StoryMessage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.StoryMessage createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.StoryMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.StoryMessage[] newArray(int i) {
            return new com.sina.weibo.sdk.api.StoryMessage[i];
        }
    }

    public StoryMessage() {
    }

    public StoryMessage(android.os.Parcel parcel) {
        this.imageUri = (android.net.Uri) parcel.readParcelable(android.net.Uri.class.getClassLoader());
        this.videoUri = (android.net.Uri) parcel.readParcelable(android.net.Uri.class.getClassLoader());
    }

    public boolean checkResource() {
        android.net.Uri uri = this.imageUri;
        if (uri == null || this.videoUri == null) {
            return (uri == null && this.videoUri == null) ? false : true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public android.net.Uri getImageUri() {
        return this.imageUri;
    }

    public android.net.Uri getVideoUri() {
        return this.videoUri;
    }

    public void setImageUri(android.net.Uri uri) {
        this.imageUri = uri;
    }

    public void setVideoUri(android.net.Uri uri) {
        this.videoUri = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.videoUri, i);
    }
}
