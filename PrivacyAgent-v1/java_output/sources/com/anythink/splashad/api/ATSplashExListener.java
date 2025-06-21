package com.anythink.splashad.api;

/* loaded from: classes12.dex */
public interface ATSplashExListener extends com.anythink.splashad.api.ATSplashAdListener {
    void onDeeplinkCallback(com.anythink.core.api.ATAdInfo aTAdInfo, boolean z);

    void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
