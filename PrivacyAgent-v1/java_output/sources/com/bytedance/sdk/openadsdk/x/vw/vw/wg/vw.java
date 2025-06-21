package com.bytedance.sdk.openadsdk.x.vw.vw.wg;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener videoAdListener) {
        this.wg = videoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007e, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null) {
            switch (i) {
                case 161101:
                    this.wg.onVideoLoad(new com.bytedance.sdk.openadsdk.t.vw.vw.z((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 161102:
                    this.wg.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                    break;
                case 161103:
                    this.wg.onVideoAdPaused(new com.bytedance.sdk.openadsdk.t.vw.vw.z((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 161104:
                    this.wg.onVideoAdStartPlay(new com.bytedance.sdk.openadsdk.t.vw.vw.z((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 161105:
                    this.wg.onVideoAdContinuePlay(new com.bytedance.sdk.openadsdk.t.vw.vw.z((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 161106:
                    this.wg.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                    break;
                case 161107:
                    this.wg.onVideoAdComplete(new com.bytedance.sdk.openadsdk.t.vw.vw.z((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
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
