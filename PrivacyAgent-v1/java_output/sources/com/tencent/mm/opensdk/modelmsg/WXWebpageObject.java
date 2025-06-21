package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXWebpageObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXWebpageObject";
    public java.lang.String canvasPageXml;
    public java.lang.String extInfo;
    public java.lang.String webpageUrl;

    public WXWebpageObject() {
    }

    public WXWebpageObject(java.lang.String str) {
        this.webpageUrl = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str = this.webpageUrl;
        if (str != null && str.length() != 0 && this.webpageUrl.length() <= 10240) {
            return true;
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, "checkArgs fail, webpageUrl is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxwebpageobject_extInfo", this.extInfo);
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        bundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.extInfo = bundle.getString("_wxwebpageobject_extInfo");
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
        this.canvasPageXml = bundle.getString("_wxwebpageobject_canvaspagexml");
    }
}
