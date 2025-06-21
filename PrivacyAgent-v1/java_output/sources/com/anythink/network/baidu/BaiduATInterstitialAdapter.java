package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATInterstitialAdapter extends com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter {
    private static final java.lang.String f = com.anythink.network.baidu.BaiduATInterstitialAdapter.class.getSimpleName();
    com.baidu.mobads.sdk.api.FullScreenVideoAd a;
    com.baidu.mobads.sdk.api.ExpressInterstitialAd b;
    com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener c;
    private java.lang.String g = "";
    private java.lang.String h = "";
    private java.lang.String i = "";
    private java.lang.String j = "";
    private double k = 0.0d;
    boolean d = false;
    boolean e = false;

    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f) {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(java.lang.String str) {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: ".concat(java.lang.String.valueOf(str)));
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f) {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.k(com.anythink.network.baidu.BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.h(com.anythink.network.baidu.BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.baidu.mobads.sdk.api.ExpressInterstitialListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposed() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposureFailed() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError("", "Baidu: onADExposureFailed()");
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADLoaded() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheFailed() {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheSuccess() {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.x(com.anythink.network.baidu.BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClick() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClose() {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdFailed(int i, java.lang.String str) {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onNoAd(int i, java.lang.String str) {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), "onNoAd:".concat(java.lang.String.valueOf(str)));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener {
        public AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClick() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClose() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass4(android.content.Context context, java.util.Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                com.anythink.network.baidu.BaiduATInterstitialAdapter.a(com.anythink.network.baidu.BaiduATInterstitialAdapter.this, this.a, this.b);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                if (com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener != null) {
                    com.anythink.network.baidu.BaiduATInterstitialAdapter.this.mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                }
            }
        }
    }

    private void a() {
        double d;
        if (!this.e) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.FullScreenVideoAd fullScreenVideoAd = this.a;
            if (fullScreenVideoAd == null) {
                notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = fullScreenVideoAd.getECPMLevel();
            if (android.text.TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            try {
                d = java.lang.Double.parseDouble(eCPMLevel);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            if (d <= 0.0d) {
                notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
                return;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(this.a);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = this.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        char c;
        java.lang.String str = this.j;
        int hashCode = str.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && str.equals("2")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("1")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass1 anonymousClass1 = new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass1();
            this.c = anonymousClass1;
            this.a = new com.baidu.mobads.sdk.api.FullScreenVideoAd(context, this.h, anonymousClass1, false);
            if (this.e && this.k > 0.0d) {
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    new java.lang.StringBuilder("setBidFloor:").append((int) this.k);
                }
                this.a.setBidFloor((int) this.k);
            }
            com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
            com.anythink.network.baidu.BaiduATInitManager.getInstance();
            com.anythink.network.baidu.BaiduATInitManager.a(builder, map);
            this.a.setRequestParameters(builder.build());
            this.a.load();
            return;
        }
        this.b = new com.baidu.mobads.sdk.api.ExpressInterstitialAd(context.getApplicationContext(), this.h);
        if (this.e && this.k > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) (this.k * 100.0d));
            }
            this.b.setBidFloor((int) (this.k * 100.0d));
        }
        this.b.setLoadListener(new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass2());
        this.b.setDownloadListener(new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass3());
        this.b.setDialogFrame(this.d);
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder2 = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder2, map);
        this.b.setRequestParameters(builder2.build());
        this.b.load();
    }

    public static /* synthetic */ void a(com.anythink.network.baidu.BaiduATInterstitialAdapter baiduATInterstitialAdapter, android.content.Context context, java.util.Map map) {
        char c;
        java.lang.String str = baiduATInterstitialAdapter.j;
        int hashCode = str.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && str.equals("2")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("1")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass1 anonymousClass1 = baiduATInterstitialAdapter.new AnonymousClass1();
            baiduATInterstitialAdapter.c = anonymousClass1;
            baiduATInterstitialAdapter.a = new com.baidu.mobads.sdk.api.FullScreenVideoAd(context, baiduATInterstitialAdapter.h, anonymousClass1, false);
            if (baiduATInterstitialAdapter.e && baiduATInterstitialAdapter.k > 0.0d) {
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    new java.lang.StringBuilder("setBidFloor:").append((int) baiduATInterstitialAdapter.k);
                }
                baiduATInterstitialAdapter.a.setBidFloor((int) baiduATInterstitialAdapter.k);
            }
            com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
            com.anythink.network.baidu.BaiduATInitManager.getInstance();
            com.anythink.network.baidu.BaiduATInitManager.a(builder, (java.util.Map<java.lang.String, java.lang.Object>) map);
            baiduATInterstitialAdapter.a.setRequestParameters(builder.build());
            baiduATInterstitialAdapter.a.load();
            return;
        }
        baiduATInterstitialAdapter.b = new com.baidu.mobads.sdk.api.ExpressInterstitialAd(context.getApplicationContext(), baiduATInterstitialAdapter.h);
        if (baiduATInterstitialAdapter.e && baiduATInterstitialAdapter.k > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) (baiduATInterstitialAdapter.k * 100.0d));
            }
            baiduATInterstitialAdapter.b.setBidFloor((int) (baiduATInterstitialAdapter.k * 100.0d));
        }
        baiduATInterstitialAdapter.b.setLoadListener(baiduATInterstitialAdapter.new AnonymousClass2());
        baiduATInterstitialAdapter.b.setDownloadListener(baiduATInterstitialAdapter.new AnonymousClass3());
        baiduATInterstitialAdapter.b.setDialogFrame(baiduATInterstitialAdapter.d);
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder2 = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder2, (java.util.Map<java.lang.String, java.lang.Object>) map);
        baiduATInterstitialAdapter.b.setRequestParameters(builder2.build());
        baiduATInterstitialAdapter.b.load();
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.g = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.j = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.k = java.lang.Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (java.lang.Throwable unused) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.d = java.lang.Boolean.parseBoolean(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        this.i = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
    }

    private void b() {
        double d;
        if (!this.e) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.ExpressInterstitialAd expressInterstitialAd = this.b;
            if (expressInterstitialAd == null) {
                notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = expressInterstitialAd.getECPMLevel();
            if (android.text.TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            try {
                d = java.lang.Double.parseDouble(eCPMLevel);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(this.b);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = this.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void b(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass1 anonymousClass1 = new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass1();
        this.c = anonymousClass1;
        this.a = new com.baidu.mobads.sdk.api.FullScreenVideoAd(context, this.h, anonymousClass1, false);
        if (this.e && this.k > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) this.k);
            }
            this.a.setBidFloor((int) this.k);
        }
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder, map);
        this.a.setRequestParameters(builder.build());
        this.a.load();
    }

    private void c(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.b = new com.baidu.mobads.sdk.api.ExpressInterstitialAd(context, this.h);
        if (this.e && this.k > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) (this.k * 100.0d));
            }
            this.b.setBidFloor((int) (this.k * 100.0d));
        }
        this.b.setLoadListener(new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass2());
        this.b.setDownloadListener(new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass3());
        this.b.setDialogFrame(this.d);
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder, map);
        this.b.setRequestParameters(builder.build());
        this.b.load();
    }

    public static /* synthetic */ void h(com.anythink.network.baidu.BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        double d;
        if (!baiduATInterstitialAdapter.e) {
            if (baiduATInterstitialAdapter.mLoadListener != null) {
                baiduATInterstitialAdapter.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATInterstitialAdapter.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.FullScreenVideoAd fullScreenVideoAd = baiduATInterstitialAdapter.a;
            if (fullScreenVideoAd == null) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = fullScreenVideoAd.getECPMLevel();
            if (android.text.TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            try {
                d = java.lang.Double.parseDouble(eCPMLevel);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            if (d <= 0.0d) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
                return;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(baiduATInterstitialAdapter.a);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = baiduATInterstitialAdapter.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    public static /* synthetic */ int k(com.anythink.network.baidu.BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        baiduATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    public static /* synthetic */ void x(com.anythink.network.baidu.BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        double d;
        if (!baiduATInterstitialAdapter.e) {
            if (baiduATInterstitialAdapter.mLoadListener != null) {
                baiduATInterstitialAdapter.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATInterstitialAdapter.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.ExpressInterstitialAd expressInterstitialAd = baiduATInterstitialAdapter.b;
            if (expressInterstitialAd == null) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = expressInterstitialAd.getECPMLevel();
            if (android.text.TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            try {
                d = java.lang.Double.parseDouble(eCPMLevel);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(baiduATInterstitialAdapter.b);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = baiduATInterstitialAdapter.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    public void destory() {
        if (this.a != null) {
            this.a = null;
            this.c = null;
        }
        com.baidu.mobads.sdk.api.ExpressInterstitialAd expressInterstitialAd = this.b;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
            this.b = null;
        }
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.h;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        char c;
        java.lang.String str = this.j;
        int hashCode = str.hashCode();
        if (hashCode != 49) {
            if (hashCode == 50 && str.equals("2")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("1")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            com.baidu.mobads.sdk.api.ExpressInterstitialAd expressInterstitialAd = this.b;
            if (expressInterstitialAd != null) {
                return expressInterstitialAd.isReady();
            }
        } else {
            com.baidu.mobads.sdk.api.FullScreenVideoAd fullScreenVideoAd = this.a;
            if (fullScreenVideoAd != null) {
                return fullScreenVideoAd.isReady();
            }
        }
        return false;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.g = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.j = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.k = java.lang.Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (java.lang.Throwable unused) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.d = java.lang.Boolean.parseBoolean(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        this.i = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        if (android.text.TextUtils.isEmpty(this.g) || android.text.TextUtils.isEmpty(this.h)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
            return;
        }
        if ((android.text.TextUtils.isEmpty(this.j) || this.j.equals("0")) && !(context instanceof android.app.Activity)) {
            notifyATLoadFail("", "Baidu InterstitialAd context must be activity.");
        } else {
            com.anythink.network.baidu.BaiduATInitManager.getInstance().initSDK(context.getApplicationContext(), map, android.text.TextUtils.equals("0", this.j), new com.anythink.network.baidu.BaiduATInterstitialAdapter.AnonymousClass4(context, map));
        }
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:2:0x0000, B:9:0x0026, B:11:0x002a, B:15:0x002e, B:17:0x0032, B:20:0x000f, B:23:0x0019), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:2:0x0000, B:9:0x0026, B:11:0x002a, B:15:0x002e, B:17:0x0032, B:20:0x000f, B:23:0x0019), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void show(android.app.Activity activity) {
        char c;
        try {
            java.lang.String str = this.j;
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals("2")) {
                    c = 1;
                    if (c == 0) {
                        com.baidu.mobads.sdk.api.ExpressInterstitialAd expressInterstitialAd = this.b;
                        if (expressInterstitialAd != null) {
                            expressInterstitialAd.show(activity);
                            return;
                        }
                        return;
                    }
                    com.baidu.mobads.sdk.api.FullScreenVideoAd fullScreenVideoAd = this.a;
                    if (fullScreenVideoAd != null) {
                        fullScreenVideoAd.show(activity);
                        return;
                    }
                    return;
                }
                c = 65535;
                if (c == 0) {
                }
            } else {
                if (str.equals("1")) {
                    c = 0;
                    if (c == 0) {
                    }
                }
                c = 65535;
                if (c == 0) {
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.e = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
