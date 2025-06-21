package com.anythink.core.api;

/* loaded from: classes12.dex */
public interface ATCommonImpressionListener {
    void onAdClick();

    void onAdDismiss();

    void onAdImpression();

    void onAdReward();

    void onAdShowFail(java.lang.String str, java.lang.String str2);

    void onAdVideoPlayEnd();

    void onAdVideoPlayStart();

    void onDeeplinkCallback(boolean z);

    void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
