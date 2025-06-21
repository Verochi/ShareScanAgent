package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXTextObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXTextObject";
    public java.lang.String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(java.lang.String str) {
        this.text = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str = this.text;
        if (str != null && str.length() != 0 && this.text.length() <= 10240) {
            return true;
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, "checkArgs fail, text is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}
