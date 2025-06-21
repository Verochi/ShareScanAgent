package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class v implements com.bytedance.sdk.openadsdk.DislikeInfo {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public v(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public java.util.List<com.bytedance.sdk.openadsdk.FilterWord> getFilterWords() {
        java.util.List list = (java.util.List) this.vw.values().objectValue(243001, java.util.List.class);
        if (list == null) {
            list = new java.util.ArrayList(0);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bytedance.sdk.openadsdk.t.vw.vw.kz((com.bykv.vk.openvk.api.proto.Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public com.bytedance.sdk.openadsdk.PersonalizationPrompt getPersonalizationPrompt() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.bt((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(243002, com.bykv.vk.openvk.api.proto.Bridge.class));
    }
}
