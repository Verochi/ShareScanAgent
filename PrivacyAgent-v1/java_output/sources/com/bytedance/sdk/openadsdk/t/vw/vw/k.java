package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class k extends com.bytedance.sdk.openadsdk.TTWidgetManager {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public k(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i, org.json.JSONObject jSONObject) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(2);
        vw.vw(0, i);
        vw.vw(1, jSONObject);
        return ((java.lang.Boolean) this.vw.call(264001, vw.wg(), java.lang.Boolean.TYPE)).booleanValue();
    }
}
