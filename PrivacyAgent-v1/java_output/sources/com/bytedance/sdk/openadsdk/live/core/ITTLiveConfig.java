package com.bytedance.sdk.openadsdk.live.core;

/* loaded from: classes22.dex */
public interface ITTLiveConfig {
    java.lang.String getAppName();

    java.lang.String getChannel();

    java.lang.String getECHostAppId();

    java.lang.String getGeneralAppId();

    com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner getHostPermission();

    com.bytedance.sdk.openadsdk.live.core.ITTLiveHostAction getLiveHostAction();

    java.lang.String getPartner();

    java.lang.String getPartnerSecret();

    java.lang.String getVersion();

    int getVersionCode();

    boolean isDebug();

    boolean isValid();
}
