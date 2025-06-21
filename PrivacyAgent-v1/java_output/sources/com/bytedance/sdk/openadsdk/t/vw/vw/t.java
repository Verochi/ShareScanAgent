package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class t implements com.bytedance.sdk.openadsdk.ComplianceInfo {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public t(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.lang.String getAppName() {
        return (java.lang.String) this.vw.values().objectValue(250001, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.lang.String getAppVersion() {
        return (java.lang.String) this.vw.values().objectValue(250002, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.lang.String getDeveloperName() {
        return (java.lang.String) this.vw.values().objectValue(250003, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.lang.String getFunctionDescUrl() {
        return (java.lang.String) this.vw.values().objectValue(250007, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.lang.String getPermissionUrl() {
        return (java.lang.String) this.vw.values().objectValue(250005, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.util.Map<java.lang.String, java.lang.String> getPermissionsMap() {
        return (java.util.Map) this.vw.values().objectValue(250006, java.util.Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public java.lang.String getPrivacyUrl() {
        return (java.lang.String) this.vw.values().objectValue(250004, java.lang.String.class);
    }
}
