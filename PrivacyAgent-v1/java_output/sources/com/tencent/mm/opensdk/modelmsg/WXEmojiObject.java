package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXEmojiObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public java.lang.String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(java.lang.String str) {
        this.emojiPath = str;
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
    }

    private int getFileSize(java.lang.String str) {
        return com.tencent.mm.opensdk.utils.b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2;
        byte[] bArr = this.emojiData;
        if ((bArr == null || bArr.length == 0) && ((str = this.emojiPath) == null || str.length() == 0)) {
            str2 = "checkArgs fail, both arguments is null";
        } else {
            byte[] bArr2 = this.emojiData;
            if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
                java.lang.String str3 = this.emojiPath;
                if (str3 == null || getFileSize(str3) <= CONTENT_LENGTH_LIMIT) {
                    return true;
                }
                str2 = "checkArgs fail, emojiSize is too large";
            } else {
                str2 = "checkArgs fail, emojiData is too large";
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(java.lang.String str) {
        this.emojiPath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 8;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}
