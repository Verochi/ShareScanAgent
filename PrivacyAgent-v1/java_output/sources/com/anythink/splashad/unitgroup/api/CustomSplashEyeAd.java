package com.anythink.splashad.unitgroup.api;

/* loaded from: classes12.dex */
public abstract class CustomSplashEyeAd implements com.anythink.splashad.api.IATSplashEyeAd {
    protected com.anythink.splashad.api.ATSplashEyeAdListener mATSplashEyeAdListener;
    protected com.anythink.core.api.ATBaseAdAdapter mAtBaseAdAdapter;
    protected android.view.ViewGroup mEyeAdContainer;
    protected android.view.View mSplashView;

    public CustomSplashEyeAd(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        this.mAtBaseAdAdapter = aTBaseAdAdapter;
    }

    public abstract void customResourceDestory();

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public final void destroy() {
        try {
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mAtBaseAdAdapter;
            if (aTBaseAdAdapter != null) {
                if (aTBaseAdAdapter instanceof com.anythink.splashad.unitgroup.api.CustomSplashAdapter) {
                    ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) aTBaseAdAdapter).cleanImpressionListener();
                }
                this.mAtBaseAdAdapter.internalDestory();
                this.mAtBaseAdAdapter = null;
            }
            this.mATSplashEyeAdListener = null;
            android.view.View view = this.mSplashView;
            if (view != null) {
                if (view.getParent() != null) {
                    ((android.view.ViewGroup) this.mSplashView.getParent()).removeView(this.mSplashView);
                }
                this.mSplashView = null;
            }
            android.view.ViewGroup viewGroup = this.mEyeAdContainer;
            if (viewGroup != null) {
                if (viewGroup.getParent() != null) {
                    ((android.view.ViewGroup) this.mEyeAdContainer.getParent()).removeView(this.mEyeAdContainer);
                }
                this.mEyeAdContainer = null;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        try {
            customResourceDestory();
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public com.anythink.splashad.api.ATSplashEyeAdListener getSplashEyeAdListener() {
        return this.mATSplashEyeAdListener;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void setEyeAdContainer(android.view.ViewGroup viewGroup) {
        this.mEyeAdContainer = viewGroup;
    }

    public void setSplashView(android.view.View view) {
        this.mSplashView = view;
    }

    public abstract void show(android.content.Context context, android.graphics.Rect rect);

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public final void show(android.content.Context context, android.graphics.Rect rect, com.anythink.splashad.api.ATSplashEyeAdListener aTSplashEyeAdListener) {
        this.mATSplashEyeAdListener = aTSplashEyeAdListener;
        show(context, rect);
    }
}
