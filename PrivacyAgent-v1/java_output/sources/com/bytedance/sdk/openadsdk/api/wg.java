package com.bytedance.sdk.openadsdk.api;

/* loaded from: classes22.dex */
public class wg {
    protected com.bykv.vk.openvk.api.proto.EventListener vw;

    public void vw(int i) {
        vw(i, null);
    }

    public void vw(int i, com.bykv.vk.openvk.api.proto.Result result) {
        if (vw()) {
            return;
        }
        this.vw.onEvent(i, result);
    }

    public boolean vw() {
        return this.vw == null;
    }
}
