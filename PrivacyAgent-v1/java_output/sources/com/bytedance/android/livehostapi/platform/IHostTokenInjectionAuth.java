package com.bytedance.android.livehostapi.platform;

/* loaded from: classes.dex */
public interface IHostTokenInjectionAuth {
    com.bytedance.android.livehostapi.platform.TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(com.bytedance.android.livehostapi.platform.TokenInfo tokenInfo, com.bytedance.android.livehostapi.platform.TokenRefreshCallback tokenRefreshCallback, android.app.Activity activity, java.util.Map<java.lang.String, java.lang.String> map);
}
