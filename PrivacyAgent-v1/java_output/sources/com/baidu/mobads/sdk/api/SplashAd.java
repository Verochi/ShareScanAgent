package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final java.lang.String KEY_BIDFAIL_ADN = "adn";
    public static final java.lang.String KEY_BIDFAIL_ECPM = "ecpm";
    public static final java.lang.String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final java.lang.String KEY_FETCHAD = "fetchAd";
    public static final java.lang.String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final java.lang.String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final java.lang.String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final java.lang.String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final java.lang.String KEY_TIMEOUT = "timeout";
    public static final java.lang.String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final java.lang.String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final java.lang.String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private java.lang.String mAdPlaceId;
    private com.baidu.mobads.sdk.internal.di mAdProd;
    private java.lang.String mAppSid;
    private int mBidFloor;
    private android.content.Context mContext;
    private java.lang.Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private java.lang.Boolean mLimitRegionClick;
    private com.baidu.mobads.sdk.api.SplashAdListener mListener;
    private com.baidu.mobads.sdk.api.RequestParameters mParameter;
    private java.lang.Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    protected int mTwistBgColor;
    protected int mTwistLogoHeightDp;
    private android.view.ViewGroup mViewParent;

    /* renamed from: com.baidu.mobads.sdk.api.SplashAd$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.api.SplashInteractionListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(java.lang.String str) {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.SplashAd$2, reason: invalid class name */
    class AnonymousClass2 implements com.baidu.mobads.sdk.internal.cr.a {
        private boolean mIsFirstOnLayout = true;
        final /* synthetic */ com.baidu.mobads.sdk.internal.cr val$splashAdView;

        public AnonymousClass2(com.baidu.mobads.sdk.internal.cr crVar) {
            this.val$splashAdView = crVar;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(motionEvent);
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onAttachedToWindow() {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.n();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onDetachedFromWindow() {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.o();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
            return false;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onLayoutComplete(int i, int i2) {
            if (this.mIsFirstOnLayout) {
                if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd == null) {
                    com.baidu.mobads.sdk.api.SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                    return;
                }
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.u = false;
                com.baidu.mobads.sdk.api.SplashAd.this.mFetchNotShow = false;
                this.mIsFirstOnLayout = false;
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(this.val$splashAdView);
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.e();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowFocusChanged(boolean z) {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(z);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowVisibilityChanged(int i) {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.b(i);
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.SplashAd$3, reason: invalid class name */
    class AnonymousClass3 implements com.baidu.mobads.sdk.internal.cr.a {
        final /* synthetic */ com.baidu.mobads.sdk.internal.cr val$prodContainer;

        public AnonymousClass3(com.baidu.mobads.sdk.internal.cr crVar) {
            this.val$prodContainer = crVar;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(motionEvent);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onAttachedToWindow() {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.n();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onDetachedFromWindow() {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.o();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
            return false;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onLayoutComplete(int i, int i2) {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                return;
            }
            float e = com.baidu.mobads.sdk.internal.ba.e(com.baidu.mobads.sdk.api.SplashAd.this.mContext);
            if (com.baidu.mobads.sdk.api.SplashAd.this.mParameter != null && com.baidu.mobads.sdk.api.SplashAd.this.mParameter.isCustomSize()) {
                if (com.baidu.mobads.sdk.api.SplashAd.this.mParameter.getWidth() > 0) {
                    i = (int) (com.baidu.mobads.sdk.api.SplashAd.this.mParameter.getWidth() * e);
                }
                if (com.baidu.mobads.sdk.api.SplashAd.this.mParameter.getHeight() > 0) {
                    i2 = (int) (com.baidu.mobads.sdk.api.SplashAd.this.mParameter.getHeight() * e);
                }
            }
            int i3 = i;
            int i4 = i2;
            if (i3 < 200.0f * e || i4 < e * 150.0f) {
                com.baidu.mobads.sdk.internal.bt.a().c(com.baidu.mobads.sdk.internal.dc.a().a(com.baidu.mobads.sdk.internal.bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                if (com.baidu.mobads.sdk.api.SplashAd.this.mListener == null || !(com.baidu.mobads.sdk.api.SplashAd.this.mListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
                    return;
                }
                ((com.baidu.mobads.sdk.api.SplashInteractionListener) com.baidu.mobads.sdk.api.SplashAd.this.mListener).onAdDismissed();
                return;
            }
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd = new com.baidu.mobads.sdk.internal.di(com.baidu.mobads.sdk.api.SplashAd.this.mContext, com.baidu.mobads.sdk.api.SplashAd.this.mAdPlaceId, i3, i4, com.baidu.mobads.sdk.api.SplashAd.this.mTipStyle, com.baidu.mobads.sdk.api.SplashAd.this.mTimeout, com.baidu.mobads.sdk.api.SplashAd.this.mDisplayDownInfo, com.baidu.mobads.sdk.api.SplashAd.this.mPopDialogIfDL.booleanValue(), com.baidu.mobads.sdk.api.SplashAd.this.mDisplayClickRegion.booleanValue(), com.baidu.mobads.sdk.api.SplashAd.this.mLimitRegionClick.booleanValue());
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(this.val$prodContainer);
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.d(com.baidu.mobads.sdk.api.SplashAd.this.mShakeLogoSize);
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(com.baidu.mobads.sdk.api.SplashAd.this.mTwistLogoHeightDp);
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.c(com.baidu.mobads.sdk.api.SplashAd.this.mTwistBgColor);
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.h(com.baidu.mobads.sdk.api.SplashAd.this.mAppSid);
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.r = com.baidu.mobads.sdk.api.SplashAd.this.mBidFloor;
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(com.baidu.mobads.sdk.api.SplashAd.this.mListener);
            if (com.baidu.mobads.sdk.api.SplashAd.this.mParameter != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(com.baidu.mobads.sdk.api.SplashAd.this.mParameter);
            }
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.u = false;
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(com.baidu.mobads.sdk.api.SplashAd.this.mDownloadDialogListener);
            com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a();
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowFocusChanged(boolean z) {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.a(z);
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowVisibilityChanged(int i) {
            if (com.baidu.mobads.sdk.api.SplashAd.this.mAdProd != null) {
                com.baidu.mobads.sdk.api.SplashAd.this.mAdProd.b(i);
            }
        }
    }

    public interface OnFinishListener {
        void onFinishActivity();
    }

    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = java.lang.Boolean.FALSE;
        java.lang.Boolean bool = java.lang.Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = 4200;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new com.baidu.mobads.sdk.api.SplashAd.AnonymousClass1();
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        java.lang.String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!android.text.TextUtils.isEmpty(str2)) {
            this.mFetchAd = java.lang.Boolean.parseBoolean(str2);
        }
        java.lang.String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!android.text.TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = java.lang.Boolean.parseBoolean(str3);
        }
        java.lang.String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!android.text.TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = java.lang.Boolean.valueOf(str4);
        }
        java.lang.String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!android.text.TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = java.lang.Integer.parseInt(str5);
        }
        java.lang.String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
        if (!android.text.TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = java.lang.Integer.parseInt(str6);
        }
        java.lang.String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
        if (!android.text.TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = java.lang.Integer.parseInt(str7);
        }
        java.lang.String str8 = this.mParameter.getExtras().get("timeout");
        if (!android.text.TextUtils.isEmpty(str8)) {
            this.mTimeout = java.lang.Integer.parseInt(str8);
        }
        java.lang.String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (android.text.TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = java.lang.Boolean.parseBoolean(str9);
    }

    public SplashAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(android.view.ViewGroup viewGroup, android.content.Context context) {
        try {
            viewGroup.addView(new android.view.SurfaceView(context), new android.widget.RelativeLayout.LayoutParams(0, 0));
        } catch (java.lang.Exception e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(java.lang.String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    @java.lang.Deprecated
    public static void registerEnterTransition(android.app.Activity activity, int i, int i2, int i3, com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
            jSONObject.put("anim_offset_y", i3);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        com.baidu.mobads.sdk.internal.di.a(activity, jSONObject, splashFocusAdListener);
    }

    public static void registerEnterTransition(android.app.Activity activity, int i, int i2, com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("right_margin", i);
            jSONObject.put("bottom_margin", i2);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        com.baidu.mobads.sdk.internal.di.a(activity, jSONObject, splashFocusAdListener);
    }

    public static void registerEnterTransition(android.app.Activity activity, com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener) {
        com.baidu.mobads.sdk.internal.di.a(activity, (org.json.JSONObject) null, splashFocusAdListener);
    }

    public static void registerEnterTransition(android.app.Activity activity, com.baidu.mobads.sdk.api.SplashFocusParams splashFocusParams, com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener) {
        com.baidu.mobads.sdk.internal.di.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(java.lang.String str) {
        try {
            com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
            if (diVar != null) {
                diVar.a(str);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void sendSplashLog(android.view.ViewGroup viewGroup, android.view.View view) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            boolean z = true;
            sb.append(viewGroup == null);
            sb.append("");
            hashMap.put("adContainer", sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            if (!this.mIsAdaptiveSplashAd || view != null) {
                z = false;
            }
            sb2.append(z);
            sb2.append("");
            hashMap.put("isAdaptive", sb2.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (org.json.JSONException e) {
                    com.baidu.mobads.sdk.internal.bt.a().a(e);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setAppLogo(java.lang.Object obj) {
        if (this.mAdProd != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "splash_logo");
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i) {
        setAppLogo(java.lang.Integer.valueOf(i));
    }

    private final void showWithBottomView(android.view.ViewGroup viewGroup, android.view.View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        if (!this.mFetchNotShow) {
            com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
            if (diVar != null) {
                diVar.r();
            }
            callAdFailed("展现失败，请重新load");
            return;
        }
        this.mFetchNotShow = false;
        com.baidu.mobads.sdk.internal.di diVar2 = this.mAdProd;
        if (diVar2 == null) {
            if (diVar2 != null) {
                diVar2.r();
            }
            callAdFailed("展现失败，请检查splashAd参数是否正确");
            return;
        }
        com.baidu.mobads.sdk.internal.cr crVar = new com.baidu.mobads.sdk.internal.cr(this.mContext);
        crVar.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        if (view != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            view.setId(4097);
            crVar.addView(view, layoutParams);
        }
        crVar.a(new com.baidu.mobads.sdk.api.SplashAd.AnonymousClass2(crVar));
        this.mViewParent.addView(crVar);
    }

    public void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void destroy() {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.p();
        }
        this.mListener = null;
    }

    public void finishAndJump(android.content.Intent intent) {
        finishAndJump(intent, null);
    }

    public void finishAndJump(android.content.Intent intent, com.baidu.mobads.sdk.api.SplashAd.OnFinishListener onFinishListener) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(intent, onFinishListener);
        }
    }

    public java.lang.Object getAdDataForKey(java.lang.String str) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.j(str);
        }
        return null;
    }

    public java.lang.String getBiddingToken() {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.r();
            this.mAdProd = null;
        }
        float e = com.baidu.mobads.sdk.internal.ba.e(this.mContext);
        android.graphics.Rect a = com.baidu.mobads.sdk.internal.ba.a(this.mContext);
        int width = a.width();
        int height = a.height();
        com.baidu.mobads.sdk.api.RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 < 200.0f * e || i < e * 150.0f) {
            com.baidu.mobads.sdk.internal.bt.a().c(com.baidu.mobads.sdk.internal.dc.a().a(com.baidu.mobads.sdk.internal.bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null && (splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
                ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdDismissed();
            }
            return null;
        }
        com.baidu.mobads.sdk.internal.di diVar2 = new com.baidu.mobads.sdk.internal.di(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = diVar2;
        diVar2.d(this.mShakeLogoSize);
        this.mAdProd.a(this.mTwistLogoHeightDp);
        this.mAdProd.c(this.mTwistBgColor);
        this.mAdProd.h(this.mAppSid);
        com.baidu.mobads.sdk.internal.di diVar3 = this.mAdProd;
        diVar3.r = this.mBidFloor;
        diVar3.u = true;
        com.baidu.mobads.sdk.api.RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            diVar3.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        return this.mAdProd.l();
    }

    public java.lang.String getECPMLevel() {
        com.baidu.mobads.sdk.internal.a g;
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        return (diVar == null || (g = diVar.g()) == null) ? "" : g.z();
    }

    public java.lang.String getPECPM() {
        com.baidu.mobads.sdk.internal.a g;
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        return (diVar == null || (g = diVar.g()) == null) ? "" : g.A();
    }

    public final boolean hasSplashCardView() {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.f();
        }
        return false;
    }

    public boolean isReady() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener;
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar == null || (iAdInterListener = diVar.m) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.r();
            this.mAdProd = null;
        }
        float e = com.baidu.mobads.sdk.internal.ba.e(this.mContext);
        android.graphics.Rect a = com.baidu.mobads.sdk.internal.ba.a(this.mContext);
        int width = a.width();
        int height = a.height();
        com.baidu.mobads.sdk.api.RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e);
            }
        }
        int i = height;
        int i2 = width;
        if (i2 < 200.0f * e || i < e * 150.0f) {
            com.baidu.mobads.sdk.internal.bt.a().c(com.baidu.mobads.sdk.internal.dc.a().a(com.baidu.mobads.sdk.internal.bp.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener == null || !(splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
                return;
            }
            ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdDismissed();
            return;
        }
        com.baidu.mobads.sdk.internal.di diVar2 = new com.baidu.mobads.sdk.internal.di(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = diVar2;
        diVar2.d(this.mShakeLogoSize);
        this.mAdProd.a(this.mTwistLogoHeightDp);
        this.mAdProd.c(this.mTwistBgColor);
        this.mAdProd.h(this.mAppSid);
        com.baidu.mobads.sdk.internal.di diVar3 = this.mAdProd;
        diVar3.r = this.mBidFloor;
        diVar3.u = true;
        com.baidu.mobads.sdk.api.RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            diVar3.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        this.mAdProd.a();
    }

    public void loadAndShow(android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
        com.baidu.mobads.sdk.internal.cr crVar = new com.baidu.mobads.sdk.internal.cr(this.mContext);
        crVar.a(new com.baidu.mobads.sdk.api.SplashAd.AnonymousClass3(crVar));
        crVar.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(crVar);
    }

    public void loadBiddingAd(java.lang.String str) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.c(str);
        }
    }

    public void setAppSid(java.lang.String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    @java.lang.Deprecated
    public void setBiddingData(java.lang.String str) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.b(str);
        }
    }

    public void setDownloadDialogListener(com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(com.baidu.mobads.sdk.api.SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(splashAdListener);
        }
    }

    public final void show(android.view.ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public final boolean showSplashCardView(android.app.Activity activity, com.baidu.mobads.sdk.api.SplashAd.SplashCardAdListener splashCardAdListener) {
        com.baidu.mobads.sdk.internal.di diVar = this.mAdProd;
        if (diVar == null) {
            return false;
        }
        diVar.a(splashCardAdListener);
        return this.mAdProd.b(activity);
    }
}
