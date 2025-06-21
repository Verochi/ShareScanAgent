package com.bytedance.sdk.openadsdk.live;

/* loaded from: classes22.dex */
public interface ILiveAdCustomConfig {
    java.lang.String convertToEnterFromMerge(int i);

    java.lang.String convertToEnterMethod(int i, boolean z);

    java.lang.Object invoke(int i, android.os.Bundle bundle);

    void onEventV3(java.lang.String str, org.json.JSONObject jSONObject);

    int openLR(java.lang.String str);
}
