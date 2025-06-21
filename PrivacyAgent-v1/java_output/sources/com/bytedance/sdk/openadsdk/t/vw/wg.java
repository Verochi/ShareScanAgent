package com.bytedance.sdk.openadsdk.t.vw;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener wg;

    public wg(com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.wg = cSJSplashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null) {
            switch (i) {
                case 114102:
                    com.bykv.vk.openvk.api.proto.Bridge bridge = (com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class);
                    com.bytedance.sdk.openadsdk.t.vw.vw.wg wgVar = new com.bytedance.sdk.openadsdk.t.vw.vw.wg(bridge);
                    if (bridge != null) {
                        try {
                            if (bridge.values().intValue(1) >= 5700) {
                                this.wg.onSplashLoadSuccess(wgVar);
                            } else {
                                java.lang.reflect.Method declaredMethod = this.wg.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                                if (declaredMethod != null) {
                                    declaredMethod.invoke(this.wg, new java.lang.Object[0]);
                                }
                            }
                            break;
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    break;
                case 114103:
                    this.wg.onSplashLoadFail(new com.bytedance.sdk.openadsdk.t.vw.vw.vw((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 114104:
                    this.wg.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 114105:
                    this.wg.onSplashRenderFail(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)), new com.bytedance.sdk.openadsdk.t.vw.vw.vw((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(1, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
            }
        } else {
            return null;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
