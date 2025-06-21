package com.tencent.mm.opensdk.modelbiz;

/* loaded from: classes19.dex */
public class WXLaunchWxaRedirectingPage {
    public static final java.lang.String URI_PATH = "launchWxaOpenApiRedirectingPage";

    public interface ConstantsWxaRedirectingPage {
        public static final java.lang.String KEY_CALLBACK_ACTIVITY = "_launch_wx_wxa_redirecting_page_callback_activity";
        public static final java.lang.String KEY_CALLBACK_MSG = "_launch_wx_wxa_redirecting_page_callback_msg";
        public static final java.lang.String KEY_INVOKE_TICKET = "_launch_wx_wxa_redirecting_page_invoke_ticket";
    }

    public static final class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        private static final java.lang.String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
        public java.lang.String callbackActivity;
        public java.lang.String invokeTicket;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return !android.text.TextUtils.isEmpty(this.invokeTicket);
        }

        public void fromArray(java.lang.String[] strArr) {
            this.invokeTicket = strArr[0];
            this.callbackActivity = strArr[1];
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.invokeTicket = bundle.getString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = bundle.getString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 30;
        }

        public java.lang.String[] toArray() {
            return new java.lang.String[]{this.invokeTicket, this.callbackActivity};
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            bundle.putString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
        }
    }

    public static final class Resp extends com.tencent.mm.opensdk.modelbase.BaseResp {
        private static final java.lang.String TAG = "MicroMsg.SDK.WXLaunchWxaFRedirectingPage.Resp";
        public java.lang.String callbackActivity;
        public java.lang.String invokeTicket;

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
            this.invokeTicket = bundle.getString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET);
            this.callbackActivity = bundle.getString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 30;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_INVOKE_TICKET, this.invokeTicket);
            bundle.putString(com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.ConstantsWxaRedirectingPage.KEY_CALLBACK_ACTIVITY, this.callbackActivity);
        }
    }
}
