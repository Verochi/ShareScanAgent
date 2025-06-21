package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public abstract class TTWidgetManager {
    public static com.bytedance.sdk.openadsdk.TTWidgetManager create(android.view.View view) {
        if (view == null) {
            return null;
        }
        com.bykv.vk.openvk.api.proto.Bridge bridge = view.getTag() instanceof com.bykv.vk.openvk.api.proto.Bridge ? (com.bykv.vk.openvk.api.proto.Bridge) view.getTag() : null;
        if (bridge == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.t.vw.vw.k(bridge);
    }

    public abstract boolean updateWidgetWithType(int i, org.json.JSONObject jSONObject);
}
