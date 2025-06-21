package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTInitializer {
    com.bytedance.sdk.openadsdk.TTAdManager getAdManager();

    @java.lang.Deprecated
    com.bytedance.sdk.openadsdk.TTAdManager init(android.content.Context context, com.bytedance.sdk.openadsdk.AdConfig adConfig);

    void init(android.content.Context context, com.bytedance.sdk.openadsdk.AdConfig adConfig, com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback initCallback);

    boolean isInitSuccess();
}
