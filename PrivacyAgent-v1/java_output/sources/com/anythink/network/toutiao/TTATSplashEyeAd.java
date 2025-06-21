package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATSplashEyeAd extends com.anythink.splashad.unitgroup.api.CustomSplashEyeAd {
    com.bytedance.sdk.openadsdk.CSJSplashAd a;

    public TTATSplashEyeAd(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
        super(aTBaseAdAdapter);
        this.a = cSJSplashAd;
    }

    private static int a(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
        this.a = null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(android.content.Context context) {
        int[] splashClickEyeSizeToDp;
        com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd = this.a;
        if (cSJSplashAd == null || context == null || (splashClickEyeSizeToDp = cSJSplashAd.getSplashClickEyeSizeToDp()) == null || splashClickEyeSizeToDp.length < 2) {
            return null;
        }
        return new int[]{a(context, splashClickEyeSizeToDp[0]), a(context, splashClickEyeSizeToDp[1])};
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        android.view.ViewGroup viewGroup;
        com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd = this.a;
        if (cSJSplashAd == null || (viewGroup = this.mEyeAdContainer) == null) {
            return;
        }
        cSJSplashAd.showSplashClickEyeView(viewGroup);
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void show(android.content.Context context, android.graphics.Rect rect) {
        try {
            if (this.mEyeAdContainer == null) {
                com.anythink.splashad.api.ATSplashEyeAdListener aTSplashEyeAdListener = this.mATSplashEyeAdListener;
                if (aTSplashEyeAdListener != null) {
                    aTSplashEyeAdListener.onAdDismiss(false, "mEyeAdContainer = null");
                    return;
                }
                return;
            }
            com.anythink.splashad.api.ATSplashEyeAdListener aTSplashEyeAdListener2 = this.mATSplashEyeAdListener;
            if (aTSplashEyeAdListener2 != null) {
                aTSplashEyeAdListener2.onAnimationStart(this.mSplashView);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
