package com.tencent.mm.opensdk.openapi;

/* loaded from: classes19.dex */
public interface IWXAPI {
    void detach();

    int getWXAppSupportAPI();

    boolean handleIntent(android.content.Intent intent, com.tencent.mm.opensdk.openapi.IWXAPIEventHandler iWXAPIEventHandler);

    boolean isWXAppInstalled();

    boolean openWXApp();

    boolean registerApp(java.lang.String str);

    boolean registerApp(java.lang.String str, long j);

    boolean sendReq(com.tencent.mm.opensdk.modelbase.BaseReq baseReq);

    boolean sendResp(com.tencent.mm.opensdk.modelbase.BaseResp baseResp);

    void setLogImpl(com.tencent.mm.opensdk.utils.ILog iLog);

    void unregisterApp();
}
