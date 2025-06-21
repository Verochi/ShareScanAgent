package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
interface InnerPOFactory {
    com.qq.e.comm.pi.SVSD getAPKDownloadServiceDelegate(android.app.Service service);

    com.qq.e.comm.pi.ACTD getActivityDelegate(java.lang.String str, android.app.Activity activity);

    java.lang.String getBuyerId();

    java.lang.String getBuyerId(java.util.Map<java.lang.String, java.lang.Object> map);

    com.qq.e.comm.pi.DFA getGDTApkDelegate(com.qq.e.ads.dfa.IGDTApkListener iGDTApkListener);

    com.qq.e.comm.pi.HADI getHybridAD(com.qq.e.ads.hybrid.HybridADSetting hybridADSetting, com.qq.e.ads.hybrid.HybridADListener hybridADListener);

    com.qq.e.comm.pi.NUADI getNativeAdManagerDelegate(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    com.qq.e.comm.pi.NEADI getNativeExpressADDelegate(android.content.Context context, com.qq.e.ads.nativ.ADSize aDSize, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    com.qq.e.comm.pi.NSPVI getNativeSplashAdView(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3);

    com.qq.e.comm.pi.RVADI getRewardVideoADDelegate(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    java.lang.String getSDKInfo(java.lang.String str);

    com.qq.e.comm.pi.UBVI getUnifiedBannerViewDelegate(com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView, android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    com.qq.e.comm.pi.UIADI getUnifiedInterstitialADDelegate(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    int showOpenOrInstallAppDialog(com.qq.e.ads.dfa.GDTAppDialogClickListener gDTAppDialogClickListener);

    void start(org.json.JSONObject jSONObject);
}
