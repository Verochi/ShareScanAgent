package com.anythink.splashad.unitgroup.api;

/* loaded from: classes12.dex */
public interface CustomSplashEventListener {
    void onDeeplinkCallback(boolean z);

    void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo);

    void onSplashAdClicked();

    void onSplashAdDismiss();

    void onSplashAdShow();

    void onSplashAdShowFail(com.anythink.core.api.AdError adError);
}
