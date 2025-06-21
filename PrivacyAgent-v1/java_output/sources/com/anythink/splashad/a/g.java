package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public final class g implements com.anythink.core.api.ATCommonImpressionListener {
    com.anythink.splashad.a.h a;

    public g(com.anythink.splashad.a.h hVar) {
        this.a = hVar;
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdClick() {
        com.anythink.splashad.a.h hVar = this.a;
        if (hVar != null) {
            hVar.onSplashAdClicked();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdDismiss() {
        com.anythink.splashad.a.h hVar = this.a;
        if (hVar != null) {
            hVar.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdImpression() {
        com.anythink.splashad.a.h hVar = this.a;
        if (hVar != null) {
            hVar.onSplashAdShow();
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdReward() {
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdShowFail(java.lang.String str, java.lang.String str2) {
        com.anythink.splashad.a.h hVar = this.a;
        if (hVar != null) {
            hVar.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, str, str2));
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdVideoPlayEnd() {
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onAdVideoPlayStart() {
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onDeeplinkCallback(boolean z) {
        com.anythink.splashad.a.h hVar = this.a;
        if (hVar != null) {
            hVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public final void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        com.anythink.splashad.a.h hVar = this.a;
        if (hVar != null) {
            hVar.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }
}
