package com.bytedance.sdk.openadsdk.z.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener) {
        this.wg = adInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null) {
            switch (i) {
                case 141101:
                    this.wg.onAdClicked((android.view.View) valueSet.objectValue(0, android.view.View.class), new com.bytedance.sdk.openadsdk.t.vw.vw.cp((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(1, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 141102:
                    this.wg.onAdCreativeClick((android.view.View) valueSet.objectValue(0, android.view.View.class), new com.bytedance.sdk.openadsdk.t.vw.vw.cp((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(1, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 141103:
                    this.wg.onAdShow(new com.bytedance.sdk.openadsdk.t.vw.vw.cp((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
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
