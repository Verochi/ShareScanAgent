package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTDownloadEventLogger {
    void onDownloadConfigReady();

    void onEvent(org.json.JSONObject jSONObject);

    void onV3Event(org.json.JSONObject jSONObject);

    boolean shouldFilterOpenSdkLog();
}
