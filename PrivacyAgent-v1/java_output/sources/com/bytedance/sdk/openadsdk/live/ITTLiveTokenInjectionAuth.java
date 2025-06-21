package com.bytedance.sdk.openadsdk.live;

/* loaded from: classes22.dex */
public interface ITTLiveTokenInjectionAuth extends java.io.Serializable {
    com.bytedance.sdk.openadsdk.live.TTLiveToken getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(com.bytedance.sdk.openadsdk.live.TTLiveToken tTLiveToken, com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback tTLiveAuthCallback, android.app.Activity activity, java.util.Map<java.lang.String, java.lang.String> map);
}
