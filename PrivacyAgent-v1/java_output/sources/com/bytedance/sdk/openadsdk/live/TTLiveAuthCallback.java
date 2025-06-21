package com.bytedance.sdk.openadsdk.live;

/* loaded from: classes22.dex */
public interface TTLiveAuthCallback extends java.io.Serializable {
    void onAuth(com.bytedance.sdk.openadsdk.live.TTLiveToken tTLiveToken);

    void onFailed(java.lang.Throwable th);
}
