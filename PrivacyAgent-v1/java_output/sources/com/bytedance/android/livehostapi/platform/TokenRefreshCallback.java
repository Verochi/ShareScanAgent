package com.bytedance.android.livehostapi.platform;

/* loaded from: classes.dex */
public interface TokenRefreshCallback {
    void onFailed(java.lang.Throwable th);

    void onSuccess(com.bytedance.android.livehostapi.platform.TokenInfo tokenInfo);
}
