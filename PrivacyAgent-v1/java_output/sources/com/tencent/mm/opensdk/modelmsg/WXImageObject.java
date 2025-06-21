package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXImageObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public java.lang.String imagePath;

    public WXImageObject() {
    }

    public WXImageObject(android.graphics.Bitmap bitmap) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "WXImageObject <init>, exception:" + e.getMessage());
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(java.lang.String str) {
        return com.tencent.mm.opensdk.utils.b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str = this.imagePath) == null || str.length() == 0)) {
            str2 = "checkArgs fail, all arguments are null";
        } else {
            byte[] bArr2 = this.imageData;
            if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
                java.lang.String str3 = this.imagePath;
                if (str3 == null || str3.length() <= 10240) {
                    java.lang.String str4 = this.imagePath;
                    if (str4 == null || getFileSize(str4) <= CONTENT_LENGTH_LIMIT) {
                        return true;
                    }
                    str2 = "checkArgs fail, image content is too large";
                } else {
                    str2 = "checkArgs fail, path is invalid";
                }
            } else {
                str2 = "checkArgs fail, content is too large";
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
    }

    public void setImagePath(java.lang.String str) {
        this.imagePath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
    }
}
