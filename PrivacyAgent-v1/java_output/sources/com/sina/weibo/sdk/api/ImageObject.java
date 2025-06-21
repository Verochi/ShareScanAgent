package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class ImageObject extends com.sina.weibo.sdk.api.MediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 1048576;
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.ImageObject> CREATOR = new com.sina.weibo.sdk.api.ImageObject.AnonymousClass1();
    private static final int PATH_LENGTH_LIMIT = 512;
    private static final java.lang.String TAG = "ImageObject";
    private static final long serialVersionUID = 8760548583231081050L;
    public byte[] imageData;
    public java.lang.String imagePath;

    /* renamed from: com.sina.weibo.sdk.api.ImageObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.ImageObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.ImageObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.ImageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.ImageObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.ImageObject[i];
        }
    }

    public ImageObject() {
    }

    public ImageObject(android.os.Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    private int getFileSize(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    public boolean checkArgs() {
        java.lang.String str;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str = this.imagePath) == null || str.length() == 0)) {
            com.sina.weibo.sdk.c.c.b(TAG, "checkArgs fail, all arguments are null");
            return false;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 != null && bArr2.length > 1048576) {
            com.sina.weibo.sdk.c.c.b(TAG, "checkArgs fail, content is too large");
            return false;
        }
        java.lang.String str2 = this.imagePath;
        if (str2 != null && str2.length() > 512) {
            com.sina.weibo.sdk.c.c.b(TAG, "checkArgs fail, path is invalid");
            return false;
        }
        java.lang.String str3 = this.imagePath;
        if (str3 == null || getFileSize(str3) <= 1048576) {
            return true;
        }
        com.sina.weibo.sdk.c.c.b(TAG, "checkArgs fail, image content is too large");
        return false;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setImageData(android.graphics.Bitmap bitmap) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e) {
            com.sina.weibo.sdk.c.c.b(TAG, "ImageObject :" + e.getMessage());
        }
    }

    public void setImagePath(java.lang.String str) {
        this.imagePath = str;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }
}
