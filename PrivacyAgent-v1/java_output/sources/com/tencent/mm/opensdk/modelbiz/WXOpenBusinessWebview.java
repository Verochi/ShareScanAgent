package com.tencent.mm.opensdk.modelbiz;

/* loaded from: classes19.dex */
public class WXOpenBusinessWebview {

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        public int businessType;
        public java.util.HashMap<java.lang.String, java.lang.String> queryInfo;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.queryInfo = (java.util.HashMap) bundle.getSerializable("_wxapi_open_business_webview_query_info");
            this.businessType = bundle.getInt("_wxapi_open_business_webview_query_type", 0);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 25;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putSerializable("_wxapi_open_business_webview_query_info", this.queryInfo);
            bundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
        }
    }

    public static class Resp extends com.tencent.mm.opensdk.modelbase.BaseResp {
        public int businessType;
        public java.lang.String resultInfo;

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
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.resultInfo = bundle.getString("_wxapi_open_business_webview_result");
            this.businessType = bundle.getInt("_wxapi_open_business_webview_query_type", 0);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 25;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_business_webview_result", this.resultInfo);
            bundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
        }
    }
}
