package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class MultiImageObject extends com.sina.weibo.sdk.api.MediaObject {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.MultiImageObject> CREATOR = new com.sina.weibo.sdk.api.MultiImageObject.AnonymousClass1();
    private static final long serialVersionUID = 4858450022450986236L;
    public java.util.ArrayList<android.net.Uri> imageList;

    /* renamed from: com.sina.weibo.sdk.api.MultiImageObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.MultiImageObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.MultiImageObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.MultiImageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.MultiImageObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.MultiImageObject[i];
        }
    }

    public MultiImageObject() {
    }

    public MultiImageObject(android.os.Parcel parcel) {
        super(parcel);
        this.imageList = parcel.createTypedArrayList(android.net.Uri.CREATOR);
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.ArrayList<android.net.Uri> getImageList() {
        return this.imageList;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.imageList);
    }
}
