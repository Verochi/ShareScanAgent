package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class ExpressInterstitialAd {
    private com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterstitialAdDislikeListener mAdDislikeListener;
    private java.lang.String mAdPlaceId;
    private java.lang.String mAppsid;
    private int mBidFloor;
    private android.content.Context mContext;
    private com.baidu.mobads.sdk.api.ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private long mLoadTime;
    private com.baidu.mobads.sdk.internal.dd mNativeInterstitialAdProd;
    private com.baidu.mobads.sdk.api.RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* renamed from: com.baidu.mobads.sdk.api.ExpressInterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.internal.cr.a {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            com.baidu.mobads.sdk.api.ExpressInterstitialAd.this.mNativeInterstitialAdProd.a(motionEvent);
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onAttachedToWindow() {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        @android.annotation.SuppressLint({"MissingSuperCall"})
        public void onDetachedFromWindow() {
            if (com.baidu.mobads.sdk.api.ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                com.baidu.mobads.sdk.api.ExpressInterstitialAd.this.mNativeInterstitialAdProd.o();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
            return i == 4;
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onLayoutComplete(int i, int i2) {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowFocusChanged(boolean z) {
        }

        @Override // com.baidu.mobads.sdk.internal.cr.a
        public void onWindowVisibilityChanged(int i) {
        }
    }

    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(android.content.Context context, java.lang.String str) {
        this(context, str, 500, 600);
    }

    public ExpressInterstitialAd(android.content.Context context, java.lang.String str, int i, int i2) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i;
        this.mHeight = i2;
    }

    private void initNativeInterstitialAdProd() {
        java.lang.System.currentTimeMillis();
        com.baidu.mobads.sdk.internal.cr crVar = new com.baidu.mobads.sdk.internal.cr(this.mContext);
        crVar.a(new com.baidu.mobads.sdk.api.ExpressInterstitialAd.AnonymousClass1());
        this.mNativeInterstitialAdProd = new com.baidu.mobads.sdk.internal.dd(this.mContext, crVar, this.mAdPlaceId);
        if (!android.text.TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.q = this.mAppsid;
        }
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        ddVar.r = this.mBidFloor;
        ddVar.t = this.onlyFetchAd;
        ddVar.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
        com.baidu.mobads.sdk.api.RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    public void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void destroy() {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null) {
            return;
        }
        ddVar.p();
    }

    public java.lang.Object getAdDataForKey(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            return ddVar.a(str);
        }
        return null;
    }

    public java.lang.String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.l();
    }

    public java.lang.String getECPMLevel() {
        com.baidu.mobads.sdk.internal.a x;
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        return (ddVar == null || (x = ddVar.x()) == null) ? "" : x.z();
    }

    public java.lang.String getPECPM() {
        com.baidu.mobads.sdk.internal.a x;
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        return (ddVar == null || (x = ddVar.x()) == null) ? "" : x.A();
    }

    public boolean isReady() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener;
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null || (iAdInterListener = ddVar.m) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        this.mLoadTime = java.lang.System.currentTimeMillis();
        if (this.mContext == null) {
            com.baidu.mobads.sdk.internal.ay.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void loadBiddingAd(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.c(str);
        }
    }

    public void setAdDislikeListener(com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(java.lang.String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    @java.lang.Deprecated
    public void setBiddingData(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.b(str);
        }
    }

    public void setDialogFrame(boolean z) {
        this.mUseDialogFrame = z;
    }

    public void setDownloadListener(com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar != null) {
            ddVar.a(expressInterstitialListener);
        }
    }

    public void setRequestParameters(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void show() {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null) {
            return;
        }
        if (ddVar.f()) {
            this.mNativeInterstitialAdProd.g();
        } else {
            this.mNativeInterstitialAdProd.f((com.baidu.mobads.sdk.api.IOAdEvent) null);
        }
    }

    public void show(android.app.Activity activity) {
        com.baidu.mobads.sdk.internal.dd ddVar = this.mNativeInterstitialAdProd;
        if (ddVar == null) {
            return;
        }
        ddVar.a(activity);
        show();
    }

    public void useUseDialogContainer(boolean z) {
        this.mUseDialogContainer = z;
    }
}
