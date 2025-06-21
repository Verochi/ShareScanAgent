package com.anythink.splashad.unitgroup.api;

/* loaded from: classes12.dex */
public abstract class CustomSplashAdapter extends com.anythink.core.api.ATBaseAdAdapter {
    com.anythink.splashad.api.ATSplashSkipInfo mATSplashSkipInfo;
    protected com.anythink.splashad.unitgroup.api.CustomSplashEventListener mImpressionListener;

    /* renamed from: com.anythink.splashad.unitgroup.api.CustomSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.splashad.unitgroup.api.CustomSplashEventListener {
        final /* synthetic */ com.anythink.core.api.ATCommonImpressionListener val$atCommonImpressionListener;

        public AnonymousClass1(com.anythink.core.api.ATCommonImpressionListener aTCommonImpressionListener) {
            this.val$atCommonImpressionListener = aTCommonImpressionListener;
        }

        @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
        public final void onDeeplinkCallback(boolean z) {
            this.val$atCommonImpressionListener.onDeeplinkCallback(z);
        }

        @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
        public final void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            this.val$atCommonImpressionListener.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }

        @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
        public final void onSplashAdClicked() {
            this.val$atCommonImpressionListener.onAdClick();
        }

        @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
        public final void onSplashAdDismiss() {
            this.val$atCommonImpressionListener.onAdDismiss();
        }

        @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
        public final void onSplashAdShow() {
            this.val$atCommonImpressionListener.onAdImpression();
        }

        @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
        public final void onSplashAdShowFail(com.anythink.core.api.AdError adError) {
            this.val$atCommonImpressionListener.onAdShowFail(adError.getPlatformCode(), adError.getPlatformMSG());
        }
    }

    public final void cleanImpressionListener() {
    }

    public com.anythink.splashad.api.IATSplashEyeAd getSplashEyeAd() {
        return null;
    }

    public final com.anythink.splashad.api.ATSplashSkipInfo getSplashSkipInfo() {
        return this.mATSplashSkipInfo;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final void internalFormatShow(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.core.api.ATCommonImpressionListener aTCommonImpressionListener) {
        this.mImpressionListener = new com.anythink.splashad.unitgroup.api.CustomSplashAdapter.AnonymousClass1(aTCommonImpressionListener);
        show(activity, viewGroup);
    }

    public final boolean isCustomSkipView() {
        com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo = this.mATSplashSkipInfo;
        if (aTSplashSkipInfo != null) {
            return aTSplashSkipInfo.canUseCustomSkipView();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final boolean isMixFormatAd() {
        int i = this.mMixedFormatAdType;
        return (i == -1 || i == 4) ? false : true;
    }

    public boolean isSupportCustomSkipView() {
        return getMixedFormatAdType() == 0;
    }

    public final void setSplashSkipInfo(com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo) {
        this.mATSplashSkipInfo = aTSplashSkipInfo;
    }

    public abstract void show(android.app.Activity activity, android.view.ViewGroup viewGroup);

    public void startSplashCustomSkipViewClickEye() {
    }
}
