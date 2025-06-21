package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class x extends com.bytedance.sdk.openadsdk.TTCustomController {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public x(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((java.lang.Boolean) this.vw.call(262103, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public java.lang.String getAndroidId() {
        return (java.lang.String) this.vw.call(262112, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public java.lang.String getDevImei() {
        return (java.lang.String) this.vw.call(262105, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public java.lang.String getDevOaid() {
        return (java.lang.String) this.vw.call(262109, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public java.lang.String getMacAddress() {
        return (java.lang.String) this.vw.call(262107, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public com.bytedance.sdk.openadsdk.LocationProvider getTTLocation() {
        return (com.bytedance.sdk.openadsdk.LocationProvider) this.vw.call(262102, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), com.bytedance.sdk.openadsdk.LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((java.lang.Boolean) this.vw.call(262110, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((java.lang.Boolean) this.vw.call(262101, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((java.lang.Boolean) this.vw.call(262111, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((java.lang.Boolean) this.vw.call(262104, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((java.lang.Boolean) this.vw.call(262106, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((java.lang.Boolean) this.vw.call(262108, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }
}
