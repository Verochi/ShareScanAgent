package com.tencent.mm.opensdk.modelpay;

/* loaded from: classes19.dex */
public class PayReq extends com.tencent.mm.opensdk.modelbase.BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final java.lang.String TAG = "MicroMsg.PaySdk.PayReq";
    public java.lang.String appId;
    public java.lang.String extData;
    public java.lang.String nonceStr;
    public com.tencent.mm.opensdk.modelpay.PayReq.Options options;
    public java.lang.String packageValue;
    public java.lang.String partnerId;
    public java.lang.String prepayId;
    public java.lang.String sign;
    public java.lang.String signType;
    public java.lang.String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public java.lang.String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(android.os.Bundle bundle) {
            this.callbackClassName = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payoptions_callback_classname");
            int i = -1;
            if (bundle != null) {
                try {
                    i = bundle.getInt("_wxapi_payoptions_callback_flags", -1);
                } catch (java.lang.Exception e) {
                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
                }
            }
            this.callbackFlags = i;
        }

        public void toBundle(android.os.Bundle bundle) {
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
        }
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2 = this.appId;
        if (str2 == null || str2.length() == 0) {
            str = "checkArgs fail, invalid appId";
        } else {
            java.lang.String str3 = this.partnerId;
            if (str3 == null || str3.length() == 0) {
                str = "checkArgs fail, invalid partnerId";
            } else {
                java.lang.String str4 = this.prepayId;
                if (str4 == null || str4.length() == 0) {
                    str = "checkArgs fail, invalid prepayId";
                } else {
                    java.lang.String str5 = this.nonceStr;
                    if (str5 == null || str5.length() == 0) {
                        str = "checkArgs fail, invalid nonceStr";
                    } else {
                        java.lang.String str6 = this.timeStamp;
                        if (str6 == null || str6.length() == 0) {
                            str = "checkArgs fail, invalid timeStamp";
                        } else {
                            java.lang.String str7 = this.packageValue;
                            if (str7 == null || str7.length() == 0) {
                                str = "checkArgs fail, invalid packageValue";
                            } else {
                                java.lang.String str8 = this.sign;
                                if (str8 == null || str8.length() == 0) {
                                    str = "checkArgs fail, invalid sign";
                                } else {
                                    java.lang.String str9 = this.extData;
                                    if (str9 == null || str9.length() <= 1024) {
                                        return true;
                                    }
                                    str = "checkArgs fail, extData length too long";
                                }
                            }
                        }
                    }
                }
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void fromBundle(android.os.Bundle bundle) {
        super.fromBundle(bundle);
        this.appId = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_appid");
        this.partnerId = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_packagevalue");
        this.sign = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_sign");
        this.extData = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_extdata");
        this.signType = com.tencent.mm.opensdk.channel.a.a.a(bundle, "_wxapi_payreq_sign_type");
        com.tencent.mm.opensdk.modelpay.PayReq.Options options = new com.tencent.mm.opensdk.modelpay.PayReq.Options();
        this.options = options;
        options.fromBundle(bundle);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void toBundle(android.os.Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        com.tencent.mm.opensdk.modelpay.PayReq.Options options = this.options;
        if (options != null) {
            options.toBundle(bundle);
        }
    }
}
