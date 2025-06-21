package com.bytedance.sdk.openadsdk.kz.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback wg;

    public vw(com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.wg = dislikeInteractionCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.wg;
        if (dislikeInteractionCallback != null) {
            switch (i) {
                case 244101:
                    dislikeInteractionCallback.onShow();
                    break;
                case 244102:
                    this.wg.onSelected(valueSet.intValue(0), (java.lang.String) valueSet.objectValue(1, java.lang.String.class), valueSet.booleanValue(2));
                    break;
                case 244103:
                    dislikeInteractionCallback.onCancel();
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
