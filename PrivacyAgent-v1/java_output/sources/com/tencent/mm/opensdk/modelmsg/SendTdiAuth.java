package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class SendTdiAuth {

    public static final class Resp extends com.tencent.mm.opensdk.modelmsg.SendAuth.Resp {
        private static final java.lang.String KEY_AUTH_BUFFER = "_wxapi_sendauth_resp_tdi_buffer";
        private static final java.lang.String TAG = "MicroMsg.SDK.SendTdiAuth.Resp";
        public byte[] tdiAuthBuffer;

        public Resp(android.os.Bundle bundle) {
            super(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            this.tdiAuthBuffer = bundle.getByteArray(KEY_AUTH_BUFFER);
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 31;
        }

        @Override // com.tencent.mm.opensdk.modelmsg.SendAuth.Resp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            bundle.putByteArray(KEY_AUTH_BUFFER, this.tdiAuthBuffer);
        }
    }

    private SendTdiAuth() {
    }
}
