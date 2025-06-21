package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXEmojiSharedObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final java.lang.String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public int packageflag;
    public java.lang.String packageid;
    public java.lang.String thumburl;
    public java.lang.String url;

    public WXEmojiSharedObject() {
    }

    public WXEmojiSharedObject(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        this.thumburl = str;
        this.packageflag = i;
        this.packageid = str2;
        this.url = str3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (!android.text.TextUtils.isEmpty(this.packageid) && !android.text.TextUtils.isEmpty(this.thumburl) && !android.text.TextUtils.isEmpty(this.url) && this.packageflag != -1) {
            return true;
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
        bundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
        bundle.putString("_wxemojisharedobject_packageid", this.packageid);
        bundle.putString("_wxemojisharedobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 15;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
        this.packageflag = bundle.getInt("_wxwebpageobject_packageflag");
        this.packageid = bundle.getString("_wxwebpageobject_packageid");
        this.url = bundle.getString("_wxwebpageobject_url");
    }
}
