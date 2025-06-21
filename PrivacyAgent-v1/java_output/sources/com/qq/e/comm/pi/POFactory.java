package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface POFactory extends com.qq.e.comm.pi.InnerPOFactory {
    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.SVSD getAPKDownloadServiceDelegate(android.app.Service service);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.ACTD getActivityDelegate(java.lang.String str, android.app.Activity activity);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ java.lang.String getBuyerId(java.util.Map<java.lang.String, java.lang.Object> map);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.DFA getGDTApkDelegate(com.qq.e.ads.dfa.IGDTApkListener iGDTApkListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.HADI getHybridAD(com.qq.e.ads.hybrid.HybridADSetting hybridADSetting, com.qq.e.ads.hybrid.HybridADListener hybridADListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.NUADI getNativeAdManagerDelegate(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.NEADI getNativeExpressADDelegate(android.content.Context context, com.qq.e.ads.nativ.ADSize aDSize, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.NSPVI getNativeSplashAdView(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.RVADI getRewardVideoADDelegate(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ java.lang.String getSDKInfo(java.lang.String str);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.UBVI getUnifiedBannerViewDelegate(com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView, android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ com.qq.e.comm.pi.UIADI getUnifiedInterstitialADDelegate(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ int showOpenOrInstallAppDialog(com.qq.e.ads.dfa.GDTAppDialogClickListener gDTAppDialogClickListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ void start(org.json.JSONObject jSONObject);
}
