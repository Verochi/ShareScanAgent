package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXEmojiPageSharedObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final java.lang.String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public java.lang.String desc;
    public java.lang.String iconUrl;
    public int pageType;
    public java.lang.String secondUrl;
    public int tid;
    public java.lang.String title;
    public int type;
    public java.lang.String url;

    public WXEmojiPageSharedObject() {
    }

    public WXEmojiPageSharedObject(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i3, java.lang.String str5) {
        this.tid = i2;
        this.title = str;
        this.desc = str2;
        this.iconUrl = str3;
        this.secondUrl = str4;
        this.pageType = i3;
        this.url = str5;
        this.type = i;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (!com.tencent.mm.opensdk.utils.b.b(this.title) && !com.tencent.mm.opensdk.utils.b.b(this.iconUrl)) {
            return true;
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, "checkArgs fail, title or iconUrl is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putInt("_wxemojisharedobject_tid", this.tid);
        bundle.putString("_wxemojisharedobject_title", this.title);
        bundle.putString("_wxemojisharedobject_desc", this.desc);
        bundle.putString("_wxemojisharedobject_iconurl", this.iconUrl);
        bundle.putString("_wxemojisharedobject_secondurl", this.secondUrl);
        bundle.putInt("_wxemojisharedobject_pagetype", this.pageType);
        bundle.putString("_wxwebpageobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return this.type;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.tid = bundle.getInt("_wxemojisharedobject_tid");
        this.title = bundle.getString("_wxemojisharedobject_title");
        this.desc = bundle.getString("_wxemojisharedobject_desc");
        this.iconUrl = bundle.getString("_wxemojisharedobject_iconurl");
        this.secondUrl = bundle.getString("_wxemojisharedobject_secondurl");
        this.pageType = bundle.getInt("_wxemojisharedobject_pagetype");
        this.url = bundle.getString("_wxwebpageobject_url");
    }
}
