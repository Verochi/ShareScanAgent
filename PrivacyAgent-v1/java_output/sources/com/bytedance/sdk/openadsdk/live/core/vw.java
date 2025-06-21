package com.bytedance.sdk.openadsdk.live.core;

/* loaded from: classes22.dex */
public class vw implements com.bytedance.android.live.base.api.ILiveHostActionParam {
    private com.bykv.vk.openvk.api.proto.Bridge vw;

    public vw(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.bykv.vk.openvk.api.proto.Bridge bridge = this.vw;
        if (bridge != null) {
            bridge.call(1, com.bykv.vw.vw.vw.vw.wg.vw().vw(0, z).vw(1, str).vw(2, str2).vw(3, map).wg(), null);
        }
    }
}
