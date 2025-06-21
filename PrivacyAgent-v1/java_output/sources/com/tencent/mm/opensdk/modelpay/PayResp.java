package com.tencent.mm.opensdk.modelpay;

/* loaded from: classes19.dex */
public class PayResp extends com.tencent.mm.opensdk.modelbase.BaseResp {
    public java.lang.String extData;
    public java.lang.String prepayId;
    public java.lang.String returnKey;

    public PayResp() {
    }

    public PayResp(android.os.Bundle bundle) {
        fromBundle(bundle);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public void fromBundle(android.os.Bundle bundle) {
        super.fromBundle(bundle);
        this.prepayId = bundle.getString("_wxapi_payresp_prepayid");
        this.returnKey = bundle.getString("_wxapi_payresp_returnkey");
        this.extData = bundle.getString("_wxapi_payresp_extdata");
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public void toBundle(android.os.Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payresp_prepayid", this.prepayId);
        bundle.putString("_wxapi_payresp_returnkey", this.returnKey);
        bundle.putString("_wxapi_payresp_extdata", this.extData);
    }
}
