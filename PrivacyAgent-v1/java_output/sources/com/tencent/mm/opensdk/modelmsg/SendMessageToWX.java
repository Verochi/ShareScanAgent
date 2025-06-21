package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class SendMessageToWX {

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
        private static final java.lang.String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
        public static final int WXSceneFavorite = 2;
        public static final int WXSceneSession = 0;
        public static final int WXSceneSpecifiedContact = 3;
        public static final int WXSceneTimeline = 1;
        public com.tencent.mm.opensdk.modelmsg.WXMediaMessage message;
        public int scene;
        public java.lang.String userOpenId;

        public Req() {
        }

        public Req(android.os.Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            java.lang.String str;
            com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                str = "checkArgs fail ,message is null";
            } else {
                if (wXMediaMessage.mediaObject.type() == 6 && this.scene == 2) {
                    ((com.tencent.mm.opensdk.modelmsg.WXFileObject) this.message.mediaObject).setContentLengthLimit(FAV_CONTENT_LENGTH_LIMIT);
                }
                int i = this.scene;
                if (i == 3 && this.userOpenId == null) {
                    str = "Send specifiedContact userOpenId can not be null.";
                } else {
                    if (i != 3 || this.openId != null) {
                        return this.message.checkArgs();
                    }
                    str = "Send specifiedContact openid can not be null.";
                }
            }
            com.tencent.mm.opensdk.utils.Log.e(TAG, str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.message = com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
            this.userOpenId = bundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder.toBundle(this.message));
            bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
            bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
            bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
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
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    private SendMessageToWX() {
    }
}
