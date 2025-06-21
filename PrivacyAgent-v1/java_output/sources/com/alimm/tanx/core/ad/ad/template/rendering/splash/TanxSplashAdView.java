package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public class TanxSplashAdView extends com.alimm.tanx.core.ad.view.TanxAdView {
    private static final java.lang.String TAG = "TanxSplashAdView";
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd;
    private android.widget.ImageView ivAd;
    private android.app.Activity mActivity;
    private com.alimm.tanx.core.ad.bean.AdInfo mAdInfo;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do mAdRenderer;
    private boolean mIsColdStart;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback mRenderCallback;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.View tanxc_do;

        public AnonymousClass1(android.view.View view) {
            this.tanxc_do = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.tanxc_do.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public TanxSplashAdView(android.app.Activity activity) {
        this(activity, null);
    }

    public TanxSplashAdView(android.app.Activity activity, android.util.AttributeSet attributeSet) {
        super(activity, attributeSet);
        this.mIsColdStart = true;
        try {
            this.mActivity = activity;
            android.view.View inflate = android.view.LayoutInflater.from(activity).inflate(com.alimm.tanx.core.R.layout.xadsdk_new_layout_dialog_splash_ad, (android.view.ViewGroup) this, true);
            inflate.getViewTreeObserver().addOnGlobalLayoutListener(new com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView.AnonymousClass1(inflate));
            android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.xadsdk_splash_ad_image_view);
            this.ivAd = imageView;
            imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), e);
        }
    }

    private void createAndStartRender(@androidx.annotation.NonNull com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        if (this.mAdRenderer != null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "createAndStartRender: has created render = " + this.mAdRenderer);
            return;
        }
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for tanxc_forVar = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for(this.mRenderCallback, this.mActivity, this, this.iTanxSplashExpressAd, this.mIsColdStart);
        this.mAdRenderer = tanxc_forVar;
        tanxc_forVar.tanxc_do(this.iTanxSplashExpressAd);
        if (this.mAdRenderer != null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "0830_splash: ======= createAndStartRender ======" + java.lang.System.currentTimeMillis());
            this.mAdRenderer.tanxc_do();
        }
    }

    public android.view.View getClickView() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_goto();
        }
        return null;
    }

    public android.view.View getCloseView() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_this();
        }
        return null;
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback getRenderCallback() {
        return this.mRenderCallback;
    }

    public com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd getTanxSplashExpressAd() {
        return this.iTanxSplashExpressAd;
    }

    public void notifyViewClick() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_break();
        }
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void pauseTimer() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_try();
        }
    }

    public void removeAdView() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_case();
            this.mAdRenderer = null;
        }
    }

    public void resumeTimer() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_byte();
        }
    }

    public void setITanxSplashInteractionListener(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar = this.mAdRenderer;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(iTanxSplashInteractionListener);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "mAdRenderer为空，设置监听失败setiTanxSplashInteractionListener失败");
        }
    }

    public void setRenderCallback(com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback iRenderCallback) {
        this.mRenderCallback = iRenderCallback;
    }

    public void setTanxSplashExpressAd(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd) {
        this.iTanxSplashExpressAd = iTanxSplashExpressAd;
    }

    public void startShow(com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        android.app.Activity activity;
        try {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "startShow" + bidInfo);
            if (bidInfo != null) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "startShow" + bidInfo.getCreativePath());
                createAndStartRender(bidInfo);
            } else {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "startShow bidInfo为空");
            }
            if (this.mIsColdStart || (activity = this.mActivity) == null || !(activity instanceof android.app.Activity) || activity.getResources().getConfiguration().orientation != 2) {
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "change screen orientation to portrait");
            this.mActivity.setRequestedOrientation(1);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            e.printStackTrace();
        }
    }
}
