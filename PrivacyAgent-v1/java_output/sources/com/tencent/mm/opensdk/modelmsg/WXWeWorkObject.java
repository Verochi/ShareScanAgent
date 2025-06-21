package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXWeWorkObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    public static final int SUB_TYPE_MSG_RECORD = 1;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXWeWorkObject";
    public byte[] data;
    public java.lang.String extInfo;
    public int subType;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putByteArray("_wxenterprise_object_data", this.data);
        bundle.putString("_wxenterprise_object_extinfo", this.extInfo);
        bundle.putInt("_wxenterprise_object_subType", this.subType);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 49;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.data = bundle.getByteArray("_wxenterprise_object_data");
        this.extInfo = bundle.getString("_wxenterprise_object_extinfo");
        this.subType = bundle.getInt("_wxenterprise_object_subType");
    }
}
