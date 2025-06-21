package com.huawei.hms.aaid.plugin;

/* loaded from: classes22.dex */
public interface PushProxy {
    void deleteAllToken(android.content.Context context) throws com.huawei.hms.common.ApiException;

    void deleteToken(android.content.Context context, java.lang.String str, java.lang.String str2) throws com.huawei.hms.common.ApiException;

    org.json.JSONObject getPlatform();

    java.lang.String getProxyType();

    void getToken(android.content.Context context, java.lang.String str, java.lang.String str2) throws com.huawei.hms.common.ApiException;

    com.huawei.hmf.tasks.Task<java.lang.Void> subscribe(android.content.Context context, java.lang.String str, java.lang.String str2);

    com.huawei.hmf.tasks.Task<java.lang.Void> turnOff(android.content.Context context, java.lang.String str);

    com.huawei.hmf.tasks.Task<java.lang.Void> turnOn(android.content.Context context, java.lang.String str);

    com.huawei.hmf.tasks.Task<java.lang.Void> unsubscribe(android.content.Context context, java.lang.String str, java.lang.String str2);
}
