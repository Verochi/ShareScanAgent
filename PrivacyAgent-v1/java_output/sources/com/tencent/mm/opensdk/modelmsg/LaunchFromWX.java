package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class LaunchFromWX {

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
        private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
        private static final java.lang.String TAG = "MicroMsg.SDK.LaunchFromWX.Req";
        public java.lang.String country;
        public java.lang.String lang;
        public java.lang.String messageAction;
        public java.lang.String messageExt;

        public Req() {
        }

        public Req(android.os.Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            java.lang.String str;
            java.lang.String str2 = this.messageAction;
            if (str2 == null || str2.length() <= 2048) {
                java.lang.String str3 = this.messageExt;
                if (str3 == null || str3.length() <= 2048) {
                    return true;
                }
                str = "checkArgs fail, messageExt is too long";
            } else {
                str = "checkArgs fail, messageAction is too long";
            }
            com.tencent.mm.opensdk.utils.Log.e(TAG, str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.messageAction = bundle.getString("_wxobject_message_action");
            this.messageExt = bundle.getString("_wxobject_message_ext");
            this.lang = bundle.getString("_wxapi_launch_req_lang");
            this.country = bundle.getString("_wxapi_launch_req_country");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 6;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxobject_message_action", this.messageAction);
            bundle.putString("_wxobject_message_ext", this.messageExt);
            bundle.putString("_wxapi_launch_req_lang", this.lang);
            bundle.putString("_wxapi_launch_req_country", this.country);
        }
    }

    public static class Resp extends com.tencent.mm.opensdk.modelbase.BaseResp {
        public Resp() {
        }

        public Resp(android.os.Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 6;
        }
    }

    private LaunchFromWX() {
    }
}
