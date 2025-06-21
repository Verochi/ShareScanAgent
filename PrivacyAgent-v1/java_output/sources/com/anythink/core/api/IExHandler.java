package com.anythink.core.api;

/* loaded from: classes12.dex */
public interface IExHandler {
    boolean checkDebuggerDevice(android.content.Context context, java.lang.String str);

    int checkDownloadType(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar);

    com.anythink.core.api.ATEventInterface createDownloadListener(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd baseAd, com.anythink.core.api.ATEventInterface aTEventInterface);

    java.lang.String fillCDataParam(java.lang.String str);

    void fillRequestData(org.json.JSONObject jSONObject, com.anythink.core.d.a aVar);

    void fillRequestDeviceData(org.json.JSONObject jSONObject, int i);

    void fillTestDeviceData(org.json.JSONObject jSONObject, com.anythink.core.d.a aVar);

    java.lang.String getAid(android.content.Context context);

    java.lang.String getUniqueId(android.content.Context context);

    void handleOfferClick(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2, java.lang.Runnable runnable, com.anythink.core.common.g.b bVar);

    void initDeviceInfo(android.content.Context context);

    boolean onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback);

    void openApkConfirmDialog(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.core.common.g.a aVar);
}
