package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXFileObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public java.lang.String filePath;

    public WXFileObject() {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(java.lang.String str) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = bArr;
    }

    private int getFileSize(java.lang.String str) {
        return com.tencent.mm.opensdk.utils.b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2;
        byte[] bArr = this.fileData;
        if ((bArr == null || bArr.length == 0) && ((str = this.filePath) == null || str.length() == 0)) {
            str2 = "checkArgs fail, both arguments is null";
        } else {
            byte[] bArr2 = this.fileData;
            if (bArr2 == null || bArr2.length <= this.contentLengthLimit) {
                java.lang.String str3 = this.filePath;
                if (str3 == null || getFileSize(str3) <= this.contentLengthLimit) {
                    return true;
                }
                str2 = "checkArgs fail, fileSize is too large";
            } else {
                str2 = "checkArgs fail, fileData is too large";
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int i) {
        this.contentLengthLimit = i;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}
