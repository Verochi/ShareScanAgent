package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXVideoFileObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    public static final int FILE_SIZE_LIMIT = 104857600;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXVideoFileObject";
    public static final int WXVideoFileShareSceneCommon = 0;
    public static final int WXVideoFileShareSceneFromWX = 1;
    public java.lang.String filePath;
    public int shareScene;
    public java.lang.String shareTicket;

    public WXVideoFileObject() {
        this.shareScene = 0;
        this.filePath = null;
    }

    public WXVideoFileObject(java.lang.String str) {
        this.shareScene = 0;
        this.filePath = str;
    }

    private int getFileSize(java.lang.String str) {
        return com.tencent.mm.opensdk.utils.b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2 = this.filePath;
        if (str2 == null || str2.length() == 0) {
            str = "checkArgs fail, filePath is null";
        } else {
            if (getFileSize(this.filePath) <= 104857600) {
                return true;
            }
            str = "checkArgs fail, video file size is too large";
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
        bundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 38;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.shareScene = bundle.getInt("_wxvideofileobject_shareScene", 0);
        this.shareTicket = bundle.getString("_wxvideofileobject_shareTicketh");
    }
}
