package com.qq.e.comm.managers;

/* loaded from: classes19.dex */
public interface IGDTAdManager {
    java.lang.String getBuyerId(java.util.Map<java.lang.String, java.lang.Object> map);

    com.qq.e.comm.managers.devtool.DevTools getDevTools();

    java.lang.String getSDKInfo(java.lang.String str);

    int showOpenOrInstallAppDialog(com.qq.e.ads.dfa.GDTAppDialogClickListener gDTAppDialogClickListener);
}
