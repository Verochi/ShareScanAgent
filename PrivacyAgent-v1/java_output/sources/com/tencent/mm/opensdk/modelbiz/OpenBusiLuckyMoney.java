package com.tencent.mm.opensdk.modelbiz;

/* loaded from: classes19.dex */
public class OpenBusiLuckyMoney {

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public java.lang.String appId;
        public java.lang.String nonceStr;
        public java.lang.String packageExt;
        public java.lang.String signType;
        public java.lang.String signature;
        public java.lang.String timeStamp;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            java.lang.String str5 = this.appId;
            return str5 != null && str5.length() > 0 && (str = this.timeStamp) != null && str.length() > 0 && (str2 = this.nonceStr) != null && str2.length() > 0 && (str3 = this.signType) != null && str3.length() > 0 && (str4 = this.signature) != null && str4.length() > 0;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 13;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
        }
    }
}
