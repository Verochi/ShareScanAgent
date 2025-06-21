package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class XAdNativeResponse implements com.baidu.mobads.sdk.api.NativeResponse {
    private static final java.lang.String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private com.baidu.mobads.sdk.api.NativeResponse.AdCloseListener mAdCloseListener;
    private com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener mAdDislikeListener;
    private com.baidu.mobads.sdk.internal.a mAdInstanceInfo;
    private com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener mAdInteractionListener;
    private com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener mAdShakeViewListener;
    private com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener mCouponFloatViewListener;
    private com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    private android.content.Context mCxt;
    private com.baidu.mobads.sdk.internal.de mFeedsProd;
    private java.lang.String mNoAdUniqueId;
    private com.baidu.mobads.sdk.internal.cq mUriUtils;

    public static class DislikeInfo implements com.baidu.mobads.sdk.api.DislikeEvent {
        private java.lang.String dislikeName;
        private int dislikeType;

        private DislikeInfo() {
        }

        public /* synthetic */ DislikeInfo(com.baidu.mobads.sdk.api.XAdNativeResponse.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public java.lang.String getDislikeName() {
            return this.dislikeName;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            return this.dislikeType;
        }
    }

    public XAdNativeResponse(android.content.Context context, com.baidu.mobads.sdk.internal.de deVar, com.baidu.mobads.sdk.internal.a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = deVar;
        if (aVar != null && aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = com.baidu.mobads.sdk.internal.cq.a();
    }

    private int getActionType() {
        return this.mAdInstanceInfo.p();
    }

    private com.baidu.mobads.sdk.api.IAdInterListener getAdInterListener() {
        com.baidu.mobads.sdk.internal.de deVar = this.mFeedsProd;
        if (deVar != null) {
            return deVar.m;
        }
        return null;
    }

    private java.lang.String getProd() {
        com.baidu.mobads.sdk.internal.de deVar = this.mFeedsProd;
        return deVar != null ? deVar.e() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        if (this.mFeedsProd != null) {
            java.lang.String str = this.mNoAdUniqueId;
            com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                str = aVar.I();
            }
            this.mFeedsProd.a(str, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.de deVar;
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null || (deVar = this.mFeedsProd) == null) {
            return;
        }
        deVar.a(aVar.I(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        org.json.JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("pk", getAppPackage());
            U.put("msg", "cancelDownload");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        com.baidu.mobads.sdk.internal.de deVar = this.mFeedsProd;
        if (deVar != null) {
            deVar.o();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(com.baidu.mobads.sdk.api.DislikeEvent dislikeEvent) {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null || !(dislikeEvent instanceof com.baidu.mobads.sdk.api.XAdNativeResponse.DislikeInfo)) {
            return;
        }
        org.json.JSONObject U = aVar.U();
        try {
            U.put("dislike_type", dislikeEvent.getDislikeType());
            U.put("msg", "dislike_click");
        } catch (java.lang.Exception unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        java.lang.String E = aVar.E();
        org.json.JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("function_link", E);
            U.put("msg", "functionClick");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getActButtonString() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return "";
        }
        org.json.JSONObject U = aVar.U();
        try {
            U.put("msg", "creative_call");
            U.put("creative_type", "cta_get");
        } catch (java.lang.Exception unused) {
        }
        this.mFeedsProd.a(U);
        return this.mAdInstanceInfo.N();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        return this.mAdActionType;
    }

    public com.baidu.mobads.sdk.api.NativeResponse.AdCloseListener getAdCloseListener() {
        return this.mAdCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.Object getAdDataForKey(java.lang.String str) {
        if (this.mAdInstanceInfo != null) {
            return "request_id".equals(str) ? this.mAdInstanceInfo.V() : "dp_id".equals(str) ? this.mAdInstanceInfo.W() : this.mAdInstanceInfo.a(str);
        }
        return null;
    }

    public com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAdLogoUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAdMaterialType() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar == null ? com.baidu.mobads.sdk.api.NativeResponse.MaterialType.NORMAL.getValue() : "video".equals(aVar.x()) ? com.baidu.mobads.sdk.api.NativeResponse.MaterialType.VIDEO.getValue() : com.baidu.mobads.sdk.internal.a.f.equals(this.mAdInstanceInfo.x()) ? com.baidu.mobads.sdk.api.NativeResponse.MaterialType.HTML.getValue() : com.baidu.mobads.sdk.api.NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAppFunctionLink() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.E() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAppPackage() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.m() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAppPermissionLink() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.F() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAppPrivacyLink() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.D() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getAppVersion() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getBaiduLogoUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getBrandName() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.g() : "";
    }

    public java.util.List<java.lang.String> getBtnStyleColors() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.P();
        }
        return null;
    }

    public int getBtnStyleType() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.O();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.r();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        com.baidu.mobads.sdk.internal.a aVar;
        if (this.mCustomizeMediaPlayer == null && (aVar = this.mAdInstanceInfo) != null && aVar.T() == 1) {
            this.mCustomizeMediaPlayer = new com.baidu.mobads.sdk.internal.r(this.mFeedsProd, this.mAdInstanceInfo);
        }
        return this.mCustomizeMediaPlayer;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getDesc() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.b() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.util.List<com.baidu.mobads.sdk.api.DislikeEvent> getDislikeList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                java.util.HashMap hashMap = new java.util.HashMap();
                org.json.JSONObject U = this.mAdInstanceInfo.U();
                U.put("msg", "dislike_mapping");
                this.mFeedsProd.a(U, hashMap);
                java.lang.Object obj = hashMap.get("dislike_data");
                if (obj instanceof java.util.Map) {
                    java.util.Map map = (java.util.Map) obj;
                    for (java.lang.String str : map.keySet()) {
                        com.baidu.mobads.sdk.api.XAdNativeResponse.DislikeInfo dislikeInfo = new com.baidu.mobads.sdk.api.XAdNativeResponse.DislikeInfo(null);
                        dislikeInfo.dislikeName = str;
                        dislikeInfo.dislikeType = ((java.lang.Integer) map.get(str)).intValue();
                        arrayList.add(dislikeInfo);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        android.content.Context context;
        if (!this.isDownloadApp || (context = this.mCxt) == null) {
            return -1;
        }
        return com.baidu.mobads.sdk.internal.as.a(context.getApplicationContext()).a(this.mCxt.getApplicationContext(), getAppPackage());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getECPMLevel() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.z() : "";
    }

    public org.json.JSONObject getExtraParams() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.J();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.util.Map<java.lang.String, java.lang.String> getExtras() {
        java.util.HashMap hashMap = new java.util.HashMap();
        com.baidu.mobads.sdk.internal.de deVar = this.mFeedsProd;
        if (deVar != null) {
            hashMap.put("appsid", deVar.q);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getHtmlSnippet() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.o() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getIconUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return "";
        }
        java.lang.String c = aVar.c();
        return android.text.TextUtils.isEmpty(c) ? this.mAdInstanceInfo.d() : c;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getImageUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.d() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public java.lang.String getMarketingDesc() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.L() : "";
    }

    public java.lang.String getMarketingICONUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.K() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getMarketingPendant() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.M() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public com.baidu.mobads.sdk.api.NativeResponse.MaterialType getMaterialType() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar == null ? com.baidu.mobads.sdk.api.NativeResponse.MaterialType.NORMAL : "video".equals(aVar.x()) ? com.baidu.mobads.sdk.api.NativeResponse.MaterialType.VIDEO : com.baidu.mobads.sdk.internal.a.f.equals(this.mAdInstanceInfo.x()) ? com.baidu.mobads.sdk.api.NativeResponse.MaterialType.HTML : com.baidu.mobads.sdk.api.NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.util.List<java.lang.String> getMultiPicUrls() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.H();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getPECPM() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getPublisher() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.C() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.u();
        }
        return 0;
    }

    public java.util.List<java.lang.String> getThirdTrackers(java.lang.String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONObject Q = this.mAdInstanceInfo.Q();
            if (Q != null) {
                java.util.Iterator<java.lang.String> keys = Q.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    if (next.equals(str)) {
                        org.json.JSONArray optJSONArray = Q.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getTitle() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.a() : "";
    }

    public java.lang.String getUniqueId() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.I() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public java.lang.String getVideoUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.n() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public android.webkit.WebView getWebView() {
        com.baidu.mobads.sdk.internal.de deVar = this.mFeedsProd;
        if (deVar != null) {
            return (android.webkit.WebView) deVar.w();
        }
        return null;
    }

    public void handleClick(android.view.View view) {
        handleClick(view, -1);
    }

    public void handleClick(android.view.View view, int i) {
        handleClick(view, i, false);
    }

    public void handleClick(android.view.View view, int i, boolean z) {
        com.baidu.mobads.sdk.internal.a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        org.json.JSONObject U = aVar.U();
        try {
            U.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, i);
            U.put(com.baidu.mobads.sdk.api.SplashAd.KEY_POPDIALOG_DOWNLOAD, z);
            U.put("isDownloadApp", this.isDownloadApp);
        } catch (java.lang.Throwable unused) {
        }
        this.mFeedsProd.b(view, U);
    }

    public void handleClick(android.view.View view, boolean z) {
        handleClick(view, -1, z);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(android.content.Context context) {
        return this.mAdInstanceInfo != null && java.lang.System.currentTimeMillis() - this.mAdInstanceInfo.y() <= this.mAdInstanceInfo.G();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar != null && aVar.k() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        return aVar == null || aVar.l() == 1;
    }

    public int isRegionClick() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.R();
        }
        return 2;
    }

    public int isShowDialog() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.S();
        }
        return 2;
    }

    public void onADExposed() {
        com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i);
        }
    }

    public void onADFunctionClick() {
        com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onADPermissionShow(boolean z) {
        com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onADPrivacyClick() {
        com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADStatusChanged() {
        com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onAdClose(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        com.baidu.mobads.sdk.api.NativeResponse.AdCloseListener adCloseListener = this.mAdCloseListener;
        if (adCloseListener != null) {
            adCloseListener.onAdClose(nativeResponse);
        }
    }

    public void onAdDownloadWindow(boolean z) {
        com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener == null || !(adPrivacyListener instanceof com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener)) {
            return;
        }
        if (z) {
            ((com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
        } else {
            ((com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
        }
    }

    public void onAdUnionClick() {
        com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    public void onCouponFloatDismiss() {
        com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener = this.mCouponFloatViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onDislikeClick(java.lang.String str) {
        com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeItemClick(str);
        }
    }

    public void onDislikeClose() {
        com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeWindowClose();
        }
    }

    public void onDislikeShow() {
        com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeWindowShow();
        }
    }

    public void onShakeViewDismiss() {
        com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener = this.mAdShakeViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        org.json.JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("pk", getAppPackage());
            U.put("msg", "pauseDownload");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        java.lang.String F = aVar.F();
        org.json.JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("permissionUrl", F);
            U.put("msg", "permissionClick");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    public void preloadVideoMaterial() {
        com.baidu.mobads.sdk.internal.a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        org.json.JSONObject U = aVar.U();
        try {
            U.put("msg", "preloadVideoMaterial");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        java.lang.String D = aVar.D();
        org.json.JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("privacy_link", D);
            U.put("msg", "privacyClick");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(android.view.View view) {
        com.baidu.mobads.sdk.internal.a aVar;
        com.baidu.mobads.sdk.internal.de deVar = this.mFeedsProd;
        if (deVar == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        deVar.a(view, aVar.U());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(android.view.View view, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener) {
        this.mAdInteractionListener = adInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().c(TAG, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public android.view.View renderBulletView(int i, int i2) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put("h", i2);
            return renderNativeView("native_bullet_view", jSONObject);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "renderBulletView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public android.view.View renderCouponFloatView(com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mCouponFloatViewListener = adShakeViewListener;
            return renderNativeView("native_coupon_float_icon", new org.json.JSONObject());
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "renderCouponFloatView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public android.view.View renderFlipPageView() {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            return renderNativeView("native_coupon_flip_page", new org.json.JSONObject());
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "renderFlipPageView failed: " + th.getMessage());
            return null;
        }
    }

    public android.view.View renderNativeView(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            java.util.HashMap hashMap = new java.util.HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            java.lang.Object obj = hashMap.get(str);
            if (obj instanceof android.view.View) {
                return (android.view.View) obj;
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "renderNativeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public android.view.View renderShakeView(int i, int i2, com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mAdShakeViewListener = adShakeViewListener;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("msg", "renderShakeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put("h", i2);
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            java.util.HashMap hashMap = new java.util.HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            java.lang.Object obj = hashMap.get("shake_view");
            if (obj instanceof android.view.View) {
                return (android.view.View) obj;
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "renderShakeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public android.view.View renderSlideView(int i, int i2, int i3, com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mAdShakeViewListener = adShakeViewListener;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put("h", i2);
            jSONObject.put("repeat", i3);
            return renderNativeView("native_slide_view", jSONObject);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "renderSlideView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        com.baidu.mobads.sdk.internal.a aVar;
        if (!this.isDownloadApp || this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        org.json.JSONObject U = aVar.U();
        try {
            U.put("msg", "resumeDownload");
        } catch (org.json.JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    public void setAdActionType(int i) {
        this.mAdActionType = i;
    }

    public void setAdCloseListener(com.baidu.mobads.sdk.api.NativeResponse.AdCloseListener adCloseListener) {
        this.mAdCloseListener = adCloseListener;
    }

    public void setAdDislikeListener(com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z) {
        this.isDownloadApp = z;
    }

    public void setNoAdUniqueId(java.lang.String str) {
        this.mNoAdUniqueId = str;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void stopNativeView(android.view.View view) {
        if (this.mFeedsProd != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("msg", "stopNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("native_view", view);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().c(TAG, "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        com.baidu.mobads.sdk.internal.cq cqVar;
        if (this.mFeedsProd == null || (cqVar = this.mUriUtils) == null) {
            return;
        }
        java.lang.String c = cqVar.c("http://union.baidu.com/");
        org.json.JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("unionUrl", c);
            U.put("msg", "unionLogoClick");
        } catch (java.lang.Throwable unused) {
        }
        this.mFeedsProd.a(U);
    }
}
