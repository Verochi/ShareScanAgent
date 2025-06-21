package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXDesignerSharedObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final java.lang.String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public java.lang.String designerName;
    public java.lang.String designerRediretctUrl;
    public int designerUIN;
    public java.lang.String thumburl;
    public java.lang.String url;

    public WXDesignerSharedObject() {
    }

    public WXDesignerSharedObject(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        this.url = str2;
        this.thumburl = str;
        this.designerUIN = i;
        this.designerName = str3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (this.designerUIN != 0 && !android.text.TextUtils.isEmpty(this.thumburl) && !android.text.TextUtils.isEmpty(this.url)) {
            return true;
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
        bundle.putInt("_wxemojisharedobject_designer_uin", this.designerUIN);
        bundle.putString("_wxemojisharedobject_designer_name", this.designerName);
        bundle.putString("_wxemojisharedobject_designer_rediretcturl", this.designerRediretctUrl);
        bundle.putString("_wxemojisharedobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 25;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
        this.designerUIN = bundle.getInt("_wxemojisharedobject_designer_uin");
        this.designerName = bundle.getString("_wxemojisharedobject_designer_name");
        this.designerRediretctUrl = bundle.getString("_wxemojisharedobject_designer_rediretcturl");
        this.url = bundle.getString("_wxwebpageobject_url");
    }
}
