package com.bytedance.sdk.openadsdk.vl.vw.vw.vw;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener wg;

    public wg(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.wg = expressAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null) {
            switch (i) {
                case 151101:
                    this.wg.onAdClicked((android.view.View) valueSet.objectValue(0, android.view.View.class), valueSet.intValue(1));
                    break;
                case 151102:
                    this.wg.onAdShow((android.view.View) valueSet.objectValue(0, android.view.View.class), valueSet.intValue(1));
                    break;
                case 151103:
                    this.wg.onRenderFail((android.view.View) valueSet.objectValue(0, android.view.View.class), (java.lang.String) valueSet.objectValue(1, java.lang.String.class), valueSet.intValue(2));
                    break;
                case 151104:
                    this.wg.onRenderSuccess((android.view.View) valueSet.objectValue(0, android.view.View.class), valueSet.floatValue(1), valueSet.floatValue(2));
                    break;
            }
        } else {
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
