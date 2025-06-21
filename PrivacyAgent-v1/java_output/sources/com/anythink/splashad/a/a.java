package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public abstract class a {
    boolean mHasDismiss;

    public abstract void onAdClick(com.anythink.core.api.ATAdInfo aTAdInfo);

    public abstract void onAdDismiss(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.splashad.api.ATSplashAdExtraInfo aTSplashAdExtraInfo);

    public abstract void onAdShow(com.anythink.core.api.ATAdInfo aTAdInfo);

    public void onCallbackAdDismiss(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.splashad.api.ATSplashAdExtraInfo aTSplashAdExtraInfo) {
        if (this.mHasDismiss) {
            return;
        }
        this.mHasDismiss = true;
        onAdDismiss(aTAdInfo, aTSplashAdExtraInfo);
    }

    public abstract void onDeeplinkCallback(com.anythink.core.api.ATAdInfo aTAdInfo, boolean z);

    public abstract void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
