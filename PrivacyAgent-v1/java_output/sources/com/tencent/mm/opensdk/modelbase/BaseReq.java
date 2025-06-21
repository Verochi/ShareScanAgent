package com.tencent.mm.opensdk.modelbase;

/* loaded from: classes19.dex */
public abstract class BaseReq {
    public java.lang.String openId;
    public java.lang.String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(android.os.Bundle bundle) {
        this.transaction = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_basereq_transaction");
        this.openId = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(android.os.Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
