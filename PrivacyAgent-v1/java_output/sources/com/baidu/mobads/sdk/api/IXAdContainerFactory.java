package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IXAdContainerFactory {
    java.lang.Object getRemoteParam(java.lang.String str, java.lang.Object... objArr);

    double getRemoteVersion();

    void initCommonModuleObj(java.lang.Object obj);

    void initConfig(org.json.JSONObject jSONObject);

    void onTaskDistribute(java.lang.String str, org.json.JSONObject jSONObject);
}
